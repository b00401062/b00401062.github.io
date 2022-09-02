package leetcode

fun isNumber(s: String): Boolean {
    var state = "init"
    for (c in s.trim().chars().mapToObj(Int::toChar)) {
        state = when (c) {
            '+', '-' -> when (state) {
                "init" -> "sign"
                "exp" -> "exp_sign"
                else -> "dead"
            }
            in '0'..'9' -> when (state) {
                "init", "num", "sign" -> "num"
                "dot", "frac" -> "frac"
                "exp", "exp_num", "exp_sign" -> "exp_num"
                else -> "dead"
            }
            '.' -> when (state) {
                "init", "sign" -> "dot"
                "num" -> "frac"
                else -> "dead"
            }
            'e' -> when (state) {
                "num", "frac" -> "exp"
                else -> "dead"
            }
            else -> "dead"
        }
        if (state == "dead") {
            return false
        }
    }
    return state in arrayOf("num", "frac", "exp_num")
}
