package com.example.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

class Utils {
    companion object {
        fun timeStampToHumanDate(timeStamp: Long, format: String): String {
            val brasil = Locale("pt", "BR")
            val sdf = SimpleDateFormat(format, brasil)
            return sdf.format(timeStamp * 1000)
        }

        fun buildIcon(icon: String, isBigSize: Boolean = true): String {
            return if (isBigSize) {
                "https://openweathermap.org/img/wn/$icon@4x.png"
            } else {
                "https://openweathermap.org/img/wn/$icon.png"
            }
        }
    }
}