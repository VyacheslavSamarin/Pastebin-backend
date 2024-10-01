plugins {
    `kotlin-dsl`


}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.kotlin.stdlib)
}

gradlePlugin {
    plugins {
        register("kaistineaMicroservicePlugin") {
            id = libs.plugins.kaistinea.microservice.get().pluginId
            implementationClass = "project.plugins.KaistineaMicroservicePlugin"
        }
    }
}