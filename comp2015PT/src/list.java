public class list <K extends Comparable<K>,V>{
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
    }

    Node<K,V> head = new Node<>();

    public void add(K k,V v){
        Node<K,V> newNode = new Node<>();
        newNode.key = k;
        newNode.value = v;
        Node<K,V> tar = head.next;
        Node<K,V> prev = head;

        while(tar != null && tar.key.compareTo(k) < 0){
            tar = tar.next;
            prev = prev.next;
        }

        prev.next = newNode;
        newNode.next = tar;

    }

    public void getFirst(){
        System.out.println(head.next.value+" "+head.next.key);
    }

    public void print(){
        Node<K,V> tar = head.next;
        while(tar != null){
            System.out.println(tar.value+" "+tar.key);
            tar = tar.next;
        }
    }
}
