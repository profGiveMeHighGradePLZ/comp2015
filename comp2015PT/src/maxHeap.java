public class maxHeap<V extends Comparable<V> > {
    V[] storage;
    int count = 0;

    public maxHeap(int length){
        storage = (V[]) new Comparable[length+1];
    }

    private boolean isEmpty(){
        return count==0;
    }
    private boolean isFull(){
        return count == storage.length-1;
    }
    public void add(V v){
        if(isFull()){
            return;
        }
        storage[++count] = v;
        percolatingUp(count);
    }
    private void percolatingUp(int c){
        int p = c/2;
        while(c > 1 && storage[p].compareTo(storage[c])>0){
            swap(p,c);
            c = p;
            p = c/2;
        }
    }
    private void swap(int a,int b){
        V tmp = storage[a];
        storage[a] = storage[b];
        storage[b] = tmp;
    }
    public V delMax(){
        if(isEmpty()){
            return null;
        }
        V tar = storage[1];
        storage[1] = storage[count];
        storage[count] = null;
        count--;
        percolatingDown(1);
        return tar;
    }
    private void percolatingDown(int c){
        int l = c*2;
        int r = l+1;
        while(l <= count){
            if(r >count || storage[l].compareTo(storage[r]) < 0){
                if(storage[l].compareTo(storage[c]) < 0){
                    swap(c,l);
                    c = l;
                    l = c*2;
                    r = l+1;
                }else{
                    break;
                }
            }else {
                if(storage[r].compareTo(storage[c]) < 0){
                    swap(c,r);
                    c = r;
                    l = c*2;
                    r = l+1;
                }else{
                    break;
                }
            }
        }
    }

    public void printAll() {
        for (V v: storage)
            System.out.print(v + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        maxHeap<Integer> heap = new maxHeap<>(10);
//        Random rand = new Random(1);
//
//        while(!heap.isFull()) {
//            int v = rand.nextInt(10) + 1;
//            System.out.println("Add " + v);
//            heap.add(v);
//        }

        for (int n: new int[]{5,9,4,6,3,2})
            heap.add(n);

        heap.delMax();

        heap.printAll();

        while(!heap.isEmpty())
            System.out.print(heap.delMax() + " ");
        System.out.println();

        String[] data = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
//        MaxHeap.sort(data);

        for(String d: data)
            System.out.print(d + " ");
        System.out.println();

    }
}
