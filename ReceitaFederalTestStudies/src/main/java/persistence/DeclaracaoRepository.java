package persistence;

import declaracao.Declaracao;
import declaracao.DeclaracaoCompleta;
import declaracao.DeclaracaoSimplificada;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class DeclaracaoRepository {
    private static final Map<Long, Declaracao> declaracoes = new HashMap<>();
    private static long declarationCounter = 0;

    public void add(){
        Declaracao declaracao = createDeclaracao();
        declaracoes.put(declarationCounter++, declaracao);
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o id da declaração que será alterada: ");
        long id = scanner.nextLong();
        if (!declaracoes.containsKey(id)){
            System.out.println("Não existe nenhuma declaração com esse id");
            return;
        }
        scanner.close();
        Declaracao declaracao = createDeclaracao();
        declaracoes.replace(id, declaracao);
    }

    private Declaracao createDeclaracao(){
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
