package model

enum class Position(val positionName: String) {
    DEFENDER("Защитник"),
    FORWARD("Нападающий"),
    GOALKEEPER("Вратарь"),
    MIDFIELD("Полузащитник")
}