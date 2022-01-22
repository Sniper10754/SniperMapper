plugins {
    java
    `maven-publish`
}

group = "org.snipermapper"

allprojects {
    version = "1.0"
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    compileOnly("com.github.Sniper10754:SimpleLogger4j:v0.2")
}
tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}