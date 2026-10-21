# Enabling Official (Microsoft) Account Login

<!-- #BEGIN LANGUAGE_SWITCHER -->
**English** | 中文 ([简体](OfficialLogin_zh_Hans.md), [繁體](OfficialLogin_zh_Hant.md))
<!-- #END LANGUAGE_SWITCHER -->

gozMCL can log in with a real (正版) Microsoft account, but only when a Microsoft OAuth client ID is built into the jar.
The login button is disabled and shows a "unofficial build" hint when the client ID is missing.

## Option A (recommended): use the upstream public client ID

The public client ID used by official HMCL builds — `6a3728d6-27a3-4180-99bb-479895b8f88e` — is registered with the
redirect URIs gozMCL needs, so it just works. gozMCL release builds ship with this ID baked in.

```sh
./gradlew :gozMCL:shadowJar -Phmcl.microsoft.auth.id=6a3728d6-27a3-4180-99bb-479895b8f88e
```

No Azure account or app registration required. (Note: newly self-registered apps have a very low
rate limit on `login_with_xbox` and return HTTP 429 after a handful of login attempts — prefer the
public ID, or wait out the limit window.)

## How the client ID is read

At runtime the launcher reads, in order:

1. JVM system property `-Dhmcl.microsoft.auth.id=<id>`
2. Jar manifest attribute `hmcl.microsoft.auth.id` (baked in at build time)
3. Falls back to empty string → Microsoft login disabled

## 1. Register a Microsoft app

1. Go to [Microsoft Entra admin center → App registrations → New registration](https://entra.microsoft.com/#view/Microsoft_AAD_RegisteredApplications/_AppExtensionsBlade?appid=/applications).
2. Name: anything you like (e.g. `gozMCL`).
3. **Supported account types**: pick *Accounts in any organizational directory (any Microsoft Azure AD tenant v2.0) and personal Microsoft accounts* so both work.
4. **Redirect URI**: choose the platform *Mobile, desktop, and single-page applications (public client)* and add
   **both** `http://localhost` and `http://localhost/auth-response`.
   - The launcher opens a local loopback server on one of the fixed ports 29111–29115 and sends
     `http://localhost:<port>/auth-response`. Microsoft accepts any loopback port for public clients,
     but the **path must match a registered value exactly**, so the path-form URI is required.
5. Copy the **Application (client) ID**. No client secret is required (public client + PKCE).

## 2. Build with the client ID

Either set the environment variable (the original mechanism, used by CI):

```sh
MICROSOFT_AUTH_ID=<your-client-id> ./gradlew :gozMCL:shadowJar
```

or pass it as a Gradle property:

```sh
./gradlew :gozMCL:shadowJar -Phmcl.microsoft.auth.id=<your-client-id>
```

When the value is empty the build prints a `hmcl.microsoft.auth.id is empty` warning.

## 3. Run

```sh
java -jar gozMCL.jar
```

*Account management → Microsoft account*: the login button is now enabled. The flow opens a browser for
authorization (or offers device-code login for headless systems), then the browser is redirected to the local
`http://localhost:<port>/auth-response` page, which completes the sign-in.

Tip: you can also override the client ID per run without rebuilding, via
`java -Dhmcl.microsoft.auth.id=<your-client-id> -jar gozMCL.jar`.
