package chapter02;

class P2_3 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        removeMiddle(n3);
        printLL(n1);
    }

    private static void removeMiddle(Node middle) {
        Node p1 = middle;
        Node p2 = middle.next;

        while (p1 != null && p2 != null) {
            p1.data = p2.data;

            if (p2.next == null) {
                p1.next = null;
                break;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }

    private static void printLL(Node n) {
        Node curr = n;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    static class Node {
        Node next = null;
        int data;

        Node(int d) {
            this.data = d;
        }
    }
}



