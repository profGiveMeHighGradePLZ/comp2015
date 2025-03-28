public class WordCounter {
    BST<String> wordCounter = new BST<>();

    public void add(String str){
        wordCounter.add(str);
    }
    public void printAsc(){
        wordCounter.printAsc();
    }

    public static void main(String[] args) {
        String[] words = "a dog is on my left hand side a cat is on my right hand side so a dog is on the cat's left hand side".split("\\s");
        WordCounter counter = new WordCounter();
        for (String word : words)
            counter.add(word);
        counter.printAsc();
    }

//    private BST.Node<V> getminNode(BST.Node<V> node){
//        BST.Node<V> t = node;
//        BST.Node<V> p = node;
//        while(t != null){
//            p = t;
//            t = t.children[LEFT];
//        }
//        return p;
//    }
//
//    public void del(V v){
//        del(v,root);
//    }
//
//    private void del(V v, BST.Node<V> node){
//        BST.Node<V> parent = root;
//        BST.Node<V> tar = root;
//        int LorR = -1;
//        while(tar != null && tar.value.compareTo(v) != 0){
//            int comp = tar.value.compareTo(v);
//            if(comp < 0){
//                LorR = RIGHT;
//            }else{
//                LorR = LEFT;
//            }
//            parent = tar;
//            tar = tar.children[LorR];
//        }
//        if(tar != null){
//            if(tar.children[LEFT] == null){
//                if(tar == root)
//                    root = tar.children[RIGHT];
//                else
//                    parent.children[LorR] = tar.children[RIGHT];
//                count--;
//            }else if(tar.children[RIGHT] == null){
//                if(tar == root)
//                    root = tar.children[LEFT];
//                else
//                    parent.children[LorR] = tar.children[LEFT];
//                count--;
//            }else{
//                BST.Node<V> minNode = getminNode(tar.children[RIGHT]);
//                tar.value = minNode.value;
//                if(tar.children[RIGHT] == minNode){
//                    tar.children[RIGHT] = minNode.children[RIGHT];
//                    count--;
//                }else{
//                    del(tar.value,tar.children[RIGHT]);
//                }
//            }
//        }
//    }
}
