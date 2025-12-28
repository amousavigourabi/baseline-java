plugins {
    `java-library`
    `maven-publish`
    pmd
    jacoco
    alias(libs.plugins.spotless)
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.slf4j)
    testImplementation(libs.assertj)
    testImplementation(libs.jupiter.api)
    testImplementation(libs.jupiter.params)
    testRuntimeOnly(libs.jupiter.engine)
    testRuntimeOnly(libs.junit.launcher)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

spotless {
    java {
        removeUnusedImports()
        palantirJavaFormat().formatJavadoc(true)
        formatAnnotations()
        trimTrailingWhitespace()
        leadingSpacesToTabs()
        leadingTabsToSpaces(2)
    }
}

group = "me.atour"
version = "1.0.0-SNAPSHOT"
description = "Baseline project for Java 25 LTS with Gradle"
java.sourceCompatibility = JavaVersion.VERSION_25

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
