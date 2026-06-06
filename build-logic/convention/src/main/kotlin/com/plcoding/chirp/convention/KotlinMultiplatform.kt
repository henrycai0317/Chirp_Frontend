package com.plcoding.chirp.convention

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform() {
    configureAndroidLibraryTarget()
    configureDesktopTarget()

    extensions.configure<KotlinMultiplatformExtension> {
        extensions.configure<KotlinMultiplatformAndroidLibraryExtension> {
            compileSdk = 36
            minSdk = 24
            namespace = pathToPackageName()
            experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
        }

        listOf(
            // iosX64()：CMP 1.11+ 已不發佈 iosX64 產物，移除
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = this@configureKotlinMultiplatform.pathToFrameworkName()
            }
        }

        applyHierarchyTemplate()

        compilerOptions {
            freeCompilerArgs.add("-Xexpect-actual-classes")
            freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
            freeCompilerArgs.add("-opt-in=kotlin.time.ExperimentalTime")
        }
    }
}