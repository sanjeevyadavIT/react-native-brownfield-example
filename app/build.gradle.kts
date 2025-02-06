plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.facebook.react")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

/*
 * This is the configuration block to customize your React Native Android app.
 * By default you don't need to apply any configuration, just uncomment the lines you need.
 */
configure<com.facebook.react.ReactExtension> {
    /* Folders */
    //   The root of your project, i.e. where "package.json" lives. Default is '..'
    root.set(file("../reactNative/"))
    //   The folder where the react-native NPM package is. Default is ../node_modules/react-native
    reactNativeDir.set(file("../reactNative/node_modules/react-native"))
    //   The folder where the react-native Codegen package is. Default is ../node_modules/@react-native/codegen
    codegenDir.set(file("../reactNative/node_modules/@react-native/codegen"))
    //   The cli.js file which is the React Native CLI entrypoint. Default is ../node_modules/react-native/cli.js
    cliFile.set(file("../reactNative/node_modules/react-native/cli.js"))
    /* Variants */
    //   The list of variants to that are debuggable. For those we're going to
    //   skip the bundling of the JS bundle and the assets. By default is just 'debug'.
    //   If you add flavors like lite, prod, etc. you'll have to list your debuggableVariants.
    // debuggableVariants = ["liteDebug", "prodDebug"]
    /* Bundling */
    //   A list containing the node command and its flags. Default is just 'node'.
    // nodeExecutableAndArgs = ["node"]
    //
    //   The command to run when bundling. By default is 'bundle'
    // bundleCommand = "ram-bundle"
    //
    //   The path to the CLI configuration file. Default is empty.
    // bundleConfig = file(../rn-cli.config.js)
    //
    //   The name of the generated asset file containing your JS bundle
    bundleAssetName.set("index.android.bundle")
    //
    //   The entry file for bundle generation. Default is 'index.android.js' or 'index.js'
    entryFile.set(file("../reactNative/index.android.js"))
    //
    //   A list of extra flags to pass to the 'bundle' commands.
    //   See https://github.com/react-native-community/cli/blob/main/docs/commands.md#bundle
    // extraPackagerArgs = []
    /* Hermes Commands */
    //   The hermes compiler command to run. By default it is 'hermesc'
    hermesCommand.set("../reactNative/node_modules/react-native/sdks/hermesc/%OS-BIN%/hermesc")
    //
    //   The list of flags to pass to the Hermes compiler. By default is "-O", "-output-source-map"
    // hermesFlags = ["-O", "-output-source-map"]
    autolinkLibrariesWithApp()
}

val newArchEnabled: String by project

android {
    namespace = "com.betatech.reactnativebrownfiled"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.betatech.reactnativebrownfiled"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        ndkVersion = "26.1.10909125"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("Boolean", "NEW_ARCHITECTURE_ENABLED", newArchEnabled)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)

    // custom features
    implementation(project(":feature:profile"))
    implementation(project(":feature:react"))

    // react
    implementation(libs.react.library)

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}