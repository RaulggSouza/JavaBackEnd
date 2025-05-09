package declaracao;

import gasto.Gasto;
import gasto.GastoEducacao;
import gasto.GastoSaude;

import java.util.*;

public final class DeclaracaoCompleta extends Declaracao{
    private final List<Gasto> gastos;
    public DeclaracaoCompleta(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
        gastos = new ArrayList<>();
    }

    @Override
    public double getValorImposto() {
        double imposto = 0.0;
        double gastosDedutiveis = getDespesaDedutivel();
        while(gastosDedutiveis > 22_847.88){
            double porcentagem;
            double somaImposto;
            if (gastosDedutiveis > 55_976.16) {
                somaImposto = (gastosDedutiveis - 55_976.16);
                porcentagem = 0.275;
            } else if(gastosDedutiveis > 45_012.73){
                somaImposto = gastosDedutiveis - 45_012.73;
                porcentagem = 0.225;
            } else if(gastosDedutiveis > 33_919.93){
                somaImposto = gastosDedutiveis - 33_919.93;
                porcentagem = 0.150;
            } else {
                somaImposto = gastosDedutiveis - 22_847.88;
                porcentagem = 0.075;
            }
            imposto += somaImposto*porcentagem;
            gastosDedutiveis -= somaImposto;
        }
        return imposto;
    }


    @Override
    public double getDespesaDedutivel() {
        return gastos.stream()
                .reduce(0.0, (acc, gasto) -> {
                    double limite = gasto instanceof GastoSaude
                            ? GastoSaude.DEDUCAO_MAX_SAUDE
                            : GastoEducacao.DEDUCAO_MAX_EDUCA;
                    return gasto.getValor() + acc <= limite ? gasto.getValor() + acc : acc;
                }, Double::sum);
    }

    public void addGasto(Gasto gasto){
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto){
        gastos.remove(gasto);
    }

    public List<Gasto> getGastos() {
        return new ArrayList<>(gastos);
    }
}
