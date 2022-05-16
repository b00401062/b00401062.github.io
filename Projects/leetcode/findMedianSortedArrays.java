package leetcode

private fun select(l1: IntArray, l2: IntArray, k: Int): Double {
    if (l1.isEmpty()) return l2[k].toDouble()
    if (l2.isEmpty()) return l1[k].toDouble()
    val pivot = l1[l1.size / 2]
    val index = l2.binarySearch(pivot)
    val lt1 = l1.size / 2
    val lt2 = if (index >= 0) index else -index - 1
    val lt = lt1 + lt2
    return if (k == lt)
        pivot.toDouble()
    else if (k < lt)
        select(l1.sliceArray(0 until lt1), l2.sliceArray(0 until lt2), k)
    else
        select(l1.sliceArray(lt1 + 1 until l1.size), l2.sliceArray(lt2 until l2.size), k - lt - 1)
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val len = nums1.size + nums2.size
    return if (len % 2 == 0)
        (select(nums1, nums2, len / 2 - 1) + select(nums1, nums2, len / 2)) / 2
    else
        select(nums1, nums2, len / 2)
}
