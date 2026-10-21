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
MICROSOFT_AUTH_ID=<你的 Azure 应用客户端 ID> ./gradlew :HMCL:shadowJar
# 或等价的 Gradle 属性方式
./gradlew :HMCL:shadowJar -Phmcl.microsoft.auth.id=<你的 Azure 应用客户端 ID>
```

产物位于 `HMCL/build/libs/`。

如何注册微软应用（获取客户端 ID）见 [docs/OfficialLogin_zh_Hans.md](docs/OfficialLogin_zh_Hans.md)。

## 文档

- [使用文档（中文）](docs/README_zh_Hans.md) / [English](docs/README.md)
- [启用正版账号登录](docs/OfficialLogin_zh_Hans.md) / [English](docs/OfficialLogin.md)
- [贡献指南](docs/Contributing_zh_Hans.md) / [English](docs/Contributing.md)

## 致谢

gozMCL 基于 [HMCL](https://github.com/HMCL-dev/HMCL)（GPL v3）fork 而来，
感谢 HMCL 团队及所有开源贡献者的工作。
