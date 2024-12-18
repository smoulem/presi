plugins {
    id("groovy")
}

group = "net.sammy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.groovy:groovy:4.0.14")
    implementation("org.apache.groovy:groovy-sql:4.0.14")
    implementation("org.apache.groovy:groovy-json:4.0.14")
    implementation("com.oracle.database.jdbc:ojdbc11:23.5.0.24.07")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}