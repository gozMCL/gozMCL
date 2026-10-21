# Contributing Guide

<!-- #BEGIN LANGUAGE_SWITCHER -->
**English** | 中文 ([简体](Contributing_zh_Hans.md), [繁體](Contributing_zh_Hant.md))
<!-- #END LANGUAGE_SWITCHER -->

## Build gozMCL

### Requirements

To build the gozMCL launcher, you need to install JDK 17 (or higher). You can download it here: [Download Liberica JDK](https://bell-sw.com/pages/downloads/#jdk-25-lts).

After installing the JDK, make sure the `JAVA_HOME` environment variable points to the required JDK directory.
You can check the JDK version that `JAVA_HOME` points to like this:

<details>
<summary>Windows</summary>

PowerShell:

```
PS > & "$env:JAVA_HOME/bin/java.exe" -version
openjdk version "25" 2025-09-16 LTS
OpenJDK Runtime Environment (build 25+37-LTS)
OpenJDK 64-Bit Server VM (build 25+37-LTS, mixed mode, sharing)
```

</details>

<details>
<summary>Linux/FreeBSD</summary>

```
> $JAVA_HOME/bin/java -version
openjdk version "25" 2025-09-16 LTS
OpenJDK Runtime Environment (build 25+37-LTS)
OpenJDK 64-Bit Server VM (build 25+37-LTS, mixed mode, sharing)
```

</details>

<details>
<summary>macOS</summary>

```
> /usr/libexec/java_home --exec java -version
openjdk version "25" 2025-09-16 LTS
OpenJDK Runtime Environment (build 25+37-LTS)
OpenJDK 64-Bit Server VM (build 25+37-LTS, mixed mode, sharing)
```

</details>

### Get gozMCL Source Code

- You can get the latest source code via [Git](https://git-scm.com/downloads):
  ```shell
  git clone https://github.com/gozMCL/gozMCL.git
  cd gozMCL
  ```
- You can manually download a specific version of the source code from the [GitHub Release page](https://github.com/gozMCL/gozMCL/releases).

### Build gozMCL

To build gozMCL, switch to the root directory of the gozMCL project and run the following command:

```shell
./gradlew clean makeExecutables
```

The built gozMCL program files are located in the `gozMCL/build/libs` subdirectory under the project root.

## Debug Options

> [!WARNING]
> This document describes gozMCL's internal features, which we do not guarantee to be stable and may be modified or removed at any time.
>
> Please use these features with caution, as improper use may cause gozMCL to behave abnormally or even crash.

gozMCL provides a series of debug options to control the behavior of the launcher.

These options can be specified via environment variables or JVM parameters. If both are present, JVM parameters will override the environment variable settings.

| Environment Variable        | JVM Parameter                                | Function                                                       | Default Value                                                                                                | Additional Notes                                                 |
|-----------------------------|----------------------------------------------|----------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| `gozMCL_JAVA_HOME`            |                                              | Specifies the Java used to launch gozMCL                         |                                                                                                              | Only effective for exe/sh                                        |
| `gozMCL_JAVA_OPTS`            |                                              | Specifies the default JVM parameters when launching gozMCL       |                                                                                                              | Only effective for exe/sh                                        |
| `gozMCL_FORCE_GPU`            |                                              | Specifies whether to force GPU-accelerated rendering           | `false`                                                                                                      |                                                                  |
| `gozMCL_ANIMATION_FRAME_RATE` |                                              | Specifies the animation frame rate of gozMCL                     | `60`                                                                                                         |                                                                  |
| `gozMCL_LANGUAGE`             |                                              | Specifies the default language of gozMCL                         | Uses the system default language                                                                             |                                                                  |
| `gozMCL_NATIVE_DECORATION`    | `-Dhmcl.nativeDecoration=<true/false/auto>`  | Specifies whether to use the system's native window decoration | `auto`                                                                                                       |                                                                  |
| `gozMCL_UI_SCALE`             |                                              | Specifies the UI scaling for gozMCL                              | Uses the system's current scaling                                                                            | Supports scale factor (1.5), percentage (150%), or DPI (144dpi). |
|                             | `-Dhmcl.dir=<path>`                          | Specifies the current data folder of gozMCL                      | `./.hmcl`                                                                                                    |                                                                  |
|                             | `-Dhmcl.home=<path>`                         | Specifies the user data folder of gozMCL                         | Windows: `%APPDATA%\.hmcl`<br>Linux/BSD: `$XDG_DATA_HOME/hmcl`<br>macOS: `~Library/Application Support/hmcl` |                                                                  |
|                             | `-Dhmcl.self_integrity_check.disable=true`   | Disables self-integrity checks during updates                  |                                                                                                              |                                                                  |
|                             | `-Dhmcl.bmclapi.override=<url>`              | Specifies the API Root for BMCLAPI                             | `https://bmclapi2.bangbang93.com`                                                                            |                                                                  |
|                             | `-Dhmcl.discoapi.override=<url>`             | Specifies the API Root for foojay Disco API                    | `https://api.foojay.io/disco/v3.0`                                                                           |                                                                  | 
| `gozMCL_FONT`                 | `-Dhmcl.font.override=<font family>`         | Specifies the default font for gozMCL                            | Uses the system default font                                                                                 |                                                                  |
|                             | `-Dhmcl.update_source.override=<url>`        | Specifies the update source for gozMCL                           | `https://github.com/gozMCL/gozMCL/api/update_link`                                                                |                                                                  |
|                             | `-Dhmcl.authlibinjector.location=<path>`     | Specifies the location of the authlib-injector JAR file        | Uses the built-in authlib-injector                                                                           |                                                                  |
|                             | `-Dhmcl.openjfx.repo=<maven repository url>` | Adds a custom Maven repository for downloading OpenJFX         |                                                                                                              |                                                                  |
|                             | `-Dhmcl.native.encoding=<encoding>`          | Specifies the native encoding                                  | Uses the system's native encoding                                                                            |                                                                  |
|                             | `-Dhmcl.microsoft.auth.id=<App ID>`          | Specifies the Microsoft OAuth App ID                           | Uses the built-in Microsoft OAuth App ID                                                                     |                                                                  |
|                             | `-Dhmcl.curseforge.apikey=<Api Key>`         | Specifies the CurseForge API key                               | Uses the built-in CurseForge API key                                                                         |                                                                  |
|                             | `-Dhmcl.native.backend=<auto/jna/none>`      | Specifies the native backend used by gozMCL                      | `auto`                                                                                                       |                                                                  |
|                             | `-Dhmcl.hardware.fastfetch=<true/false>`     | Specifies whether to use fastfetch for hardware detection      | `true`                                                                                                       |                                                                  |
