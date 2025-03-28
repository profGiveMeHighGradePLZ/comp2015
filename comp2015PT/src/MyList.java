import java.util.Random;

public class MyList<V extends Comparable<V>>{
    class Node{
        V value;
        Node next;
        int count = 0;
        public Node(){
            count++;
        }
        public Node(V value){
            this.value = value;
            count++;
        }
    }

    int count = 0;
    Node head = new Node();

    public void add(V v){
        Node newNode = new Node(v);
        Node tar = head.next;
        Node prev = head;
        while(tar != null && tar.value.compareTo(v) < 0){
            tar = tar.next;
            prev = prev.next;
        }
        if(tar != null && tar.value.compareTo(v) == 0){
            tar.count++;
        }else {
            prev.next = newNode;
            newNode.next = tar;
            count++;
        }
    }

    public boolean contain(V v){
        Node tar = head.next;
        while(tar != null){
            if(tar.value.compareTo(v) == 0){
                return true;
            }else if (tar.value.compareTo(v) > 0) break;
            tar = tar.next;
        }
        return false;
    }
    public void printAsc(){
        Node tar = head.next;
        while(tar != null){
            System.out.print("  Value: "+tar.value);
            tar = tar.next;
        }
    }
    public void printDsc1(){
        Node tar = head.next;
        String str= "";
        while(tar != null){
            str = tar.value + str+ "  ";
            tar = tar.next;
        }
        System.out.println(str);
        System.out.println();
    }

    public void printDsc2(){
        printDsc2(head.next);
        System.out.println();
    }
    public void printDsc2(Node node){
        if(node != null){
            printDsc2(node.next);
            System.out.print(node.value+"  ");
        }
    }

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        Random random = new Random(1);
        for (int i=0; i<10; i++)
            list.add(random.nextInt(20)+1);
        list.printAsc();
        System.out.println();
        for (int i=1; i<=10; i++)
            System.out.printf("Does %d exists? %s\n", i, list.contain(i) ? "YES":"NO");
    }
}
