<!-- #BEGIN BLOCK -->
<!-- #PROPERTY NAME=TITLE -->
<div align="center">
    <img src="/HMCL/src/main/resources/assets/img/icon@8x.png" alt="gozMCL Logo" width="64"/>
</div>

<h1 align="center">gozMCL</h1>
<!-- #END BLOCK -->

<!-- #BEGIN BLOCK -->
<!-- #PROPERTY NAME=BADGES -->
<div align="center">

[![GitHub](https://img.shields.io/badge/GitHub-repo-blue?style=flat-square&logo=github)](https://github.com/xhdndmm/gozMCL)

[![QQ Group](https://img.shields.io/badge/QQ-gray?style=flat-square&logo=qq&logoColor=ffffff)](https://docs.hmcl.net/groups.html)
[![Discord](https://img.shields.io/badge/Discord-gray?style=flat-square&logo=discord)](https://discord.gg/jVvC7HfM6U)
[![Bilibili](https://img.shields.io/badge/Bilibili-gray?style=flat-square&logo=bilibili)](https://space.bilibili.com/20314891)

</div>
<!-- #END BLOCK -->

---

<!-- #BEGIN LANGUAGE_SWITCHER -->
**English** (**Standard**, [uʍoᗡ ǝpᴉsd∩](README_en_Qabs.md)) | 中文 ([简体](README_zh_Hans.md), [繁體](README_zh_Hant.md), [文言](README_lzh.md)) | [日本語](README_ja.md) | [español](README_es.md) | [русский](README_ru.md) | [українська](README_uk.md)
<!-- #END LANGUAGE_SWITCHER -->

## Introduction

gozMCL is an open-source, cross-platform Minecraft launcher that supports Mod Management, Game Customizing, ModLoader Installing (Forge, NeoForge, Cleanroom, Fabric, Legacy Fabric, Quilt, LiteLoader, and OptiFine), Modpack Creating, UI Customization, and more.

gozMCL has amazing cross-platform capabilities. Not only does it run on different operating systems like Windows, Linux, macOS, and FreeBSD, but it also supports various CPU architectures such as x86, ARM, RISC-V, MIPS, and LoongArch. You can easily enjoy Minecraft across different platforms through gozMCL.

For systems and CPU architectures supported by gozMCL, please refer to [this table](PLATFORM.md).

## About gozMCL

gozMCL is an independently maintained fork of [HMCL](https://github.com/HMCL-dev/HMCL). Differences from upstream:

- **Game downloads are not disabled in mainland China.** The region-based download restriction was removed; when downloading on networks in mainland China, domestic mirror sources are preferred so that the game downloads normally.
- **Official (Microsoft) account login is supported.** To log in with a genuine (正版) Microsoft account in a compiled build, inject a Microsoft OAuth client ID at build time. See [Enabling Official Account Login](OfficialLogin.md).

Building gozMCL requires JDK 17 or later (21 recommended); see the [Contributing Guide](Contributing.md#build-gozmcl) for details.

## Download

You can download gozMCL from the following sources:

- [GitHub Release](https://github.com/xhdndmm/gozMCL/releases)

## Contributing

gozMCL is a community-driven open-source project, and everyone is welcome to contribute code or provide suggestions.

You can contribute to gozMCL development in the following ways:

- Report bugs or request features by [creating an issue](https://github.com/xhdndmm/gozMCL/issues/new/choose) on GitHub.
- Contribute code by forking the repository on GitHub and [submitting a pull request](https://github.com/xhdndmm/gozMCL/compare).

Before contributing, please read the [Contributing Guide](./Contributing.md), which includes the following:

- [How to build and run gozMCL from source](./Contributing.md#build-hmcl)
- [Adjusting gozMCL behavior using debug options](./Contributing.md#debug-options)

## Contributors

Since 2015, more than 130 contributors have participated in gozMCL. Thank you for your hard work!

[![Contributors](https://contrib.rocks/image?repo=gozMCL-dev/gozMCL&max=200)](https://github.com/xhdndmm/gozMCL/graphs/contributors)

## License

The software is distributed under [GPLv3](https://www.gnu.org/licenses/gpl-3.0.html) license with the following additional terms:

### Additional terms under GPLv3 Section 7

1. When you distribute a modified version of the software, you must change the software name or the version number in a reasonable way in order to distinguish it from the original version. (Under [GPLv3, 7(c)](https://github.com/xhdndmm/gozMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L372-L374))

   The software name and the version number can be edited [here](https://github.com/xhdndmm/gozMCL/blob/86529c6f15b3be54ed8d89ece47566cf57f43eb7/HMCL/src/main/java/org/jackhuang/hmcl/Metadata.java#L36-L38).

2. You must not remove the copyright declaration displayed in the software. (Under [GPLv3, 7(b)](https://github.com/xhdndmm/gozMCL/blob/11820e31a85d8989e41d97476712b07e7094b190/LICENSE#L368-L370))
