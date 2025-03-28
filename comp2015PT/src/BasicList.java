public class BasicList<V extends Comparable<V>> {
    class Node{
        V value;
        Node next;
        Node prev;
    }

    Node head = new Node();
    Node tail = head;
    int count = 0;

    public void addFirst(V v){
        Node newNode = new Node();
        newNode.value = v;

        newNode.next = head.next;
        if(tail == head){
            tail = newNode;
        }else{
            head.next.prev = newNode;

        }
        head.next = newNode;
        newNode.prev = head;

    }

    public void addLast(V v){
        Node newNode = new Node();
        newNode.value = v;
        newNode.prev = tail;
        tail.next = newNode;
        tail = tail.next;
    }

    public V RemoveFirst(){
        if(head.next == null){
            return null;
        }
        Node tar = head.next;
        if(tar == tail){
            tail = head;
            head.next = null;
        }else {
            tar.next.prev = head;
            head.next = tar.next;
        }
        return tar.value;
    }

    public V RemoveLast(){
        if(tail == head){
            return null;
        }
        Node tar = tail;
        tail = tail.prev;
        tail.next = null;
        return tar.value;
    }

    public void print(){
        Node tar = head.next;
        while(tar != null){
            System.out.print(tar.value + "  ");
            tar = tar.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BasicList<Character> list = new BasicList<>();
        for(int i=0; i<5; i++)
            list.addFirst((char)('A' + i));
        System.out.println("After Adding some characters using addFirst:");
        list.print();
        for(int i=0; i<5; i++)
            list.addLast((char)('M' + i));
        System.out.println("After Adding some characters using addLast:");
        list.print();
        System.out.println("Remove first: " + list.RemoveFirst());
        System.out.println("Remove first: " + list.RemoveFirst());
        System.out.println("Remove last: " + list.RemoveLast());
        System.out.println("Remove last: " + list.RemoveLast());
        System.out.println("After removing some characters using removeFirst twice and removeLast twice:");
        list.print();
        list.addFirst('X');
        list.addLast('Z');
        System.out.println("After removing two characters using removeFirst and removeLast respectively:");
        list.print();
    }
}
