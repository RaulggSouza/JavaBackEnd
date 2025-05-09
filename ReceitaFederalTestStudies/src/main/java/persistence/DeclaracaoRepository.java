package persistence;

import declaracao.Declaracao;
import declaracao.DeclaracaoCompleta;
import declaracao.DeclaracaoSimplificada;
import inputs.DeclaracaoInput;

import java.util.*;

public class DeclaracaoRepository {
    private static final Map<Long, Declaracao> declaracoes = new HashMap<>();
    private static long declarationCounter = 0;

    public void add(){
        Declaracao declaracao = DeclaracaoInput.createDeclaracao();
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
        Declaracao declaracao = DeclaracaoInput.createDeclaracao();
        declaracoes.replace(id, declaracao);
    }

    public void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o id do gasto que será alterado: ");
        Long id = scanner.nextLong();

        scanner.close();
        Optional<Long> maybeIndexRemove = declaracoes.keySet()
                .stream()
                .filter(key -> key.equals(id))
                .findFirst();
        if (maybeIndexRemove.isPresent()) {
            declaracoes.remove(maybeIndexRemove);
        } else {
            throw new NoSuchElementException("Não existe nenhuma declaração com esse indice");
        }
    }
}
