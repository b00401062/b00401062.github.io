package codechef;

import java.io.IOException;
import java.util.Scanner;

class BSTOPS {
    private static Node insert(Node root, int x, long p) {
        if (root == null) {
            System.out.println(p);
            return new Node(x, p);
        } else if (x < root.x)
            root.lt = insert(root.lt, x, p * 2);
        else if (x > root.x)
            root.rt = insert(root.rt, x, p * 2 + 1);
        return root;
    }

    private static Node delete(Node root, int x) {
        if (x < root.x)
            root.lt = delete(root.lt, x);
        else if (x > root.x)
            root.rt = delete(root.rt, x);
        else {
            System.out.println(root.p);
            if (root.lt == null)
                return root.rt;
            else if (root.rt == null)
                return root.lt;
            else {
                Node successor = root.rt;
                while (successor.lt != null)
                    successor = successor.lt;
                root.x = successor.x;
                root.rt = delete(root.rt, successor.x);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        Node root = null;
        while (n-- > 0) {
            char c = stdin.next().charAt(0);
            int x = stdin.nextInt();
            switch (c) {
                case 'i':
                    root = insert(root, x, 1);
                    break;
                case 'd':
                    root = delete(root, x);
                    break;
            }
        }
    }

    private static class Node {
        Node lt, rt;
        int x;
        long p;

        Node(int x, long p) {
            this.x = x;
            this.p = p;
        }
    }
}
