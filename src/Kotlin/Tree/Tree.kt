package Kotlin.Tree

class Tree {
    var alphabet = arrayOf<Int>()
    var tree = arrayOf<Char>()
    var size = 10000000

    init {
        alphabet = Array(size) { 0 }  // 크기 size, 모든 요소를 0으로 초기화
        tree = Array(size) { ' ' }

        tree[0] = 'A'
        alphabet[0] = 0;
    }

    fun setLeft(value: Char, parent: Int) {
        val leftIndex = parent * 2 + 1
        if (value != '.') {
            tree[leftIndex] = value
            alphabet[value - 'A'] = leftIndex
        }
    }

    fun setRight(value: Char, parent: Int) {
        val rightIndex = parent * 2 + 2
        if (value != '.') {
            tree[rightIndex] = value
            alphabet[value - 'A'] = rightIndex
        }
    }

    // preodrer -> 전위순회
    // 전위: 루트 -> L -> R
    fun preorder(index: Int) {
        if (index > size || tree[index] == ' ') return
        print(tree[index])
        preorder(index * 2 + 1)
        preorder(index * 2 + 2)
    }

    // inorder -> 중위순회
    // 중위: L -> 루트 -> R
    fun inorder(index: Int) {
        if (index > size || tree[index] == ' ') return
        inorder(index * 2 + 1)
        print(tree[index])
        inorder(index * 2 + 2)
    }

    // postorder -> 후위순회
    // 후위: L -> R -> 루트
    fun postorder(index: Int) {
        if (index > size || tree[index] == ' ') return
        postorder(index * 2 + 1)
        postorder(index * 2 + 2)
        print(tree[index])
    }

    fun getIndex(value: Char): Int { return alphabet[value - 'A'] }
}