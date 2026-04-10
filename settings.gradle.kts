pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.aliyun.com/repository/public") }  // 阿里云镜像
        maven { url = uri("https://jcenter.bintray.com/") }  // 备用 jcenter
    }
}

rootProject.name = "blbl-android"
include(":app")

