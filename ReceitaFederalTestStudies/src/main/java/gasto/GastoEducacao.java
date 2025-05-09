package gasto;

public final class GastoEducacao extends Gasto{
    private final String nomeInstituicao;
    public static final double DEDUCAO_MAX_EDUCA = 2000;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    @Override
    public String toString() {
        return String.format("%s | Nome da Instituição: %s", super.toString(), nomeInstituicao);
    }
}
