public class BST<V extends Comparable<V>> {
    class Node<V>{
        V value;
        int occur = 1;
        Node<V>[] children = (Node<V>[]) new Node[2];
    }

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    Node<V> root;
    int count = 0;

    public void add(V v){
        Node<V> parent = root;
        Node<V> tar = root;
        int LorR = -1;
        while(tar!=null){
            int comp = tar.value.compareTo(v);
            if(comp < 0){
                LorR=RIGHT;
            }else if(comp > 0){
                LorR=LEFT;
            }else{
                tar.occur++;
                return;
            }
            parent = tar;
            tar = tar.children[LorR];
        }

        Node<V> newNode = new Node<>();
        newNode.value = v;
        if(root == null){
            root = newNode;
            return;
        }
        parent.children[LorR] = newNode;

        count++;

    }

    public void printAsc(){
        printAsc(root);
        System.out.println();
    }
    private void printAsc(Node<V> node){
        if(node == null){
            return;
        }
        printAsc(node.children[LEFT]);
        System.out.print(node.value+"("+node.occur+")"+"  ");
        printAsc(node.children[RIGHT]);
    }

    private Node<V> getMinNode(Node<V> node){
        Node<V> p = node;
        Node<V> t = node;
        while(t != null){
            p = t;
            t = t.children[LEFT];
        }
        return p;
    }


    public void del(V v){
        del(v,root);
    }
    private void del(V v,Node<V> node){
        Node<V> parent = node;
        Node<V> tar = node;
        int LorR = -1;
        while(tar != null && tar.value.compareTo(v) != 0){
            if(tar.value.compareTo(v) < 0){
                LorR = RIGHT;
            }else{
                LorR = LEFT;
            }
            parent = tar;
            tar = tar.children[LorR];
        }
        if(tar != null){
            if(tar.children[RIGHT] == null){
                if(tar == root){
                    root = tar.children[LEFT];
                }else{
                    parent.children[LorR] = tar.children[LEFT];
                }
                count--;
            }else if(tar.children[LEFT] == null){
                if(tar==root){
                    root = tar.children[RIGHT];
                }else{
                    parent.children[LorR] = tar.children[RIGHT];
                }
                count--;
            }else{
                Node<V> minNode = getMinNode(tar.children[RIGHT]);
                tar.value = minNode.value;
                if(tar.children[RIGHT] == minNode){
                    tar.children[RIGHT] = minNode.children[RIGHT];
                    count--;
                }else {
                    del(tar.value,tar.children[RIGHT]);
                }
            }
        }
    }
}
