package codechef

import kotlin.Throws
import codechef.KNPSK.Record

internal object LAZER {
    fun main(args: Array<String?>?) {
        val reader = BufferedReader(InputStreamReader(System.`in`))
        val writer = PrintWriter(System.out)
        var st: StringTokenizer
        var t: Int = Integer.parseInt(reader.readLine())
        while (t-- > 0) {
            st = StringTokenizer(reader.readLine())
            val n: Int = Integer.parseInt(st.nextToken())
            val q: Int = Integer.parseInt(st.nextToken())
            val A: Array<Integer> = arrayOfNulls<Integer>(n)
            st = StringTokenizer(reader.readLine())
            for (i in 0 until n) {
                A[i] = Integer.parseInt(st.nextToken())
            }
            val Q = arrayOfNulls<Query>(q)
            for (i in 0 until q) {
                st = StringTokenizer(reader.readLine())
                val x1: Int = Integer.parseInt(st.nextToken())
                val x2: Int = Integer.parseInt(st.nextToken())
                val y: Int = Integer.parseInt(st.nextToken())
                Q[i] = Query(x1, x2, y)
            }
            val events: Map<Integer, Event> = TreeMap()
            for (i in 0 until q) {
                val event: Event = events.getOrDefault(Q[i]!!.y, Event())
                event.queries.add(Q[i])
                events.put(Q[i]!!.y, event)
            }
            for (i in 0 until n) {
                val y: Int = A[i]
                val event: Event = events.getOrDefault(y, Event())
                if (i < n - 1) {
                    (if (y <= A[i + 1]) event.xis else event.xos).add(i + 1)
                }
                if (i > 0) {
                    (if (A[i - 1] <= y) event.xos else event.xis).add(i)
                }
                events.put(y, event)
            }
            val candidates: BST<Integer> = BST()
            for (event in events.values()) {
                for (x in event.xis) {
                    candidates.add(x)
                }
                for (query in event.queries) {
                    query.n = candidates.size(query.x1, query.x2)
                }
                for (x in event.xos) {
                    candidates.remove(x)
                }
            }
            for (i in 0 until q) {
                writer.println(Q[i]!!.n)
            }
        }
        reader.close()
        writer.flush()
        writer.close()
    }

    private class Query internal constructor(var x1: Int, var x2: Int, var y: Int) {
        var n = 0
    }

    private class Event {
        var xis: List<Integer> = ArrayList()
        var xos: List<Integer> = ArrayList()
        var queries: List<Query> = ArrayList()
    }
}