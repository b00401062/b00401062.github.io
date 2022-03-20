package codechef

import java.io.*

internal object POSAND {
    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            if (n == 1) {
                System.out.println(1)
                continue
            } else if (Integer.bitCount(n) === 1) {
                System.out.println(-1)
                continue
            }
            val seq: IntArray = IntStream.rangeClosed(1, n).toArray()
            seq[0] = 2
            seq[1] = 3
            seq[2] = 1
            var i = 4
            while (i < n) {
                seq[i - 1] = i + 1
                seq[i] = i
                i *= 2
            }
            System.out.println(Arrays.stream(seq).mapToObj(Integer::toString).collect(Collectors.joining(" ")))
        }
        stdin.close()
    }
}