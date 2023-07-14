rootProject.name = "ia"

listOf("core", "dsl", "impl-lwjgl3").forEach {
    include(it)
    project(":$it").projectDir = file("modules/ia/$it/")
}

include("samples")
project(":samples").projectDir = file("modules/samples/")
include("samples-impl-lwjgl3")
project(":samples-impl-lwjgl3").projectDir = file("modules/samples/impl-lwjgl3/")
