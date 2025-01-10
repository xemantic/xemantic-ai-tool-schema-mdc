# xemantic-ai-tool-schema-mdc
Adapting [xemantic-ai-tool-schema](https://github.com/xemantic/xemantic-ai-tool-schema) to Model Context Protocol kotlin-sdk Tool input.

[<img alt="Maven Central Version" src="https://img.shields.io/maven-central/v/com.xemantic.ai/xemantic-ai-tool-schema-mdc">](https://central.sonatype.com/namespace/com.xemantic.ai)
[<img alt="GitHub Release Date" src="https://img.shields.io/github/release-date/xemantic/xemantic-ai-tool-schema-mdc">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/releases)
[<img alt="license" src="https://img.shields.io/github/license/xemantic/xemantic-ai-tool-schema-mdc?color=blue">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/blob/main/LICENSE)

[<img alt="GitHub Actions Workflow Status" src="https://img.shields.io/github/actions/workflow/status/xemantic/xemantic-ai-tool-schema-mdc/build-main.yml">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/actions/workflows/build-main.yml)
[<img alt="GitHub branch check runs" src="https://img.shields.io/github/check-runs/xemantic/xemantic-ai-tool-schema-mdc/main">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/actions/workflows/build-main.yml)
[<img alt="GitHub commits since latest release" src="https://img.shields.io/github/commits-since/xemantic/xemantic-ai-tool-schema-mdc/latest">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/commits/main/)
[<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/xemantic/xemantic-ai-tool-schema-mdc">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/commits/main/)

[<img alt="GitHub contributors" src="https://img.shields.io/github/contributors/xemantic/xemantic-ai-tool-schema-mdc">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/graphs/contributors)
[<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/t/xemantic/xemantic-ai-tool-schema-mdc">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/commits/main/)
[<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/xemantic/xemantic-ai-tool-schema-mdc">]()
[<img alt="GitHub Created At" src="https://img.shields.io/github/created-at/xemantic/xemantic-ai-tool-schema-mdc">](https://github.com/xemantic/xemantic-ai-tool-schema-mdc/commit/39c1fa4c138d4c671868c973e2ad37b262ae03c2)
[<img alt="kotlin version" src="https://img.shields.io/badge/dynamic/toml?url=https%3A%2F%2Fraw.githubusercontent.com%2Fxemantic%2Fxemantic-ai-tool-schema-mdc%2Fmain%2Fgradle%2Flibs.versions.toml&query=versions.kotlin&label=kotlin">](https://kotlinlang.org/docs/releases.html)

[<img alt="discord server" src="https://dcbadge.limes.pink/api/server/https://discord.gg/vQktqqN2Vn?style=flat">](https://discord.gg/vQktqqN2Vn)
[<img alt="discord users online" src="https://img.shields.io/discord/811561179280965673">](https://discord.gg/vQktqqN2Vn)
[<img alt="X (formerly Twitter) Follow" src="https://img.shields.io/twitter/follow/KazikPogoda">](https://x.com/KazikPogoda)

## Why?

The [kotlin-sdk](https://github.com/modelcontextprotocol/kotlin-sdk) variant of the [Model Context Protocol](https://modelcontextprotocol.io/) is expressing [JSON Schema](https://json-schema.org/) as `Tool.Input` class, which offers limited flexibility comparing
to [JsonSchema](https://github.com/xemantic/xemantic-ai-tool-schema/blob/main/src/commonMain/kotlin/JsonSchema.kt) delivered by the [xemantic-ai-tool-schema](https://github.com/xemantic/xemantic-ai-tool-schema) project.
In particular `definitions` of types cannot be expressed.
I hope `kotlin-sdk` will embrace something more versatile soon. Meanwhile, this adapter library can be used for automatic MDC-compatible JSON Schema generation out of serializable Kotlin classes. 

## Usage

### Setting up Gradle

In your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.xemantic.ai:xemantic-ai-tool-schema-mdc:0.1.1")
}
```

### Getting `Tool.Input` instance

```kotlin
@Serializable
data class Foo(
    val bar: String
)

// ...

val inputSchema: Tool.Input = mdcToolInput<Foo>()
```

See [ObjectSchemaToMdcToolInputTest](src/commonTest/kotlin/ObjectSchemaToMdcToolInputTest.kt) for details.

## Development

Clone this project, and then run:

```shell
./gradlew build
```
