import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("org.springframework.boot") version "2.7.9"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.github.leandrochp.passwordvalidatorservice"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    jcenter()
}

sourceSets {
    create("componentTest") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val componentTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    //spring-boot
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    //jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    //openapi
    implementation("org.springdoc:springdoc-openapi-ui:1.6.12")
    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.12")

    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter")

    componentTestImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.create("componentTest", Test::class) {
    description = "Runs the component tests"
    group = "verification"

    testClassesDirs = sourceSets["componentTest"].output.classesDirs
    classpath = sourceSets["componentTest"].runtimeClasspath

    useJUnitPlatform()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy("componentTest")
}

springBoot {
    buildInfo()
}
