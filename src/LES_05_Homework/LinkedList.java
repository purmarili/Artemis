package LES_05_Homework;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void addNode(Node node){

        if (head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
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

    public Node get(int position){
        Node temp = head;

        while (temp != null && position > 0){
            temp = temp.next;
        }
        return temp;
    }

    public void remove(int position){
        Node temp = head;
        int size = size();
        if (size < position){
            return;
        }

        while (temp != null && position > 0){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp = null;
    }

    public double sumAllBitcoins(){
        Node temp = head;
        double res = 0;

        while (temp != null){
            res += temp.getBitcoin();
            temp = temp.next;
        }
        return res;
    }

    public boolean contains(Node node){
        //Node -shi weria equals metodi romlitac shegidzlia ori Node sheadaro ertmanets
        Node temp = head;
        while (temp != null){
            if (temp.equals(node)){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public double getMaximumBitcoin(){
        Node temp = head;
        double max = 0;

        while (temp != null){
            if (temp.getBitcoin() > max){
                max = temp.getBitcoin();
            }
            temp = temp.next;
        }

        return max;
    }

    public double getAverageBitcoin(){
        Node temp = head;
        double average = 0;
        int size = size();

        while (temp != null){
            average += temp.getBitcoin();
            temp = temp.next;
        }
        average = average / size;

        return average;
    }
}
