public class Queue<V extends Comparable<V>> {
    BasicList<V> queue = new BasicList<V>();


    public void enqueue(V v){
        queue.addLast(v);
    }

    public V dequeue(){
        return queue.RemoveFirst();
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i=0; i<10; i++) {
            System.out.println("enqueue: " + i);
            queue.enqueue(i);
            if (i%3==0) {
                System.out.println("dequeue: " + queue.dequeue());
            }
        }
        System.out.print("dequeue: ");
        for (int i=0; i<10; i++)
            System.out.print(queue.dequeue() + " ");
        System.out.println();
    }
}
