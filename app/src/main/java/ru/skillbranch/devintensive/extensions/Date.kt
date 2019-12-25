package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "hh:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 60


fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTS -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()):String {
    val time = date.time - this.time
    val minuts = time / 60 % 60
    val hours = time / 3600 % 60
    val days = time / 216000
    return when (time) {
        in 0..1 -> "только что"
        in 1..45 -> "несколько секунд назад"
        in 45..75 -> "минуту назад"
        in 75..45*60 -> "$minuts минут назад"
        in 45*60.. 75*60 -> "час назад"
        in 75*60..22*3600 -> "$hours часов назад"
        in 22*3600..26*3600 -> "день назад"
        in 26*3600.. 360*216000 -> "$days дней назад"
        else -> "больше года назад"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTS,
    HOUR,
    DAY;

    fun plural(num:Int): String {
        return when (this) {
            SECOND -> when {
                num in 11..19 -> "$num секунд"
                num % 10 == 1 -> "$num секунду"
                num % 10 in 2..4 -> "$num секунды"
                else -> "$num секунд"
            }
            MINUTS -> when {
                num in 11..19 -> "$num минут"
                num % 10 == 1 -> "$num минуту"
                num % 10 in 2..4 -> "$num минуты"
                else -> "$num минут"
            }
            HOUR -> when {
                num in 11..19 -> "$num часов"
                num % 10 == 1 -> "$num час"
                num % 10 in 2..4 -> "$num часа"
                else -> "$num часов"
            }
            else -> when {
                num in 11..19 -> "$num дней"
                num % 10 == 1 -> "$num день"
                num % 10 in 2..4 -> "$num дня"
                else -> "$num дней"
            }
        }
    }
}