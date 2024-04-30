plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate:hibernate-core:6.2.0.Final")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.postgresql:postgresql:42.7.3")
}


tasks.test {
    useJUnitPlatform()
}