public class hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int N = 10;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}