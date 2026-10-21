# 启用正版（微软）账号登录

<!-- #BEGIN LANGUAGE_SWITCHER -->
**English** ([OfficialLogin.md](OfficialLogin.md)) | 中文 ([繁體](OfficialLogin_zh_Hant.md))
<!-- #END LANGUAGE_SWITCHER -->

gozMCL 支持登录正版（微软）账号，但前提是构建时把微软 OAuth 客户端 ID 打进 jar。
缺少客户端 ID 时，登录按钮会被禁用，并显示「非官方构建」提示。

## 方案 A（推荐）：直接使用上游公共客户端 ID

官方 HMCL 构建使用的公共客户端 ID `6a3728d6-27a3-4180-99bb-479895b8f88e` 已注册好
gozMCL 所需的全部重定向 URI，拿来即用。gozMCL 的发布构建默认内置该 ID。

```sh
./gradlew :gozMCL:shadowJar -Phmcl.microsoft.auth.id=6a3728d6-27a3-4180-99bb-479895b8f88e
```

无需 Azure 账号、无需注册应用。（注意：自己新注册的应用在 `login_with_xbox`
上速率限制很低，多次登录尝试后会返回 HTTP 429——优先使用公共 ID，或等限流窗口过去。）

## 客户端 ID 的读取顺序

运行时依次读取：

1. JVM 系统属性 `-Dhmcl.microsoft.auth.id=<id>`
2. jar manifest 中的 `hmcl.microsoft.auth.id`（构建时注入）
3. 兜底为空 → 微软登录被禁用

## 1. 注册一个微软应用

1. 打开[微软 Entra 管理中心 → 应用注册 → 新注册](https://entra.microsoft.com/#view/Microsoft_AAD_RegisteredApplications/_AppExtensionsBlade?appid=/applications)。
2. 名称：随意（例如 `gozMCL`）。
3. **支持的帐户类型**：选择 *任何组织目录（任何 Microsoft Azure AD 租户 v2.0）中的帐户和个人 Microsoft 帐户*，这样两类账号都能用。
4. **重定向 URI**：平台选 *移动、桌面和单页应用（公共客户端）*，**两条都加**：
   `http://localhost` 和 `http://localhost/auth-response`。
   - 启动器会在固定端口 29111–29115 之一上开本地回环服务，发送
     `http://localhost:<端口>/auth-response`。微软对公共客户端允许任意回环端口，
     但**路径必须与注册值精确匹配**，所以带路径的这条不能少。
5. 复制 **应用程序（客户端）ID**。无需客户端密钥（公共客户端 + PKCE）。

## 2. 构建时注入客户端 ID

方式一：设置环境变量（原有机制，CI 使用）：

```sh
MICROSOFT_AUTH_ID=<你的客户端ID> ./gradlew :gozMCL:shadowJar
```

方式二：作为 Gradle 属性传入：

```sh
./gradlew :gozMCL:shadowJar -Phmcl.microsoft.auth.id=<你的客户端ID>
```

取值为空时，构建会打印 `hmcl.microsoft.auth.id is empty` 警告。

## 3. 运行

```sh
java -jar gozMCL.jar
```

*账户管理 → 微软账户*：登录按钮此时可用。流程会打开浏览器完成授权
（无桌面环境时提供设备码登录），随后浏览器被重定向到本地
`http://localhost:<端口>/auth-response` 页面完成登录。

小技巧：也可以不重新构建，每次运行时用
`java -Dhmcl.microsoft.auth.id=<你的客户端ID> -jar gozMCL.jar` 临时指定客户端 ID。
