public abstract class Tree {
    public class Node{
        Student value;
        Node[] children = new Node[2];
    }

    //    private Node ID_Tree = new Node();
//    private Node name_Tree = new Node();
//    private Node age_Tree = new Node();
    private Node root = new Node();

    public Tree(){}
    abstract int compare(Student a, Student b);


    public void add(Student s){
        Node tmp = new Node();
        tmp.value = s;
        if(root == null){
            root = tmp;
        }else{
            Node parent = root;
            Node tar = root;
            int LorR = -1;
            while(tar != null){
                parent = tar;
                if(compare(s,root.value) < 0){
                    LorR = 0;
                }else{
                    LorR = 1;
                }
                tar = tar.children[LorR];
            }
            if(compare(s,root.value) < 0){
                LorR = 0;
            }else{
                LorR = 1;
            }
            parent.children[LorR] = tmp;
        }
    }

    public void print(Node node){
        if(node == null) return;
        print(node.children[0]);
        System.out.println(node.value);
        print(node.children[1]);
    }
    public void print(){
        print(root);
    }


}
