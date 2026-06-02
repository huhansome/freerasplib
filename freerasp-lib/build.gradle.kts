plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "com.example.freerasp_lib"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 23

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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    publishing {
        singleVariant("release")
    }
}

dependencies {
//    api("com.aheaditec.talsec.security:TalsecSecurity-Community:18.3.0")

    api(project(":talseccore"))
    api("org.jetbrains.kotlin:kotlin-stdlib:1.9.20")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    api("androidx.core:core-ktx:1.12.0")
    api("androidx.lifecycle:lifecycle-process:2.6.2")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.huhansome"
                artifactId = "freeasplib"
                version = "1.0.0"
            }
        }
    }
}