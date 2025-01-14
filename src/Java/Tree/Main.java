package Java.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer cmd = new StringTokenizer(br.readLine());

            int parent = tree.getIndex(cmd.nextToken().charAt(0));
            tree.setLeft(cmd.nextToken().charAt(0), parent);
            tree.setRight(cmd.nextToken().charAt(0), parent);
        }

        tree.preorder(0);
        System.out.println("");
        tree.inorder(0);
        System.out.println("");
        tree.postorder(0);
    }
}
