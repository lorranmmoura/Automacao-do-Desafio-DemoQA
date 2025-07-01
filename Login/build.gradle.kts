plugins {
    id("java")
}

group = "br.login"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(group = "junit", name = "junit", version = "4.13.2")
    implementation(group = "io.cucumber", name = "cucumber-java", version = "7.20.1")
    testImplementation(group = "io.cucumber", name = "cucumber-junit", version = "7.20.1")
    implementation(group = "org.seleniumhq.selenium", name = "selenium-java", version = "4.33.0")
}

