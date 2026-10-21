# gozMCL

gozMCL 是一个独立维护的 [HMCL](https://github.com/HMCL-dev/HMCL) 分支（fork），
针对中国大陆用户移除了下载限制，并支持正版（微软）账号登录。

## 特性

- ✅ **中国大陆地区可正常下载游戏**：已移除上游"在中国大陆地区禁用游戏下载功能"的限制，
  大陆网络环境下优先使用国内镜像源（BMCLAPI）下载。
- ✅ **支持登录正版（微软）账号**：编译产物支持微软账号登录，构建时注入微软 OAuth 客户端 ID 即可。
- ✅ **名称与界面文本更换为 gozMCL**：窗口标题、关于页、文档与提示文本均已更名。

## 构建

需要 JDK 17+（推荐 21）：

```sh
# 基础构建（无正版登录）
./gradlew :HMCL:shadowJar

# 启用正版（微软）账号登录
MICROSOFT_AUTH_ID=6a3728d6-27a3-4180-99bb-479895b8f88e ./gradlew :HMCL:shadowJar  # 上游 HMCL 公共客户端 ID（推荐，免注册）
# 或等价的 Gradle 属性方式
./gradlew :HMCL:shadowJar -Phmcl.microsoft.auth.id=<你的 Azure 应用客户端 ID>
```

产物位于 `HMCL/build/libs/`。

如何注册微软应用（获取客户端 ID）见 [docs/OfficialLogin_zh_Hans.md](docs/OfficialLogin_zh_Hans.md)。

## 通过 GitHub Actions 发布

仓库内置 `Create Release` workflow（`.github/workflows/release.yml`），
在 GitHub 上构建并发布 `jar / exe / sh / deb` 四种产物到 [Releases](https://github.com/xhdndmm/gozMCL/releases)。

1. 在 Settings → Secrets and variables → Actions 中添加（可选）：
   - `MICROSOFT_AUTH_ID`：微软 OAuth 客户端 ID，构建注入后启用正版账号登录；
     推荐用上游公共 ID `6a3728d6-27a3-4180-99bb-479895b8f88e`（免注册、限流配额成熟），详见 docs/OfficialLogin_zh_Hans.md；
   - `CURSEFORGE_API_KEY`：CurseForge API key。
2. 打开 Actions 页 → 选择 **Create Release** → **Run workflow**：
   - `build_number`：构建号，最终版本为 `<versionRoot>.<build_number>`
     （`versionRoot` 取自 `config/project.properties`，当前为 3.17），如 `1` → `3.17.1`，tag 为 `goz-3.17.1`；
   - `prerelease` / `draft`：标记为预发布 / 草稿（默认均为草稿，便于审核后再公开发布）。
3. 构建完成后在 Releases 页核对产物与 SHA-256，取消草稿即可公开发布。

> 注意：重复使用同一 `build_number` 会因 tag 已存在而失败，请递增构建号。

## 文档

- [使用文档（中文）](docs/README_zh_Hans.md) / [English](docs/README.md)
- [启用正版账号登录](docs/OfficialLogin_zh_Hans.md) / [English](docs/OfficialLogin.md)
- [贡献指南](docs/Contributing_zh_Hans.md) / [English](docs/Contributing.md)

## 致谢

gozMCL 基于 [HMCL](https://github.com/HMCL-dev/HMCL)（GPL v3）fork 而来，
感谢 HMCL 团队及所有开源贡献者的工作。
