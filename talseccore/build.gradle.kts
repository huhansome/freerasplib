// talsec-core/build.gradle.kts
// 1. 创建一个默认的 Gradle 构件配置集
configurations.maybeCreate("default")

// 2. 告诉 Gradle，这个子模块本身就代表了这个物理 AAR 文件
artifacts.add("default", file("TalsecSecurity-Community-18.3.0.aar"))
