public class RecordManager {
    Tree treeByID = new Tree(){
        @Override
        int compare(Student a, Student b) {
            return a.ID.compareTo(b.ID);
        }
    };

    Tree treeByName = new Tree() {
        @Override
        int compare(Student a, Student b) {
            return a.name.compareTo(b.name);
        }
    };

    Tree treeByAge = new Tree() {
        @Override
        int compare(Student a, Student b) {
            return a.age<b.age?-1:1;
        }
    };

    public void add(Student s){
        treeByAge.add(s);
        treeByID.add(s);
        treeByName.add(s);
    }

    public void printOrdByName(){
        treeByName.print();
    }

    public void printOrdByAge(){
        treeByAge.print();
    }

    public void printOrdByID(){
        treeByID.print();
    }


}
