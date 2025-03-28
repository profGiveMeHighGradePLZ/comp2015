public class Stack<V extends Comparable<V>> {
    BasicList<V> stack = new BasicList<V>();

    public void push(V v){
        stack.addFirst(v);
    }

    public V top(){
        V tmp = stack.RemoveFirst();
        stack.addFirst(tmp);
        return tmp;
    }

    public V pop(){
        return stack.RemoveFirst();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<10; i++) {
            System.out.println("push: " + i);
            stack.push(i);
            if (i%3==0) {
                System.out.println("pop: " + stack.pop());
                System.out.println("top: " + stack.top());
            }
        }
        System.out.print("pop: ");
        for (int i=0; i<10; i++)
            System.out.print(stack.pop() + " ");
        System.out.println();
    }
}
