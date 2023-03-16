import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.10"
}

group = "io.github.leandrochp.passw0rdvalidatorservice"
version = "1.0.0"

val mainPkgAndClass = "io.github.leandrochp.passw0rdvalidatorservice.application.Main"

application {
    mainClass.set(mainPkgAndClass)
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    //env
    implementation("com.natpryce:konfig:1.6.10.0")
    //injection
    implementation("org.koin:koin-core:2.1.6")
    //jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.4")
    //vertx
    implementation("io.vertx:vertx-core:3.9.4")
    implementation("io.vertx:vertx-web:3.9.4")
    implementation("io.vertx:vertx-lang-kotlin:3.9.4")
    //log
    implementation("org.apache.logging.log4j:log4j-api-kotlin:1.0.0")
    implementation("org.apache.logging.log4j:log4j-api:2.11.1")
    implementation("org.apache.logging.log4j:log4j-core:2.11.1")
    //test
    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("org.assertj:assertj-core:3.16.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")

}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes(mapOf("Main-Class" to mainPkgAndClass))
        attributes(mapOf("Package-Version" to archiveVersion))
    }
    from(sourceSets.main.get().output)
}
