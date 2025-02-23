import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];
        int[] line = new int[n];
        int[] col = new int[n];
        int maior = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                line[i] += matrix[i][j];
                col[i] += matrix[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = col[j] + line[i] - matrix[i][j]*2;
                if (sum > maior) maior = sum;
            }
        }
        System.out.println(maior);
    }
}
