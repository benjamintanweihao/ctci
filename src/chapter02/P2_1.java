package chapter02;

class P2_1 {

    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(1);
        Node n6 = new Node(2);
        Node n7 = new Node(1);
        Node n8 = new Node(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        printLL(n1);
        removeDuplicates(n1);
        printLL(n1);
    }

    private static Node removeDuplicates(Node head) {
        Node p1 = head;
        Node p2;

        while (p1 != null) {
            p2 = p1.next;
            while (p2 != null) {
                if (p1.data == p2.data) {
                    // Have another pointer find the next good node
                    Node tmp = p1;
                    while (tmp.next != p2) {
                        tmp = tmp.next;
                    }

                    tmp.next = p2.next;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }

        return head;
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


