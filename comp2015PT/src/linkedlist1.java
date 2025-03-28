public class linkedlist1 {
    class Node{
        int value;
        Node next;
    }

    Node head = new Node();
    int count = 0;

    public void add(int val){
        Node newNode = new Node();
        newNode.value = val;
        Node tar = head.next;
        Node prev = head;
        while(tar != null && tar.value < val){
            tar = tar.next;
            prev = prev.next;
        }
        newNode.next = tar;
        prev.next = newNode;
        count++;
    }

    public void print(){
        Node tar = head.next;
        while(tar != null){
            System.out.print("  Value: "+tar.value);
            tar = tar.next;
        }
    }

    public static void main(String[] args) {
        linkedlist1 linkedlist = new linkedlist1();
        linkedlist.add(8);
        linkedlist.add(2);
        linkedlist.add(5);
        linkedlist.add(1);
        linkedlist.add(10);
        linkedlist.print();
    }
}
