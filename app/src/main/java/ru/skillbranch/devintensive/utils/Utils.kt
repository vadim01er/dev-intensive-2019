package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parse: List<String>? = fullName?.split(" ")
        val firstName = parse?.getOrNull(0)
        val lastName = parse?.getOrNull(1)
        return firstName to lastName
    }


    fun transliteration(payload: String, divider: String = " "): String {
        val voc = mapOf(
            'а' to "a", 'б' to "b", 'в' to "v", 'г' to "g", 'д' to "d", 'е' to "e", 'ё' to "e",
            'ж' to "zh",'з' to "z", 'и' to "i", 'й' to "i", 'к' to "k", 'л' to "l", 'м' to "m",
            'н' to "n", 'о' to "o", 'п' to "p", 'р' to "r", 'с' to "s", 'т' to "t", 'у' to "u",
            'ф' to "f", 'х' to "h", 'ц' to "c", 'ч' to "ch", 'ш' to "sh", 'щ' to "sh'", 'ъ' to "",
            'ы' to "i", 'ь' to "", 'э' to "e", 'ю' to "yu", 'я' to "ya"
            )
        var name = ""
        payload.map { name += voc.get(it) }
        val now = parseFullName(name)
        return "${now.first}$divider${now.second}"

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val first = if (firstName.isNullOrEmpty()) firstName!![0].toUpperCase().toString() else null
        val second = if (lastName.isNullOrEmpty()) lastName!![0].toUpperCase().toString() else null
       return when {
           first != null && second != null -> "$first$second"
           first != null -> first
           second != null -> second
           else -> null
        }
    }

    fun String.truncate(n: Int = 16): String {
        return "${this.trimStart().take(this.length - n).trimEnd()}..."
    }
}