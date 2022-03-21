package leetcode

fun checkOnesSegment(s: String): Boolean {
    return s.split("0+".toRegex()).toTypedArray().size == 1
}
