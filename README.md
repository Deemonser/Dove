功能：

1. @DLog() 打印方法名称及参数，并打印调用所需的时间，打印返回的参数
2. DLog 使用策略模式，能替换到其他日志框架，其本身不具备打印功能
3. 默认实现 系统Log的策略、logger策略
4. 可以输出日志到文件
5. 对外扩展，提供开关、


### 使用
因为 Dove 使用了便于应用 AspectJ 的开源库 [gradle_plugin_android_aspectjx](https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx) ，所以需要配置这个插件。
1. 在根项目的 build.gradle 中添加
```groovy
    dependencies {
        ...
        classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:1.0.8'
    }

    allprojects {
        repositories {
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }
```
2. 在 app 的 build.gradle 中添加依赖
```groovy
apply plugin: 'android-aspectjx'

dependencies {
    compile 'com.github.Deemonser:Dove:v0.1.0'
}
```
3. 使用时，直接在方法上添加注解`@Dove` 。