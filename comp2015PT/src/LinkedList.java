public class LinkedList<T extends Comparable<T>> {
    class Node{
        T value;
        Node next;
        public Node(){

        }
        public Node(T value){
            this.value = value;
        }
        public Node(T value, Node next){
            this.value = value;
            this.next = next;
        }

    }

    Node head = new Node();
    int count = 0;

    public void addBegin(T val){
        Node newNode = new Node();
        newNode.value = val;
        newNode.next = head.next;
        head.next = newNode;
        count++;
    }
    public void addsort(T v){
        Node tar = head.next;
        Node prev = head;
        while(tar != null && tar.value.compareTo(v) < 0){
            tar = tar.next;
            prev = prev.next;
        }
        Node newNode = new Node(v);
        prev.next = newNode;
        newNode.next = tar;

        count++;
    }
    public T get(int n){
        if(n >= count){
            throw new ArrayIndexOutOfBoundsException("n is greater than the length of the linked list");
        }
        Node tar = head.next;
        for(int i = 0;i<n;i++){
            tar = tar.next;
        }
        return tar.value;
    }

    public T remove(int i){
        if(i >= count){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node tar = head.next;
        Node prev = head;
        for(int k = 0;k<i;k++){
            tar = tar.next;
            prev = prev.next;
        }
        prev.next = tar.next;
        count--;
        return tar.value;
    }

    public int size(){
        return count;
    }
}
