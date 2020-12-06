package LES_05;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){
        head = null;
    }

    public void add(Node node){
        if (head == null){
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public int size(){
        int res = 0;
        Node temp = head;

        while (temp != null){
            temp = temp.next;
            res++;
        }
        return res;
    }

    public int get(int pos){
        int result = -1;
        Node temp = head;

        while (temp != null && pos > 0){
            temp = temp.next;
            pos--;
            if (pos == 0){

            }
        }

        return result;
    }

}
