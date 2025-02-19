plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

kotlin {
    sourceSets.named("main") {
        kotlin.srcDir(layout.buildDirectory.dir("generated/source/codegen/java"))
        kotlin.srcDir(layout.buildDirectory.dir("generated/autolinking/src/main/java"))
    }
}

android {
    namespace = "com.betatech.react"
    compileSdk = 35

    sourceSets {
        getByName("main") {
            java.srcDir("${rootProject.projectDir}/app/build/generated/source/codegen/java")
            java.srcDir("${rootProject.projectDir}/app/build/generated/autolinking/src/main/java")
        }
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // react
    implementation(libs.react.library)
    implementation(libs.hermes.android)

    // react-native-fast-image
    implementation(project(path = ":@d11_react-native-fast-image"))

    // hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    mustRunAfter(":app:generateAutolinkingPackageList")
    mustRunAfter(":app:generateCodegenArtifactsFromSchema")
    dependsOn(":app:generateAutolinkingPackageList")
    dependsOn(":app:generateCodegenArtifactsFromSchema")
}

tasks.withType<JavaCompile>().configureEach {
    dependsOn(":app:generateCodegenArtifactsFromSchema")
}

afterEvaluate {
    tasks.findByName("kaptGenerateStubsDebugKotlin")?.let { task ->
        task.dependsOn(":app:generateCodegenArtifactsFromSchema")
    }
}