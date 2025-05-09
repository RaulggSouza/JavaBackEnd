package persistence;

import exception.GastoAlreadyExistsException;
import gasto.Gasto;
import inputs.GastoInput;

import java.util.*;

public class GastosRepository {
    private static final Map<Long, Gasto> gastos = new HashMap<>();

    public void add(){
        Gasto gasto = GastoInput.createGasto();
        Optional<Gasto> maybeDeclaracao= gastos.values()
                .stream()
                .filter(d -> d.equals(gasto))
                .findFirst();
        if (maybeDeclaracao.isEmpty()){
            gastos.put(gasto.getId(), gasto);
        } else {
            throw new GastoAlreadyExistsException("Gasto com esse id já existe");
        }
    }

    public void update(){
        long id = GastoInput.createId();
        Optional<Long> maybeIndexUpdate = gastos.keySet()
                .stream()
                .filter(key -> key.equals(id))
                .findFirst();
        if (maybeIndexUpdate.isPresent()) {
            Gasto gasto = GastoInput.createGasto();
            gastos.replace(id, gasto);
        } else {
            throw new NoSuchElementException("Não existe nenhum gasto com esse indice");
        }
    }

    public void remove(){
        long id = GastoInput.createId();
        Optional<Long> maybeIndexRemove = gastos.keySet()
                .stream()
                .filter(key -> key.equals(id))
                .findFirst();
        if (maybeIndexRemove.isPresent()) {
            gastos.remove(maybeIndexRemove);
        } else {
            System.out.println("Id não encontrado");
        }
    }

    public void listGastos(long id){
        Optional<Gasto> gasto = gastos.values().stream()
                .filter(g -> g.getId() == id)
                .findFirst();
        if(gasto.isPresent()){
            System.out.println(gasto);
        } else {
            throw new NoSuchElementException("Não existe nenhum gasto com esse indice");
        }
    }

    public void listGastos(){
        gastos.values().forEach(System.out::println);
    }

}
