plugins {
    kotlin("js") version "1.9.0"
}

repositories {
    mavenCentral()
    google()

}

dependencies {
    implementation(devNpm("wrangler", "^3.0.0"))
    implementation(devNpm("@cloudflare/workers-types","^4.20230419.0"))
    implementation("org.jetbrains.kotlinx:kotlinx-nodejs:0.0.7")
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.1"
        }
    }
    js(IR) {
        compilations.all {
            kotlinOptions {
                freeCompilerArgs += "-XXLanguage:+ExplicitBackingFields"
            }
        }
        nodejs {
        }
        binaries.executable()
    }
}
val jsFile get() = buildDir.resolve("js/packages/${project.name}/kotlin/${project.name}.js")
tasks.create("buildSingleJs") {
    group = "wrangler"
    dependsOn(":compileProductionExecutableKotlinJs")
}
tasks.create("checkJsExist") {
    group = "wrangler"
    doLast {
        require(jsFile.exists()) { "js file not found" }
    }
}
tasks.create<Exec>("dev") {
    group = "wrangler"
    dependsOn(":buildSingleJs", ":checkJsExist")
    commandLine("cmd","/c","wrangler dev ${jsFile.absoluteFile} ")
}