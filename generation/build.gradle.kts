plugins{
    `kaistinea-microservice`
}

dependencies {
    implementation(libs.database.h2)
    implementation(libs.spring.boot.starter.data.redis)
    implementation(project(":common"))
}