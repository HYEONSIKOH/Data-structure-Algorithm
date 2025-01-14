package Kotlin.Graph

import java.util.*

class Search(n: Int) {
    private var v = mutableListOf<MutableList<Int>>()
    private var visited = mutableListOf(false)
    private var q = LinkedList<Int>()

    init {
        for (i in 0 until n + 1) {
            v.add(mutableListOf())
            visited.add(false)
        }
    }

    fun initVisited(){
        for (i in visited.indices) visited[i] = false
    }

    fun addEdge(x: Int, y: Int) {
        v[x].add(y)
        v[y].add(x)
    }

    fun sortArray(){
        for (integers in v) integers.sort()
    }

    fun bfs(x: Int){
        q.add(x)

        // Queue가 비어있을 때까지 반복
        while(q.isNotEmpty()) {
            val node = q.poll()

            if(!visited[node]) {
                visited[node] = true
                print("$node ")
            }

            for (i in v[node]) {
                if (!visited[i]) q.add(i)
            }
        }
    }

    fun dfs(x: Int) {
        visited[x] = true
        print("$x ")

        for (i in v[x]) {
            if (!visited[i]) dfs(i)
        }
    }
}