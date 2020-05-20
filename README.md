#### Guava使用代码示例

Guava是来自Google的Java库合集，包含了很多新的集合类型（比如multinmap和mulitset），不可变集合，图库和并发、I/O、哈希、缓存、原始类型等类型的工具集。Guava广泛的使用在Google的大部分Javagon项目中，也被其他的公司广泛采用。
Guava有两种使用方式：

 - **JRE方式**，需要JDK1.8或者更高版本
 - 如果想要在JDK1.7或者Android中使用，需要采用**Android方式**。

Guava的Maven group ID 是 `com.google.guava`， artifact ID是`guava`。
若是使用Maven构建你的项目，你可以使用如下方式添加Guava依赖

    <dependency>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
      <version>29.0-jre</version>
      <!-- or, for Android: -->
      <version>29.0-android</version>
    </dependency>
使用Gradle构建项目则采用如下方式

    dependencies {
      // Pick one:
    
      // 1. Use Guava in your implementation only:
      implementation("com.google.guava:guava:29.0-jre")
    
      // 2. Use Guava types in your public API:
      api("com.google.guava:guava:29.0-jre")
    
      // 3. Android - Use Guava in your implementation only:
      implementation("com.google.guava:guava:29.0-android")
    
      // 4. Android - Use Guava types in your public API:
      api("com.google.guava:guava:29.0-android")
    }

 如果想了解更多Guava的内容，请访问Guava [Github地址][1]


  [1]: https://github.com/google/guava