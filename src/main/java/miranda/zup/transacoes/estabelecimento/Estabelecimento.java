package miranda.zup.transacoes.estabelecimento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {

    @Deprecated
    public Estabelecimento(){}

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nome ;

    private String cidade ;

    private String endereco ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
