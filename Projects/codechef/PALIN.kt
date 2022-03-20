package codechef

import java.util.*

object PALIN {

    fun next(k: String): String {
        val k = k.toCharArray()
        if (k.all('9'::equals)) {
            var result = "1"
            repeat(k.size - 1) {
                result += "0"
            }
            result += "1"
            return result
        }
        val m = k.size / 2
        var l = m - 1
        var r = if (k.size % 2 == 0) m else m + 1
        var leftSmall = false
        while (l >= 0 && k[l] == k[r]) {
            l--
            r++
        }
        if (l < 0 || k[l] < k[r]) {
            leftSmall = true
        }
        while (l >= 0) {
            k[r++] = k[l--]
        }
        if (leftSmall) {
            var carryForward = true
            if (k.size % 2 == 1) {
                if (k[m] == '9') {
                    carryForward = true
                    k[m] = '0'
                } else {
                    carryForward = false
                    k[m] = (k[m] + 1)
                }
            }
            l = m - 1
            r = if (k.size % 2 == 0) m else m + 1
            while (l >= 0) {
                if (carryForward) {
                    if (k[l] == '9') {
                        carryForward = true
                        k[l] = '0'
                    } else {
                        carryForward = false
                        k[l] = (k[l] + 1)
                    }
                }
                k[r] = k[l]
                r++
                l--
            }
        }
        return String(k)
    }

    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var t = stdin.nextInt()
        while (t-- > 0) {
            val k = stdin.next()
            println(next(k))
        }
        stdin.close()
    }
}