import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double masterKung = 0;
        double masterLu = 0;
        String output = "";
        int matches = 0;
        //Master Kung = 1
        //Master Lu = 9
        for (int i = 1; i < 17; i++) {
            int player = scan.nextInt();
            if (player == 1) masterKung = i;
            else if (player == 9) masterLu = i;
        }
        while (masterKung != masterLu){
            matches++;
            masterKung = Math.ceil(masterKung/2);
            masterLu = Math.ceil(masterLu/2);
        }
        switch (matches){
            case 1:
                output = "oitavas";
                break;
            case 2:
                output = "quartas";
                break;
            case 3:
                output = "semifinal";
                break;
            case 4:
                output = "final";
                break;
        }
        System.out.println(output);
    }
}
