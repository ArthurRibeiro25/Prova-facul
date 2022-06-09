package classes;

public class Pessoa {
    
    private String nome;
    private long cpf;
    private String endereco;
    private String email;
    private long celular;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        String a = "\nNome: " + nome + "\nCpf: " + cpf + "\nEndereco: " + endereco + "\nEmail: " + email + "\nCelular: " + celular + "\n\n";
        return a;
    }  
}
