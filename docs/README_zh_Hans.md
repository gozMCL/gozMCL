<!-- #BEGIN COPY -->
<!-- #PROPERTY NAME=TITLE -->
<div align="center">
    <img src="/HMCL/src/main/resources/assets/img/icon@8x.png" alt="gozMCL Logo" width="64"/>
</div>

<h1 align="center">gozMCL</h1>
<!-- #END COPY -->

<!-- #BEGIN COPY -->
<!-- #PROPERTY NAME=BADGES -->
<div align="center">

[![GitHub](https://img.shields.io/badge/GitHub-repo-blue?style=flat-square&logo=github)](https://github.com/xhdndmm/gozMCL)

[![QQ Group](https://img.shields.io/badge/QQ-gray?style=flat-square&logo=qq&logoColor=ffffff)](https://docs.hmcl.net/groups.html)
[![Discord](https://img.shields.io/badge/Discord-gray?style=flat-square&logo=discord)](https://discord.gg/jVvC7HfM6U)
[![Bilibili](https://img.shields.io/badge/Bilibili-gray?style=flat-square&logo=bilibili)](https://space.bilibili.com/20314891)

</div>
<!-- #END COPY -->

---

<!-- #BEGIN LANGUAGE_SWITCHER -->
English ([Standard](README.md), [uʍoᗡ ǝpᴉsd∩](README_en_Qabs.md)) | **中文** (**简体**, [繁體](README_zh_Hant.md), [文言](README_lzh.md)) | [日本語](README_ja.md) | [español](README_es.md) | [русский](README_ru.md) | [українська](README_uk.md)
<!-- #END LANGUAGE_SWITCHER -->

## 简介

gozMCL 是一款开源、跨平台的 Minecraft 启动器，支持模组管理、游戏自定义、游戏自动安装 (Forge、NeoForge、Cleanroom、Fabric、Legacy Fabric、Quilt、LiteLoader 和 OptiFine)、整合包创建、界面自定义等功能。

gozMCL 有着强大的跨平台能力。它不仅支持 Windows、Linux、macOS、FreeBSD 等常见的操作系统，同时也支持 x86、ARM、RISC-V、MIPS、LoongArch 等不同的 CPU 架构。你可以使用 gozMCL 在不同平台上轻松地游玩 Minecraft。

如果你想要了解 gozMCL 对不同平台的支持程度，请参见 [此表格](PLATFORM_zh_Hans.md)。

## 关于 gozMCL

gozMCL 是基于 [HMCL](https://github.com/HMCL-dev/HMCL) 的独立维护分支（fork），与上游的主要差异：

- **不再禁用中国大陆地区的游戏下载**。已移除基于地区检测的下载限制，中国大陆网络环境下优先使用国内镜像源，可正常下载游戏。
- **支持正版（微软）账号登录**。若要在编译产物中登录正版微软账号，需要在构建时注入微软 OAuth 客户端 ID，详见[启用正版账号登录](OfficialLogin_zh_Hans.md)。

构建 gozMCL 需要 JDK 17 或更高版本（推荐 21），具体方法见[贡献指南](Contributing_zh_Hans.md#构建-gozmcl)。

## 下载

你可以从这些渠道下载 gozMCL：

- [GitHub Release](https://github.com/xhdndmm/gozMCL/releases)

## 参与贡献

gozMCL 是一个社区驱动的开源项目，欢迎任何人参与贡献代码或提出建议。

你可以通过以下方式参与 gozMCL 的开发：

- 通过在 GitHub 上[创建 Issue](https://github.com/xhdndmm/gozMCL/issues/new/choose) 来报告 Bug 或提出功能请求。
- 通过在 GitHub 上 Fork 仓库并[提交 Pull Request](https://github.com/xhdndmm/gozMCL/compare) 来贡献代码。

在参与贡献前，请阅读[贡献指南](./Contributing_zh_Hans.md)，其中包含以下内容：

- [如何从源码构建并运行 gozMCL](./Contributing_zh_Hans.md#构建-hmcl)
- [通过调试选项调整 gozMCL 的行为](./Contributing_zh_Hans.md#调试选项)

## 贡献者

自 2015 年以来，gozMCL 已经有超过 130 位贡献者参与其中，感谢他们的辛勤付出！

[![Contributors](https://contrib.rocks/image?repo=gozMCL-dev/gozMCL&max=200)](https://github.com/xhdndmm/gozMCL/graphs/contributors)

## 开源协议

该程序在 [GPLv3](https://www.gnu.org/licenses/gpl-3.0.html) 开源协议下发布，同时附有以下附加条款。

### 附加条款 (依据 GPLv3 开源协议第七条)

1. 当你分发该程序的修改版本时，你必须以一种合理的方式修改该程序的名称或版本号，以示其与原始版本不同。(
   依据 [GPLv3, 7(c)](https://github.com/xhdndmm/gozMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L372-L374))

   该程序的名称及版本号可在 [此处](https://github.com/xhdndmm/gozMCL/blob/86529c6f15b3be54ed8d89ece47566cf57f43eb7/HMCL/src/main/java/org/jackhuang/hmcl/Metadata.java#L36-L38) 修改。

2. 你不得移除该程序所显示的版权声明。(依据 [GPLv3, 7(b)](https://github.com/xhdndmm/gozMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L368-L370))
