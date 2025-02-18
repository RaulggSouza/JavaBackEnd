import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = 1;
        int aux = Integer.MIN_VALUE;
        int maior = 1;
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt();
            if (v == aux){
                s++;
            } else {
                s = 1;
            }
            if (s > maior) maior = s;
            aux = v;
        }
        System.out.println(maior);
    }
}
