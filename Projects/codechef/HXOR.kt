package codechef

import java.io.IOException

object HXOR {
    private fun find(a: IntArray, i: Int, p: Int): Int {
        val n = a.size
        for (j in i + 1 until n) {
            if (a[j] and (1 shl p) != 0) return j
        }
        return n - 1
    }

    private fun solve(a: IntArray, x: Int) {
        var x = x
        val n = a.size
        for (i in 0 until n - 1) {
            while (a[i] != 0 && x-- > 0) {
                val p = (Math.log(a[i]) / Math.log(2)) as Int
                val j = find(a, i, p)
                a[i] = a[i] xor (1 shl p)
                a[j] = a[j] xor (1 shl p)
            }
        }
        if (n == 2 && x % 2 == 1 || x == 1) {
            a[n - 2] = a[n - 2] xor 1
            a[n - 1] = a[n - 1] xor 1
        }
    }

    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(System.`in`)
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val x: Int = stdin.nextInt()
            stdin.nextLine()
            val a: IntArray = Arrays.stream(
                    stdin.nextLine().split(" ")
            ).mapToInt(Integer::valueOf).toArray()
            solve(a, x)
            System.out.println(
                    Arrays.stream(a)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(" "))
            )
        }
        stdin.close()
    }
}