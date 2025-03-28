public class Dictionary <K extends Comparable<K>,V>{
    class Node<K,V>{
        K key;
        V value;
        Node<K,V>[] children  = (Node<K,V>[]) new Node[2];
    }

    Node<K,V> root;

    public void set(K k,V v){
        Node<K,V> parent = root, tar = root;
        int LorR = -1;
        while(tar != null){
            if(k.compareTo(tar.key) < 0){
                LorR = 0;
            } else if (k.compareTo(tar.key) == 0) {
                tar.value = v;
                return;
            }else{
                LorR = 1;
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

    public V get(K k){
        if(root == null) return null;

        Node<K,V> parent = root, tar = root;
        int LorR = -1;
        while(tar != null && tar.key.compareTo(k) != 0){
            if(k.compareTo(tar.key) < 0){
                LorR = 0;
            }else{
                LorR = 1;
            }
            parent = tar;
            tar = tar.children[LorR];
        }

        if(tar == null) return null;
        return tar.value;
    }

    public V remove(K k){
        return remove(root,k);
    }

    private V remove(Node<K,V> node,K k){
        Node<K,V> parent = node, tar = node;
        int LorR = -1;
        while(tar != null && tar.key.compareTo(k) != 0){
            if(k.compareTo(node.key) < 0){
                LorR = 0;
            }else{
                LorR = 1;
            }
            parent = tar;
            tar = tar.children[LorR];
        }

        if(tar == null) return null;

        Node<K,V> tmp = tar;
        if(tar.children[1] == null){
            if(tar == node)
                node = tar.children[0];
            else
                parent.children[LorR] = tar.children[0];
        } else if (tar.children[0] == null) {
            if(tar == node)
                node = tar.children[1];
            else
                parent.children[LorR] = tar.children[1];
        }else{
            Node<K,V> min = getMin(tar.children[1]);
            tar.key = min.key;
            tar.value = min.value;
            if(tar.children[1] == min){
                tar.children[1] = min.children[1];
            }else
                remove(tar.children[1], tar.key);
        }

        return (V) tmp.value;
    }

    private Node<K,V> getMin(Node<K,V> node){
        Node<K,V> parent = node, tar = node;
        while(tar != null){
            parent = tar;
            tar = tar.children[0];
        }
        return parent;
    }

    public void printAll(){
        Traverse(root);
        System.out.println();
    }
    private void Traverse(Node<K,V> node){
        if(node == null) return;
        Traverse(node.children[0]);
        System.out.print(node.key + ": " + node.value + ", ");
        Traverse(node.children[1]);
    }

}
