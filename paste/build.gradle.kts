plugins{
    `kaistinea-microservice`
}

dependencies {
    implementation(libs.database.h2)
    implementation(project(":common"))
}