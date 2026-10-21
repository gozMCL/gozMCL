# 啟用正版（微軟）帳號登入

<!-- #BEGIN LANGUAGE_SWITCHER -->
**English** ([OfficialLogin.md](OfficialLogin.md)) | 中文 ([簡體](OfficialLogin_zh_Hans.md))
<!-- #END LANGUAGE_SWITCHER -->

gozMCL 支援登入正版（微軟）帳號，但前提是構建時把微軟 OAuth 用戶端 ID 裝進 jar。
缺少用戶端 ID 時，登入按鈕會被停用，並顯示「非官方構建」提示。

## 方案 A（推薦）：直接使用上游公用戶端 ID

官方 HMCL 構建使用的公用戶端 ID `6a3728d6-27a3-4180-99bb-479895b8f88e` 已註冊好
gozMCL 所需的全部重新導向 URI，拿來即用。gozMCL 的發布構建預設內置該 ID。

```sh
./gradlew :gozMCL:shadowJar -Phmcl.microsoft.auth.id=6a3728d6-27a3-4180-99bb-479895b8f88e
```

無需 Azure 帳號、無需註冊應用。（注意：自己新註冊的應用在 `login_with_xbox`
上速率限制很低，多次登入嘗試後會返回 HTTP 429——優先使用公用戶端 ID，或等限流窗口過去。）

## 用戶端 ID 的讀取順序

執行時依序讀取：

1. JVM 系統屬性 `-Dhmcl.microsoft.auth.id=<id>`
2. jar manifest 中的 `hmcl.microsoft.auth.id`（構建時注入）
3. 兜底為空 → 微軟登入被停用

## 1. 註冊一個微軟應用

1. 開啟[微軟 Entra 管理中心 → 應用註冊 → 新註冊](https://entra.microsoft.com/#view/Microsoft_AAD_RegisteredApplications/_AppExtensionsBlade?appid=/applications)。
2. 名稱：隨意（例如 `gozMCL`）。
3. **支援的帳戶類型**：選擇 *任何組織目錄（任何 Microsoft Azure AD 租戶 v2.0）中的帳戶與個人 Microsoft 帳戶*，這樣兩類帳號都能用。
4. **重新導向 URI**：平台選 *行動裝置、桌面與單頁應用程式（公共用戶端）*，**兩條都加**：
   `http://localhost` 與 `http://localhost/auth-response`。
   - 啟動器會在固定埠 29111–29115 之一開啟本地環回服務，發送
     `http://localhost:<埠號>/auth-response`。微軟對公共用戶端允許任意環回埠號，
     但**路徑必須與註冊值精確匹配**，所以帶路徑的這一條不能少。
5. 複製 **應用程式（用戶端）ID**。無需用戶端密碼（公共用戶端 + PKCE）。

## 2. 構建時注入用戶端 ID

方式一：設定環境變數（原有機制，CI 使用）：

```sh
MICROSOFT_AUTH_ID=<你的用戶端ID> ./gradlew :gozMCL:shadowJar
```

方式二：作為 Gradle 屬性傳入：

```sh
./gradlew :gozMCL:shadowJar -Phmcl.microsoft.auth.id=<你的用戶端ID>
```

取值為空時，構建會印出 `hmcl.microsoft.auth.id is empty` 警告。

## 3. 執行

```sh
java -jar gozMCL.jar
```

*帳戶管理 → 微軟帳戶*：登入按鈕此時可用。流程會開啟瀏覽器完成授權
（無桌面環境時提供裝置碼登入），隨後瀏覽器被重新導向到本地
`http://localhost:<埠號>/auth-response` 頁面完成登入。

小技巧：也可以不重新構建，每次執行時用
`java -Dhmcl.microsoft.auth.id=<你的用戶端ID> -jar gozMCL.jar` 臨時指定用戶端 ID。
