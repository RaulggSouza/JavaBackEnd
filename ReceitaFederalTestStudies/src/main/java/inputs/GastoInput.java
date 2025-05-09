package inputs;

import gasto.Gasto;
import gasto.GastoEducacao;
import gasto.GastoSaude;

import java.util.Scanner;

public class GastoInput {
    public static Gasto createGasto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o gasto\nGasto com Saúde: 0\nGastou com Educação: 1");
        int tipoGasto = scanner.nextInt();
        long id = scanner.nextLong();
        scanner.nextLine();
        String descricao = scanner.nextLine();
        double valor = scanner.nextDouble();
        scanner.nextLine();
        String cnpj = scanner.nextLine();
        String adicional = scanner.nextLine();
        Gasto gasto = tipoGasto == 0 ? new GastoSaude(id, descricao, valor, cnpj, adicional)
                : new GastoEducacao(id, descricao, valor, cnpj, adicional);
        scanner.close();
        return gasto;
    }

    public static long createId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o id do gasto que será alterado: ");
        long id = scanner.nextLong();
        scanner.close();
        return id;
    }
}
