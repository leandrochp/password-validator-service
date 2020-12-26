package io.github.leandrochp.passw0rdvalidatorservice.domain.validators

class ValidatorPasswordRepeat(private val minRepeat: Int) : ValidatorPassword {

    override fun validate(password: String) = if (minRepeat >= 0) {
        val chars = mutableListOf<Char>()

        var repeated = 0
        password.map {
            if (chars.contains(it)) repeated++ else chars.add(it)
        }
        minRepeat >= repeated
    } else true
}

