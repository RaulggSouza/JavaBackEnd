package inputs;

import declaracao.Declaracao;
import declaracao.DeclaracaoCompleta;
import declaracao.DeclaracaoSimplificada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeclaracaoInput{
    public static Declaracao createDeclaracao() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a declaração\nDeclaração simplificada: 0\nDeclaração completa: 1");
        int tipoDeclaracao = scanner.nextInt();
        double ganho = scanner.nextDouble();
        double valor = scanner.nextDouble();
        Declaracao declaracao = tipoDeclaracao == 0 ? new DeclaracaoSimplificada(ganho, valor)
                : new DeclaracaoCompleta(ganho, valor);
        scanner.close();
        return declaracao;
    }
}
