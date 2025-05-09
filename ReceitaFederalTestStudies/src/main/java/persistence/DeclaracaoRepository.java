package persistence;

import declaracao.Declaracao;
import exception.DeclarationAlreadyExistsException;
import gasto.Gasto;
import inputs.DeclaracaoInput;

import java.util.*;

public class DeclaracaoRepository {
    private static final Map<Long, Declaracao> declaracoes = new HashMap<>();
    private static long declarationCounter = 0;

    public void add(){
        Declaracao declaracao = DeclaracaoInput.createDeclaracao();
        Optional<Declaracao> maybeDeclaracao= declaracoes.values()
                .stream()
                .filter(d -> d.equals(declaracao))
                .findFirst();
        if (maybeDeclaracao.isEmpty()){
            declaracoes.put(declarationCounter++, declaracao);
        } else {
            throw new DeclarationAlreadyExistsException("Declaração já existe");
        }
    }

    public void update(){
        long id = DeclaracaoInput.createId();
        Optional<Long> maybeIndexRemove = declaracoes.keySet()
                .stream()
                .filter(key -> key.equals(id))
                .findFirst();
        if (maybeIndexRemove.isPresent()) {
            Declaracao declaracao = DeclaracaoInput.createDeclaracao();
            declaracoes.replace(id, declaracao);
        } else {
            throw new NoSuchElementException("Não existe nenhuma declaração com esse indice");
        }
    }

    public void remove(){
        long id = DeclaracaoInput.createId();
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

    public void listDeclaracao(long id){
        Optional<Long> declaracao = declaracoes.keySet().stream()
                .filter(d -> d.equals(id))
                .findFirst();
        if(declaracao.isPresent()){
            System.out.println(declaracoes.get(declaracao));
        } else {
            throw new NoSuchElementException("Não existe nenhum gasto com esse indice");
        }
    }

    public void listGastos(){
        declaracoes.values().forEach(System.out::println);
    }
}
