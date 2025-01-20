package Kotlin.Graph

import java.util.PriorityQueue

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978?language=java
 * [프로그래머스] 12978 - 배달
 */
class Dijkstra(private val V: Int) {

    private val INF = 1000000000;
    private var vec = MutableList(V + 1) { mutableListOf<Pair<Int, Int>>() }
    private var dist = MutableList(V + 1) { INF }

    fun addEdge(u: Int, v: Int, w: Int) {
        vec[u].add(Pair(v, w))
        vec[v].add(Pair(u, w))
    }

    fun dijkstra() {
        val startNode = 1
        dist[startNode] = 0

        var pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
        pq.add(Pair(startNode, 0))

        while(pq.isNotEmpty()) {
            val p = pq.poll()

            for (nextP in vec[p.first]) {
                val nextNode = nextP.first
                val nextDist = p.second + nextP.second

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist
                    pq.add(Pair(nextNode, nextDist))
                }
            }
        }
    }

    fun result(K: Int): Int {
        var count = 0
        for (i in dist)
            if (i <= K) count++

        return count
    }
}

fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
    var d = Dijkstra(N)

    for (arr in road) { d.addEdge(arr[0], arr[1], arr[2]) }

    d.dijkstra()

    return d.result(k)
}