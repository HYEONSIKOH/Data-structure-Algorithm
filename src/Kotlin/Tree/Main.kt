package Kotlin.Tree

fun main() {
    val N = readln().toInt()

    val tree = Tree()

    for (i in 0 until N) {
        val cmd = readln().split(" ")

        val parent = tree.getIndex(cmd[0][0])
        tree.setLeft(cmd[1][0], parent)
        tree.setRight(cmd[2][0], parent)
    }

    tree.preorder(0)
    println()
    tree.inorder(0)
    println()
    tree.postorder(0)
}