import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application") version "8.13.0"
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val useKeystoreProperties = keystorePropertiesFile.canRead()
val keystoreProperties = Properties()
if (useKeystoreProperties) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}

android {
    namespace = "com.android.calculator2"
    compileSdk = 36

    if (useKeystoreProperties) {
        signingConfigs {
            create("release") {
                storeFile = rootProject.file(keystoreProperties["storeFile"]!!)
                storePassword = keystoreProperties["storePassword"] as String
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
            }
        }
    }

    defaultConfig {
        applicationId = "com.android.calculator2"
        minSdk = 30
        targetSdk = 36
        versionCode = (System.getenv("VERSION_CODE") ?: "1").toInt()
        versionName = System.getenv("VERSION_NAME") ?: "dev"
    }

    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")
            java.srcDirs("src", "crcalc/src")
            res.srcDirs("res")
            assets.srcDirs("assets")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            if (useKeystoreProperties) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }
}

dependencies {
    implementation("androidx.gridlayout:gridlayout:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.viewpager:viewpager:1.1.0")
}
