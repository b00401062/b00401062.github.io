package leetcode

import java.util.*
import java.util.function.ToIntFunction

private val sum = ToIntFunction { account: IntArray? -> Arrays.stream(account).sum() }

fun maximumWealth(accounts: Array<IntArray>?): Int {
    return Arrays.stream(accounts).mapToInt(sum).max().asInt
}
