package classes;

public class Aluno extends Pessoa {

    private int matricula;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Dados do aluno: \n\nMatricula: " + matricula + super.toString();
    }

}
