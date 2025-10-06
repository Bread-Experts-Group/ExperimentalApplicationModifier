plugins {
	kotlin("jvm") version "2.2.20"
}

group = "org.bread_experts_group"
version = "D0F0P0"
// Bread Experts Group Versioning System, revision 1 (natives/libraries unauthorized outside of Bread Server Library)
//                          Pertains to the ...
// Dx ... Design x       //  entire architecture of the project
// Fx ... Feature Set x  //  current feature set exposed by the project
// Px ... Patch x        //  current code revision, like a fix or logic change
// This system does not prescribe "safe" versions to update to, like that of major/minor/patch in semantic versioning
// Check before updating or do not update at all

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	testImplementation(kotlin("test"))
	implementation("org.bread_experts_group:bread_server_lib-code:D0F0N0P0")
}

kotlin {
	jvmToolchain(25)
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(24)
	}
}

tasks.jar {
	manifest {
		attributes(
			"Premain-Class" to "org.bread_experts_group.eam.Agent"
		)
	}
	from({
		configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
	})
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.test {
	useJUnitPlatform()
}