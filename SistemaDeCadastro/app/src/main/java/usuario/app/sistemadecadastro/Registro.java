package usuario.app.sistemadecadastro;

/**
 * Created by Rodrigo on 25/03/2016.
 */
public class Registro {
    private String nome;
    private String endereco;
    private String telefone;

    public Registro(String nome, String endereco, String telefone)  {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;  }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
}

