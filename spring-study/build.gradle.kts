plugins {
    id("java")
}

group = "org.springframework"
version = "6.0.9"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(mapOf("path" to ":spring-core")))
	implementation("junit:junit:4.13.2")
	implementation(project(mapOf("path" to ":spring-beans")))
	implementation(project(mapOf("path" to ":spring-context")))
	testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}



tasks.test {
    useJUnitPlatform()
}