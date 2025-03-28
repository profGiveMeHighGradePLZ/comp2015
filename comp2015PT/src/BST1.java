public class BST1<V extends Comparable<V>> {
    class Node{
        V value;
        Node next;
    }

    Node head = new Node();
    int count = 0;
    V total;

    public void add(V v){
        Node newNode = new Node();
        newNode.value = v;
        Node prev = head;
        Node tar = head.next;
        while(tar != null && tar.value.compareTo(v) < 0){
            prev = prev.next;
            tar = tar.next;
        }
        prev.next = newNode;
        newNode.next = tar;
        count++;
    }

    public V removeFirst(){
        if(head.next == null){
            return null;
        }
        Node tar = head.next;
        if(tar.next == null){
            head.next = null;
        }else{
            head.next = tar.next;
        }
        count--;
        return tar.value;
    }

}
