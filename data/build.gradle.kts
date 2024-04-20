plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.sopt.now.advanced.team2android.data"
    compileSdk = libs.versions.compileSdk.get().toInt()

    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    // androidx
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    // third party
    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlin.serialization.json)
}