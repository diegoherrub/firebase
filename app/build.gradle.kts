plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.google.services)
    alias(libs.plugins.ksp)
    alias(libs.plugins.navigation.safeargs.kotlin)
}

android {
    namespace = "pol.rubiano.firebase"
    compileSdk = 35

    defaultConfig {
        applicationId = "pol.rubiano.firebase"
        minSdk = 33
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project.dependencies.platform(libs.firebaseBom))
    implementation(libs.firebaseFirestore)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(project.dependencies.platform(libs.koin.bom))
    ksp(libs.koin.ksp)
    implementation(libs.koin.android)
    implementation(libs.koin.annotations)
    ksp(libs.room.ksp)
    implementation(libs.room.runtime)
    implementation(libs.room.coroutines)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}