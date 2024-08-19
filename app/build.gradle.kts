plugins {
    id("java")
    application
}

group = "com.github.gmodena.searchy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
    url = uri("https://maven.pkg.github.com/gmodena/searchy")
    credentials {
        username = findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
        password = findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
    }
}
}

java {
    sourceCompatibility = JavaVersion.VERSION_22
    targetCompatibility = JavaVersion.VERSION_22
}

dependencies {
    implementation("com.github.gmodena.searchy:searchy-index:0.1.0-SNAPSHOT")
    implementation("org.openjdk.jmh:jmh-core:1.36")
    implementation("commons-cli:commons-cli:1.4")
    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.36")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("io.github.gmodena.wikinews.Runner")
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<Test> {
    jvmArgs("--enable-preview")
}

tasks.withType<JavaExec> {
    jvmArgs("--enable-preview")
}
