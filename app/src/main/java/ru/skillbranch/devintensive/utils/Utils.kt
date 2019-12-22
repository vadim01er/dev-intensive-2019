package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parse: List<String>? = fullName?.split(" ")
        val firstName = parse?.getOrNull(0)
        val lastName = parse?.getOrNull(1)
        return firstName to lastName
    }


    fun transliteration(payload: String, divider: String = " "): String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO()
    }
}