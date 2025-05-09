package inputs;

import declaracao.Declaracao;
import declaracao.DeclaracaoCompleta;
import declaracao.DeclaracaoSimplificada;

import java.util.Scanner;

public class DeclaracaoInput{
    public static Declaracao createDeclaracao(){
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

    public static long createId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o id da declaração que será alterada: ");
        long id = scanner.nextLong();
        scanner.close();
        return id;
    }
}
