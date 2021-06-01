package miranda.zup.transacoes.estabelecimento;

public class EstabelecimentoResponse {
    public EstabelecimentoResponse() {
    }

    private String nome ;

    private String cidade ;

    private String endereco ;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(){
        return new Estabelecimento(nome,cidade,endereco);
    }

    @Override
    public String toString() {
        return "EstabelecimentoResponse{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
