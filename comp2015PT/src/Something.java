public class Something {
    public static void countdown(int n){
        if(n <= 0){
            return;
        }
        System.out.println(n);
        countdown(n-1);
    }
    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        countdown(1);
        int num = factorial(1);
        System.out.println(num);
    }
}
