package leetcode

fun maxProfit(prices: IntArray): Int {
    var is_holding = false
    var buy_price = 0
    var profit = 0
    for (idx in 0 until prices.size) {
        if (is_holding && (idx == prices.lastIndex || prices[idx] > prices[idx + 1])) {
            profit += prices[idx] - buy_price
            is_holding = false
        } else if (!is_holding && idx < prices.lastIndex && prices[idx] < prices[idx + 1]) {
            buy_price = prices[idx]
            is_holding = true
        }
    }
    return profit
}
