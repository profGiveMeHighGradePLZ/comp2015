public class Student{
    public String ID;
    public String name;
    public int age;
    public Student(String ID, String name, int age){
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student s){
        return this.ID.compareTo(s.ID);
    }

    @Override
    public String toString() {
        return "ID: " + ID +", Name: " + name + ", Age: " + age;
    }
}

