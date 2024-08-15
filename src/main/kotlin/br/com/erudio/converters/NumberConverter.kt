package br.com.erudio.converters

object NumberConverter {

    fun convertToDouble(param: String?): Double {
        if (param.isNullOrBlank()) return 0.0
        val number = param.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    fun isNumeric(param: String?): Boolean {
        if (param.isNullOrBlank()) return false
        val number = param.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}
