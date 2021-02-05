package Hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    /*
        1 -> 2 -> 3 -> 4
        4 -> 3 -> 2 -> 1
        4 -> 3 -> 2 -> 1
    */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode res = new SinglyLinkedListNode(head.data);
        while (head.next != null) {
            SinglyLinkedListNode tmp = new SinglyLinkedListNode(head.next.data);
            head = head.next;
            tmp.next = res;
            res = tmp;
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);
}
