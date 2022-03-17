package ru.netology

const val SECONDS = 60
const val HOURS = 24

fun main() {
    val seconds = 66500

    println("был(а) ${agoToText(seconds)}")
}

fun agoToText(seconds: Int): String = when {
    minutes(seconds) in 1..60 -> "${minutes(seconds)} ${formMinutes(seconds)} назад"
    hours(seconds) in 1..24 -> "в сети ${hours(seconds)} ${formHours(seconds)} назад"
    days(seconds) == 1 -> "сегодня"
    days(seconds) == 2 -> "вчера"
    days(seconds) >= 3 -> "давно"
    else -> "только что"
}

fun formMinutes(seconds: Int): String = when {
    minutes(seconds) % 10 == 1 && minutes(seconds) % 100 != 11 -> "минуту"
    minutes(seconds) % 10 in 2..4 && minutes(seconds) % 100 !in 12..14 -> "минуты"
    else -> "минут"
}

fun formHours(seconds: Int): String = when {
    hours(seconds) % 10 == 1 && hours(seconds) % 100 != 11 -> "час"
    hours(seconds) % 10 in 2..4 && hours(seconds) % 100 !in 12..14 -> "часа"
    else -> "часов"
}

fun minutes(seconds: Int): Int {
    return seconds / SECONDS
}

fun hours(seconds: Int): Int {
    return seconds / (SECONDS * SECONDS)
}

fun days(seconds: Int): Int {
    return seconds / (HOURS * SECONDS * SECONDS)
}


