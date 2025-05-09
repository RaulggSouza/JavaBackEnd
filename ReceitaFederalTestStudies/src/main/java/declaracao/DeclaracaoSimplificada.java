package declaracao;

public final class DeclaracaoSimplificada extends Declaracao{
    public DeclaracaoSimplificada(double ganhoTributavel, double valorPago) {
        super(ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {
        double imposto = getGanhoTributavel() > 22_847.88 ? (getGanhoTributavel()-22_847.88)*0.2-getValorPago() : 0;
        return imposto > 0 ? imposto : 0;
    }
}
