package codechef

import java.io.*

internal object DDIMMST {
    private fun distance(p1: Point, p2: Point?): Int {
        val D = p1.x.size
        var w = 0
        for (i in 0 until D) {
            w += Math.abs(p1.x[i] - p2!!.x[i])
        }
        return w
    }

    @Throws(Exception::class)
    fun main(args: Array<String?>?) {
        val queue: Field = PriorityQueue::class.java.getDeclaredField("queue")
        queue.setAccessible(true)
        val siftUp: Method = PriorityQueue::class.java.getDeclaredMethod("siftUp", Int::class.javaPrimitiveType, Object::class.java)
        siftUp.setAccessible(true)
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val N: Int = stdin.nextInt()
        val D: Int = stdin.nextInt()
        val p = arrayOfNulls<Point>(N)
        for (n in 0 until N) {
            val x = IntArray(D)
            for (d in 0 until D) {
                x[d] = stdin.nextInt()
            }
            p[n] = Point(x)
        }
        var weight = 0
        val pool: PriorityQueue<Point> = PriorityQueue(N, Comparator.comparingInt { obj: Point -> obj.w() }.reversed())
        pool.addAll(Arrays.asList(p))
        while (!pool.isEmpty()) {
            val s: Point = pool.remove()
            var t: Point? = null
            var n = 0
            while (n < N && queue.get(pool)[n] as Point?. also { t = it } != null) {
                val w = distance(s, t)
                if (w > t!!.w) {
                    t!!.set(w)
                    siftUp.invoke(pool, n, t)
                }
                n++
            }
            weight += s.w
        }
        System.out.println(weight)
        stdin.close()
    }

    private class Point(val x: IntArray) {
        var w = 0
        fun w(): Int {
            return w
        }

        fun set(w: Int) {
            this.w = w
        }
    }
}