package codechef

import java.io.IOException
import java.util.*
import java.util.Map
import java.util.stream.Collectors

internal object UCL {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var t = stdin.nextLine().toInt()
        while (t-- > 0) {
            val teams: MutableMap<String, Team?> = HashMap()
            for (i in 0..11) {
                val tokens = stdin.nextLine().split(" ")
                if (!teams.containsKey(tokens[0])) {
                    teams[tokens[0]] = Team()
                }
                if (!teams.containsKey(tokens[4])) {
                    teams[tokens[4]] = Team()
                }
                val diff = tokens[1].toInt() - tokens[3].toInt()
                if (diff > 0) {
                    teams[tokens[0]]!!.plus(3, 0)
                } else if (diff < 0) {
                    teams[tokens[4]]!!.plus(3, 0)
                } else {
                    teams[tokens[0]]!!.plus(1, 0)
                    teams[tokens[4]]!!.plus(1, 0)
                }
                teams[tokens[0]]!!.plus(0, diff)
                teams[tokens[4]]!!.plus(0, -diff)
            }
            println(
                teams.entries
                .stream()
                .sorted(
                    Map.Entry.comparingByValue(
                        Comparator.comparingInt(Team::point)
                        .thenComparingInt(Team::goal)
                        .reversed()
                    )
                )
                .limit(2)
                .map<String> { it.key }
                .collect(Collectors.joining(" "))
            )
        }
        stdin.close()
    }

    private class Team {
        var point = 0
            private set
        var goal = 0
            private set

        fun plus(point: Int, goal: Int) {
            this.point += point
            this.goal += goal
        }

    }
}
