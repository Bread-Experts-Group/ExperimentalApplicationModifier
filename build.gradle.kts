import java.util.*

plugins {
	kotlin("jvm") version "2.3.10"
	idea
	`maven-publish`
	signing
}

group = "org.bread_experts_group"
version = "D0F2P6"
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

idea {
	module {
		isDownloadSources = true
		isDownloadJavadoc = true
	}
}

dependencies {
	testImplementation(kotlin("test"))
	implementation(kotlin("reflect"))
	implementation("org.bread_experts_group:bread_server_lib-code:D1F5N7P4")
}

kotlin {
	jvmToolchain(25)
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
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

val localProperties: Properties = Properties().apply {
	rootProject.file("local.properties").reader().use(::load)
}
publishing {
	publications {
		create<MavenPublication>("mavenKotlin") {
			artifactId = "experimental_application_modifier"
			from(components["kotlin"])
			artifact(tasks.kotlinSourcesJar)
			pom {
				name = "Experimental Application Modifier"
				description = "Description pending"
				url = "https://breadexperts.group"
				scm {
					connection = "scm:git:git://github.com/Bread-Experts-Group/experimental_application_modifier.git"
					developerConnection = "scm:git:ssh://git@github.com:Bread-Experts-Group/maven_micro_server.git"
					url = "https://breadexperts.group"
				}
			}
		}
	}
	repositories {
		maven {
			url = uri("https://maven.breadexperts.group/")
			credentials {
				username = localProperties["mavenUser"] as String
				password = localProperties["mavenPassword"] as String
			}
		}
	}
}
signing {
	useGpgCmd()
	sign(publishing.publications["mavenKotlin"])
}