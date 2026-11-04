import java.util.*;

class Huffman {
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static void printCode(Node root, String code) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCode(root.left, code + "0");
        printCode(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        for (int i = 0; i < n; i++) {
            System.out.print("Enter character and frequency: ");
            char ch = sc.next().charAt(0);
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        System.out.println("Huffman Codes:");
        printCode(pq.poll(), "");
    }
}
