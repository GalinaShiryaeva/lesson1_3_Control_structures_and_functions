const val SECONDS_IN_MINUTE = 60u
const val SECONDS_IN_HOUR = 3600u
const val SECONDS_IN_DAY = 86_400u

fun main() {
    print("Введите количество секунд: ")
    val seconds: UInt = readln().toUInt()
    println(agoToText(seconds))
}

fun agoToText (seconds: UInt): String {

    return when (seconds) {
        in 0u until SECONDS_IN_MINUTE -> "только что"
        in SECONDS_IN_MINUTE  until SECONDS_IN_HOUR -> (seconds / SECONDS_IN_MINUTE).toString() + " "+ spellMinutes(seconds) + " назад"
        in SECONDS_IN_HOUR until SECONDS_IN_DAY -> (seconds / SECONDS_IN_HOUR).toString() + " " + spellHours(seconds) + " назад"
        in SECONDS_IN_DAY until SECONDS_IN_DAY * 2u -> "сегодня"
        in SECONDS_IN_DAY * 2u until SECONDS_IN_DAY * 3u -> "вчера"
        else -> "давно"
    }
}

fun spellMinutes (seconds: UInt): String {
    if (seconds in SECONDS_IN_MINUTE * 11u until SECONDS_IN_MINUTE * 15u) return "минут"
    return when (seconds / SECONDS_IN_MINUTE % 10u) {
        1u -> "минуту"
        2u, 3u, 4u -> "минуты"
        else -> "минут"
    }
}

fun spellHours (seconds: UInt): String {
    if (seconds in SECONDS_IN_HOUR * 11u until SECONDS_IN_HOUR * 15u) return "часов"
    return when (seconds / SECONDS_IN_HOUR % 10u) {
        1u -> "час"
        2u, 3u, 4u -> "часа"
        else -> "часов"
    }
}