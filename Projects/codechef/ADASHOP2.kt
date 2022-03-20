package codechef

import kotlin.Throws
import codechef.KNPSK.Record

internal object ADASHOP2 {
    private val TAIL_STEPS = arrayOf(intArrayOf(2, 2), intArrayOf(3, 1), intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(1, 5), intArrayOf(5, 1), intArrayOf(6, 2), intArrayOf(7, 1), intArrayOf(1, 7), intArrayOf(2, 8), intArrayOf(8, 2), intArrayOf(7, 3), intArrayOf(8, 4), intArrayOf(4, 8), intArrayOf(5, 7), intArrayOf(6, 8), intArrayOf(8, 6), intArrayOf(7, 7), intArrayOf(8, 8))
    fun main(args: Array<String?>?) {
        val reader = Scanner(System.`in`)
        var t: Int = reader.nextInt()
        while (t-- > 0) {
            val r0: Int = reader.nextInt()
            val c0: Int = reader.nextInt()
            if (r0 != 1 || c0 != 1) {
                System.out.println(2 + TAIL_STEPS.size)
                System.out.printf("%d %d\n", (r0 + c0) / 2, (r0 + c0) / 2)
                System.out.printf("%d %d\n", 1, 1)
            } else {
                System.out.println(TAIL_STEPS.size)
            }
            for (i in TAIL_STEPS.indices) {
                System.out.printf("%d %d\n", TAIL_STEPS[i][0], TAIL_STEPS[i][1])
            }
        }
        reader.close()
    }
}