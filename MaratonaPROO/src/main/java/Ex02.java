import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int X = scan.nextInt();
        int Y = scan.nextInt();
        int Z = scan.nextInt();
        int result = (X/A) * (Y/B) * (Z/C);
        System.out.println(result);
    }
}
