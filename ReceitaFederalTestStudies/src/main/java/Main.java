import persistence.DeclaracaoRepository;
import persistence.GastosRepository;

public class Main {
    public static void main(String[] args) {
//        DeclaracaoRepository declaracaoRepository = new DeclaracaoRepository();
//        declaracaoRepository.add();
        GastosRepository gastosRepository = new GastosRepository();
        gastosRepository.add();
    }
}
