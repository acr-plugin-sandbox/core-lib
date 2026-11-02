plugins {
    id("com.android.library") version "8.7.3"
    id("org.jetbrains.kotlin.android") version "2.1.0"
    `maven-publish`
}

group = "com.example"
version = "1.4.0"

android {
    namespace = "com.example.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    testImplementation("junit:junit:4.13.2")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.example"
            artifactId = "core-lib"
            version = project.version.toString()
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
