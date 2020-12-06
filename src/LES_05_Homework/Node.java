package LES_05_Homework;

public class Node {
    private double bitcoin;
    private String account;

    public Node next;

    public Node(String account, double bitcoin){
        this.account = account;
        this.bitcoin = bitcoin;
        this.next = null;
    }


    public boolean equals(Node node){
        if (node == null) return false;
        return node.bitcoin == this.bitcoin && node.account.equals(this.account);
    }

    @Override
    public String toString() {
        return "Node{" + "bitcoin=" + bitcoin + ", account='" + account + '\'' + '}';
    }

    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
