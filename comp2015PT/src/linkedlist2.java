public class linkedlist2 {
    class Node{
        int value;
        Node next;
        public Node(){

        }
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    Node head = new Node();
    Node tail = head;
    int count = 0;

    public int Size(){
        return count;
    }

    public void Print(){
        Node tar = head.next;
        while(tar != null){
            System.out.print("  Value: "+tar.value);
            tar = tar.next;
        }
        System.out.println();
    }

    public void append(int v){
        tail.next = new Node(v);;
        tail = tail.next;
        count++;
    }

    public void remove(int v){
        Node tar = head.next;
        Node prev = head;
        while(tar != null){
            if(tar.value == v){
                if(tar == tail){
                    tail = prev;
                }
                prev.next = tar.next;
                count--;
                return;
            }
            tar = tar.next;
            prev = prev.next;
        }

    }

    public static void main(String[] args) {
        linkedlist2 l = new linkedlist2();
        System.out.println("Append 1 - 10");
        for (int i = 1; i <= 10; i++)
            l.append(i);
        l.Print();

        System.out.println("Remove 1 (1st value) then append 11");
        l.remove(1);
        l.append(11);
        l.Print();

        System.out.println("Remove 5 (one of the values near the middle) then append 12");
        l.remove(5);
        l.append(12);
        l.Print();

        System.out.println("Remove 12 (last value) then append 13");
        l.remove(12);
        l.append(13);
        l.Print();

    }

}
