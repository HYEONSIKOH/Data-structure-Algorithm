package Kotlin.Dp

// [프로그래머스] 12913 - 땅따먹기 Kotlin
class P12913 {
    lateinit var dp: Array<IntArray>

    fun getMaxGrade(y: Int, x: Int): Int {
        var maxGrade = 0
        for (i in 0 until 4) {
            if (i == x) continue
            else maxGrade = maxOf(maxGrade, dp[y-1][i])
        }

        return maxGrade
    }

    fun solution(land: Array<IntArray>): Int {
        dp = land

        for (y in 1 until land.size) {
            for (x in 0 until 4) {
                dp[y][x] += getMaxGrade(y, x)
            }
        }

        return dp[land.size-1].max()
    }
}

fun main() {
    val p = P12913()
    val land = arrayOf(
        intArrayOf(1, 2, 3, 5),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(4, 3, 2, 1)
    )

    println(p.solution(land))
}