plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    implementation("io.reactivex.rxjava2", "rxjava", "2.2.6")
    testImplementation("org.hamcrest", "hamcrest-all", "1.3")
}
