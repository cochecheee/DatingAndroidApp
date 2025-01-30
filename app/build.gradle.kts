plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.datingappandroid"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.datingappandroid"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.oauth)
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.splashscreen)
    implementation(libs.circle)
    implementation(libs.roundedimageview)

    //    implementation(libs.cardstack)
    //implementation("com.yuyakaido.android:card-stack-view:v2.3.4")
    implementation("com.github.yuyakaido:CardStackView:2.3.4")
    implementation("com.facebook.fresco:fresco:3.6.0")
    implementation("com.facebook.infer.annotation:infer-annotation:0.18.0")
}