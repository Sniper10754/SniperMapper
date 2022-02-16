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
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("com.github.Sniper10754:SimpleLogger4j:0.9-nightly")
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