package declaracao;

import java.util.Objects;

public abstract sealed class Declaracao permits DeclaracaoSimplificada, DeclaracaoCompleta{
    private final double ganhoTributavel;
    private final double valorPago;

    public Declaracao(double ganhoTributavel, double valorPago) {
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel(){
        return 0;
    }

    public abstract double getValorImposto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return Double.compare(ganhoTributavel, that.ganhoTributavel) == 0 && Double.compare(valorPago, that.valorPago) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ganhoTributavel, valorPago);
    }

    @Override
    public String toString() {
        return String.format("Ganho Tributável: %.2f | Valor Pago: %.2f", ganhoTributavel, valorPago);
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }
}
