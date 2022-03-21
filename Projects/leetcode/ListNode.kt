package leetcode

class ListNode {
    var `val` = 0
    var next: ListNode? = null

    constructor() {}
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
}