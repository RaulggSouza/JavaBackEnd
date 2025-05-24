package gasto;

public final class GastoSaude extends Gasto{
    private final String registroConselho;
    public static final double DEDUCAO_MAX_SAUDE = 1500;
    public GastoSaude(long id, String descricao, double valor, String cnpj, String registroConselho) {
        super(id, descricao, valor, cnpj);
        this.registroConselho = registroConselho;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    @Override
    public String toString() {
        return String.format("%s | Registro de Conselho: %s", super.toString(), registroConselho);
    }
}
