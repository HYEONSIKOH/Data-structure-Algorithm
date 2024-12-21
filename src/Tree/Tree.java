package Tree;

import java.util.ArrayList;

public class Tree {
    int[] alphabet;
    char[] tree;
    int size = 10000000;

    public Tree() {
        this.tree = new char[size];
        this.alphabet =  new int[26];

        tree[0] = 'A';
        alphabet[0] = 0;
    }

    public void setLeft(char value, int parent) {
        int LeftIndex = parent * 2 + 1;
        if (value != '.') {
            tree[LeftIndex] = value;
            alphabet[value - 'A'] = LeftIndex;
        }
    }

    public void setRight(char value, int parent) {
        int RightIndex = parent * 2 + 2;
        if (value != '.') {
            tree[RightIndex] = value;
            alphabet[value - 'A'] = RightIndex;
        }
    }

    // preodrer -> 전위순회
    // 전위: 루트 -> L -> R
    public void preorder (int index) {
        if (index >= size || tree[index] == '\0') return;
        System.out.print(tree[index]);
        preorder((index * 2 + 1));
        preorder((index * 2 + 2));
    }

    // inorder -> 중위순회
    // 중위: L -> 루트 -> R
    public void inorder (int index) {
        if (index >= size || tree[index] == '\0') return;
        inorder((index * 2 + 1));
        System.out.print(tree[index]);
        inorder((index * 2 + 2));
    }

    // postorder -> 후위순회
    // 후위: L -> R -> 루트
    public void postorder (int index) {
        if (index >= size || tree[index] == '\0') return;
        postorder((index * 2 + 1));
        postorder((index * 2 + 2));
        System.out.print(tree[index]);
    }

    // 그 문자의 인덱스 값을 얻음
    public int getIndex(char value) {
        return alphabet[value - 'A'];
    }
}
