plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.sopt.now.advanced.team2android.feature"
    compileSdk = libs.versions.compileSdk.get().toInt()

    buildFeatures{
        viewBinding = true
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
    implementation(project(":core"))
    implementation(project(":domain"))

    // androidx
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)

    implementation(libs.google.material)
    implementation(libs.kotlin.coroutines)

    // hilt
    implementation(libs.hilt)
}