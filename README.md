## 第一章 进阶基础
-----------------------------------------------------
### 1.4 深入解析View动画原理

[AnimationPlayer](https://github.com/SpikeKing/AnimationPlayer)

![](https://upload-images.jianshu.io/upload_images/3304008-cd852f2445c1a990.gif?imageMogr2/auto-orient/strip)


## 第二章 高阶控件
-----------------------------------------------------

### 2.1 AppBarLayout

[TestAppBar项目源地址](https://github.com/SpikeKing/TestAppBar)

![](https://upload-images.jianshu.io/upload_images/3304008-5e577644e2f5adb1.gif?imageMogr2/auto-orient/strip)

### 2.2 CoordinatroLayout 开发技术

[TestCoordinatorLayout](https://github.com/SpikeKing/TestCoordinatorLayout)
![](https://upload-images.jianshu.io/upload_images/3304008-a22c3b4e34e87699.gif?imageMogr2/auto-orient/strip)


### 2.3 ConstraintLayoutDemo 开发技术
[ConstraintLayoutDemo](https://github.com/SpikeKing/ConstraintLayoutDemo)

![](https://upload-images.jianshu.io/upload_images/3304008-99f678e1582b0953.gif?imageMogr2/auto-orient/strip)

## 第三章 项目架构
-----------------------------------------------------

### 3.2 顶成设计基于 Flux 的流式架构

[MyFluxApp-TodoList](https://github.com/SpikeKing/MyFluxApp-TodoList)

![](https://upload-images.jianshu.io/upload_images/3304008-6c2bc30d72fb9c7d.gif?imageMogr2/auto-orient/strip)

## 第四章 响应式编程
-----------------------------------------------------

### 4.1 RxJava

[TestDetailRxAndroid](https://github.com/SpikeKing/TestDetailRxAndroid)

![](https://upload-images.jianshu.io/upload_images/3304008-a86d6ea5a61ff598.gif?imageMogr2/auto-orient/strip)

## 第五章 炫酷的功能
-----------------------------------------------------

### 5.1 视频滚动列表

[wcl-video-list-demo-master](https://github.com/SpikeKing/wcl-video-list-demo)

![](https://upload-images.jianshu.io/upload_images/3304008-0cedc5946dfd9181.gif?imageMogr2/auto-orient/strip)

### 5.2 基于DialogFragment底部弹窗

[BottomDialogDemo-master](https://github.com/SpikeKing/BottomDialogDemo)

![](https://upload-images.jianshu.io/upload_images/3304008-fb58d8fb7ccaf248.gif?imageMogr2/auto-orient/strip)

## 第六章 精美动画
-----------------------------------------------------

### 6.1 页面中切换元素分享的动画效果

[wcl-onboarding-demo](https://github.com/SpikeKing/wcl-onboarding-demo)

![](https://upload-images.jianshu.io/upload_images/3304008-7cbf2dfa62d772b9.gif?imageMogr2/auto-orient/strip)

### 6.2 界面展开中原型爆裂的效果

[wcl-circle-reveal-demo](https://github.com/SpikeKing/wcl-circle-reveal-demo)

![](https://upload-images.jianshu.io/upload_images/3304008-4b0dfc42b8074e68.gif?imageMogr2/auto-orient/strip)


## 第七章 Kotlin 与 SVG
-----------------------------------------------------

### 7.1 Kotlin基础教程

[wcl-kotlin-demo](https://github.com/SpikeKing/wcl-kotlin-demo)

![](https://upload-images.jianshu.io/upload_images/3304008-a6e7249ae75fe495.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 7.2 SVG图像技术
[TestSVG](https://github.com/SpikeKing/TestSVG)

![](https://upload-images.jianshu.io/upload_images/3304008-51208f4cd435a456.gif?imageMogr2/auto-orient/strip)

## 第八章 测试与优化
-----------------------------------------------------

### 8.1 基于 Espresso 和 Dagger 的自动化测试框架

[wcl-espresso-dagger-demo](https://github.com/SpikeKing/wcl-espresso-dagger-demo)

### 8.2 优化内存泄露与电量消耗的技术框架

[wcl-leakcanary-demo](https://github.com/SpikeKing/wcl-leakcanary-demo)

### 8.2.2 电量优化
[battery-historian](https://github.com/google/battery-historian)
## 修改的部分
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```

```
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-4.6-all.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
```

```
javaCompileOptions { annotationProcessorOptions { includeCompileClasspath = true } }
```

lambda注释掉老的配置
```
//plugins {
//    id "me.tatarka.retrolambda" version "3.2.5"
//}
```

kotlin 的配置
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.2.71'
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

-------------------------------
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
```

## Plugin with id 'com.neenbedankt.android-apt' not found.
```
classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'删掉

和modul下的apply plugin: 'com.neenbedankt.android-apt'删掉

 apt 'com.google.dagger:dagger-compiler:2.2'

把apt改成annotationProcessor
```
