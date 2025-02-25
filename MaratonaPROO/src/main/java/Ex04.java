import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] grid = new int[10][10];
        String output = "Y";
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            int d = scan.nextInt();
            int l = scan.nextInt();
            int r = (scan.nextInt())-1;
            int c = (scan.nextInt())-1;
            grid[r][c]++;
            if(d == 0){
                if (c+(l-1) > 9){
                    output = "N";
                    break;
                }
                for (int j = 1; j <= l-1; j++) {
                    grid[r][c+j]++;
                }
            }else{
                if (r+(l-1) > 9){
                    output = "N";
                    break;
                }
                for (int j = 1; j <= l-1; j++) {
                    grid[r+j][c]++;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(grid[i][j] > 1){
                    output = "N";
                    break;
                }
            }
        }
        System.out.println(output);
    }
}
