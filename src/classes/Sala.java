package classes;

public class Sala {

    private int id;
    private String nome;
    private String local;
    private int capacidade;

    public Sala() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala:\n\n" + "Id: " + id + "\nNome: " + nome + "\nLocal: " + local + "\nCapacidade: " + capacidade;
    }

}
