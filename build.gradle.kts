import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
//	id("com.arenagod.gradle.MybatisGenerator") version "1.4" // 追加
	id("com.thinkimi.gradle.MybatisGenerator") version "2.4"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.book.manager"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1") // add
	implementation("mysql:mysql-connector-java:8.0.23") //add
	implementation("org.springframework.session:spring-session-data-redis") // add
	implementation("redis.clients:jedis") // add
	implementation("org.springframework.boot:spring-boot-starter-aop") //add
	mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0") // add
//	mybatisGenerator("gradle.plugin.com.thinkimi.gradle:mybatis-generator-plugin:2.4") //add

	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.1")
	testImplementation("org.assertj:assertj-core:3.19.0") // add
	testImplementation("org.springframework.boot:spring-boot-starter-test") // add
	testImplementation("org.mockito:mockito-core:3.8.0") // add
	testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0") // add
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// add
mybatisGenerator {
	verbose = true
	configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
}