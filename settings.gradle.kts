pluginManagement {
    includeBuild("reactNative/node_modules/@react-native/gradle-plugin")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("com.facebook.react.settings")
}

extensions.configure<com.facebook.react.ReactSettingsExtension> {
    autolinkLibrariesFromCommand(
        workingDirectory = file("./reactNative"),
        lockFiles = files("./reactNative/yarn.lock")
    )
}

rootProject.name = "React Native Brownfiled"
include(":app")
include(":feature:profile")
include(":feature:react")
includeBuild("reactNative/node_modules/@react-native/gradle-plugin")
include(":@d11_react-native-fast-image")
project(":@d11_react-native-fast-image").projectDir = File(rootProject.projectDir, "reactNative/node_modules/@d11/react-native-fast-image/android")
