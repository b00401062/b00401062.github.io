package leetcode

fun insert(src: IntArray, idx: Int, element: Int): IntArray {
    val dst = IntArray(src.size + 1)
    System.arraycopy(src, 0, dst, 0, idx)
    dst[idx] = element
    System.arraycopy(src, idx, dst, idx + 1, src.size - idx)
    return dst
}

fun plusOne(digits: IntArray): IntArray {
    digits[digits.lastIndex] += 1
    for (idx in digits.lastIndex downTo 1) {
        if (digits[idx] >= 10) {
            digits[idx] -= 10
            digits[idx - 1] += 1
        } else {
            break
        }
    }
    if (digits[0] >= 10) {
        digits[0] -= 10
        return insert(digits, 0, 1)
    } else {
        return digits
    }
}
