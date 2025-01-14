package Kotlin.Graph

fun main() {
    val cmd = readln().split(" ").map {it.toInt()}
    val M = cmd[0]
    val N = cmd[1]
    val V = cmd[2]

    val search = Search(M)

    for (i in 0 until N) {
        val nodes = readln().split(" ").map {it.toInt()}

        search.addEdge(nodes[0], nodes[1])
        search.addEdge(nodes[1], nodes[0])
    }

    search.sortArray()
    search.dfs(V)
    println()
    search.initVisited()
    search.bfs(V)
}