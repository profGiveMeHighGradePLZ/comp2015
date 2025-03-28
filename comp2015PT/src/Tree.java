public class Tree<K extends Comparable<K>> {
    class Node<K>{
        K key;
        double value;
        Node<K>[] children = (Node<K>[]) new Node[2];

    }

    int left = 0;
    int right = 1;
    Node<K> root;

    public void tAdd(K k,double v){
        Node<K> newNode = (Node<K>) new Node();
        newNode.key = k;
        newNode.value = v;
        if(root == null){
            root = newNode;
        }else{
            Node<K> tar = root;
            Node<K> parent = root;
            int LorR = -1;
            while(tar != null){
                int comp = tar.key.compareTo(k);
                if(comp < 0){
                    LorR = right;
                }else if(comp > 0){
                    LorR = left;
                }else{
                    tar.value = v;
                    break;
                }
                parent = tar;
                tar = tar.children[LorR];
            }
            parent.children[LorR] = newNode;
        }
    }
    public double get(K k){
        Node<K> tar = root;
        Node<K> parent = root;
        int LorR = -1;
        while(tar != null){
            int comp = tar.key.compareTo(k);
            if(comp < 0){
                LorR = right;
            }else if(comp > 0){
                LorR = left;
            }else{
                return tar.value;
            }
            parent = tar;
            tar = tar.children[LorR];
        }
        return 0;
    }
    public void print(){
        print(root);
    }
    private void print(Node<K> node){
        if(node == null){
            return;
        }
        print(node.children[left]);
        System.out.println(node.key + "(" + node.value+")"+"  ");
        print(node.children[right]);
    }
}
