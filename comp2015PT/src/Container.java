class Box implements Comparable<Box> {
    int weight;

    public Box(int weight) {
        this.weight = weight;
    }

    public int compareTo(Box another) {
        return weight - another.weight;
    }

}

public class Container<V extends Comparable<V>> {

    BST1<V> tree = new BST1<V>();
    int length;
    int total = 0;

    public void build(V[] v){
        length = v.length;
        for(int i = 0;i<v.length;i++){
            total += ((Box)v[i]).weight;
            tree.add(v[i]);
        }
    }
    public void put(V v){
        if(tree.count >= length){
            throw new RuntimeException("This container is full!");
        }
        tree.add(v);
        total += ((Box)v).weight;

    }
    public int totalWeight(){
        return total;
    }
    public V getLightest(){
        V tmp = tree.removeFirst();
        total -= ((Box)tmp).weight;
        return tmp;
    }



    public static void main(String[] args) {
        int[] data = { 5, 3, 6, 1, 7, 9, 4 };
        Box[] boxes = new Box[data.length];

        for (int i = 0; i < data.length; i++)
            boxes[i] = new Box(data[i]);

        Container<Box> container = new Container<>();
        container.build(boxes);

        try {
            container.put(new Box(100));
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }

        System.out.printf("Total weight is %d kg.\n", container.totalWeight());

        Box b = container.getLightest();

        System.out.printf("Total weight is %d kg.\n", container.totalWeight());

        b.weight += 100;
        container.put(b);

        System.out.printf("Total weight is %d kg.\n", container.totalWeight());
    }
}