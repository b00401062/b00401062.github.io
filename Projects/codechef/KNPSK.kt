package codechef

import java.io.*

object KNPSK {
    private fun solve(ones: List<Integer>, twos: List<Integer>): LongArray {
        Collections.sort(ones)
        Collections.sort(twos)
        val m: Int = ones.size() + twos.size() * 2
        val records = arrayOfNulls<Record>(m + 1)
        records[0] = Record(0, ones.size(), twos.size())
        records[1] = if (ones.size() === 0) Record(0, ones.size(), twos.size()) else Record(ones[ones.size() - 1], ones.size() - 1, twos.size())
        for (i in 2..m) {
            val record1 = records[i - 1]
            val cost0 = record1!!.cost
            val cost1 = if (record1.oneCount == 0) Long.MIN_VALUE else record1.cost + ones[record1.oneCount - 1]
            val record2 = records[i - 2]
            val cost2 = if (record2!!.twoCount == 0) Long.MIN_VALUE else record2.cost + twos[record2.twoCount - 1]
            val maxCost: Long = Math.max(cost0, Math.max(cost1, cost2))
            records[i] = if (maxCost == cost1) Record(maxCost, record1.oneCount - 1, record1.twoCount) else if (maxCost == cost2) Record(maxCost, record2.oneCount, record2.twoCount - 1) else Record(maxCost, record1.oneCount, record1.twoCount)
        }
        return Arrays.stream(records).skip(1).mapToLong { obj: Record -> obj.cost() }.toArray()
    }

    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val n: Int = stdin.nextInt()
        val ones: List<Integer> = ArrayList()
        val twos: List<Integer> = ArrayList()
        for (i in 0 until n) {
            val w: Int = stdin.nextInt()
            val c: Int = stdin.nextInt()
            (if (w == 1) ones else twos).add(c)
        }
        val costs = solve(ones, twos)
        System.out.println(
                Arrays.stream(costs)
                        .mapToObj(Long::toString)
                        .collect(Collectors.joining(" "))
        )
        stdin.close()
    }

    private class Record internal constructor(val cost: Long, val oneCount: Int, val twoCount: Int) {
        fun cost(): Long {
            return cost
        }
    }
}