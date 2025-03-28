public class SimpleWordCounter {
    class Word {
        String str;
        int freq;
        public Word(String str) {
            this.str = str;
            this.freq = 1;
        }
    }

    class Node{
        Word value;
        Node[] children = new Node[2];
    }

    int LEFT = 0;
    int RIGHT = 1;
    Node root;
    int total = 0;

    public void add(String str){
        Node newNode = new Node();
        newNode.value = new Word(str);

        if(root == null){
            root = newNode;
        }else{
            int LorR = -1;
            Node tar = root;
            Node parent = root;
            while(tar != null){
                int comp = tar.value.str.compareTo(str);
                if(comp < 0){
                    LorR = RIGHT;
                }else if(comp > 0){
                    LorR = LEFT;
                }else{
                    tar.value.freq++;
                    return;
                }
                parent = tar;
                tar = tar.children[LorR];
            }
            parent.children[LorR] = newNode;
        }
        total++;
    }

    public void count(){
        count(root);
        System.out.println();
    }

    private void count(Node node){
        if(node == null){
            return;
        }
        count(node.children[LEFT]);
        System.out.print(node.value.str+"("+node.value.freq+")"+"  ");
        count(node.children[RIGHT]);

    }

    public static void main(String[] args) {
        String[] words = {
                "Laptop", "TV", "Phone", "Headphone", "Tablet", "Laptop", "Camera", "TV", "Phone",
                "Headphone", "Tablet", "Laptop", "Camera", "TV", "Phone", "Headphone", "Tablet",
                "Laptop", "Camera", "TV", "Phone"
        };

        SimpleWordCounter wc = new SimpleWordCounter();
        for (String s : words) {
            wc.add(s);
            wc.count();
        }
    }
}
