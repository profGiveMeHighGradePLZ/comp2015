public class SalesInsight {
        Tree<String> nameT = new Tree<String>();
        Tree<String> idT = new Tree<String>();
        list<Double,String> myList = new list<>();
        int capacity;
        int count = 0;

        private boolean isFull(){
            return count==capacity;
        }
        private boolean isEmpty(){
            return count ==0;
        }

        public SalesInsight(int capacity) {
            this.capacity = capacity;
        }
        public void add(String id, String name, double revenue) {
            if(isFull()){
                throw new ArrayIndexOutOfBoundsException();
            }
            nameT.tAdd(name,revenue);
            idT.tAdd(id,revenue);
            myList.add(revenue,name);
            count++;
        }
        public double get(String id) {
            return idT.get(id);
        }
        public void bottom() {
            if(isEmpty()){
                return;
            }
            myList.getFirst();
        }
        public void printOrdByName() {
            nameT.print();
        }
        public void printOrdByRevenue() {
            myList.print();
        }



        public static void main(String[] args) {
            SalesInsight salesTermA = new SalesInsight(10);
            salesTermA.add("S79932", "Alice", 235.0);
            salesTermA.add("S84564", "Bob", 252.5);
            salesTermA.add("S75518", "Charlie", 180.0);
            salesTermA.add("S83221", "David", 335.0);
            salesTermA.add("S85315", "Eve", 260.0);
            salesTermA.printOrdByRevenue();

            System.out.println("Update revenues for existing records");
//            salesTermA.add("S83221", null, 355.0);
//            salesTermA.add("S75518", null, 200.0);
            salesTermA.printOrdByRevenue();


            String id = "S83221";
            System.out.printf("The revenue of %s is %.2f\n", id, salesTermA.get(id));
            id = "S83333";
            System.out.printf("The revenue of %s is %.2f\n", id, salesTermA.get(id));

            salesTermA.bottom();
            System.out.println();
            salesTermA.printOrdByName();
        }
    }

