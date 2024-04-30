plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir {
        dirs("libs")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.eclipse.persistence:eclipselink:2.7.8")
    implementation("org.eclipse.persistence:javax.persistence:2.1.0")

}


tasks.test {
    useJUnitPlatform()
}