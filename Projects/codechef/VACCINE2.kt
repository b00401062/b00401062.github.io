package codechef

import java.util.Arrays

internal object VACCINE2 {
    private fun solve(ages: IntArray, d: Int): Int {
        val nRisk = Arrays.stream(ages).filter { age -> age >= 80 || age <= 9 }.count() as Int
        val nNonRisk = ages.size - nRisk
        return (if (nRisk == 0) 0 else (nRisk - 1) / d + 1) + if (nNonRisk == 0) 0 else (nNonRisk - 1) / d + 1
    }

    fun main(args: Array<String?>?) {
        val stdin = Scanner(System.`in`)
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val d: Int = stdin.nextInt()
            val ages = IntArray(n)
            for (i in 0 until n) {
                ages[i] = stdin.nextInt()
            }
            val day = solve(ages, d)
            System.out.println(day)
        }
        stdin.close()
    }
}