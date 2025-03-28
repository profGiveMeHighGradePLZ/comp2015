public class BST<K extends Comparable<K>, V> {
    class Node<K,V>{
        K key;
        V value;
        Node<K,V>[] children = (Node<K, V>[]) new Node[2];
    }

    Node<K,V> root;

    public void add(K k,V v){
        Node<K,V> parent = root,tar = root;
        int LorR = -1;
        int comp;
        while(tar != null){
            comp = k.compareTo(tar.key);
            if(comp < 0){
                LorR = 0;
            }else if(comp > 0){
                LorR = 1;
            }else{
                tar.value = v;
                return;
            }
            parent = tar;
            tar = tar.children[LorR];
        }
        Node<K,V> newNode = new Node<>();
        newNode.key = k;
        newNode.value = v;
        if(root == null) root = newNode;
        else parent.children[LorR] = newNode;
    }

}
