package persistence;

import declaracao.Declaracao;
import declaracao.DeclaracaoCompleta;
import declaracao.DeclaracaoSimplificada;
import gasto.Gasto;
import gasto.GastoEducacao;
import gasto.GastoSaude;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class GastosRepository {
    private static final Map<Long, Gasto> gastos = new HashMap<>();

    public void add(){
        Gasto gasto = createGasto();
        gastos.put(gasto.getId(), gasto);
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o id do gasto que será alterado: ");
        long id = scanner.nextLong();
        if (!gastos.containsKey(id)){
            System.out.println("Não existe nenhum gasto com esse id");
            return;
        }
        scanner.close();
        Gasto gasto = createGasto();
        gastos.replace(id, gasto);
    }

    public void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o id do gasto que será alterado: ");
        long id = scanner.nextLong();
        scanner.close();
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

    private Gasto createGasto(){
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
}
