package leetcode

import java.util.function.ToIntFunction
import java.util.Arrays

private val sum = ToIntFunction { account: IntArray? -> Arrays.stream(account).sum() }

fun maximumWealth(accounts: Array<IntArray>?): Int {
    return Arrays.stream(accounts).mapToInt(sum).max().asInt
}
