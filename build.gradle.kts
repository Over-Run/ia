import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0" apply false
    `java-platform`
    `maven-publish`
}

allprojects {
    group = "io.github.over-run"
    version = "0.1.0-SNAPSHOT"
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    val implementation by configurations
    dependencies {
        if (project.name != "core") {
            implementation(project(":core"))
        }
    }

    val compileKotlin: KotlinCompile by tasks
    val compileJava: JavaCompile by tasks
    compileKotlin.destinationDirectory.set(compileJava.destinationDirectory)
    tasks.named<Jar>("jar") { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}

dependencies {
    constraints {
        api("io.github.over-run:ia:$version")
        api("io.github.over-run:ia-dsl:$version")
        api("io.github.over-run:ia-impl-lwjgl3:$version")
    }
}
