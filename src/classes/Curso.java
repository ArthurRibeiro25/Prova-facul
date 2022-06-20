package classes;

import Controller.ControllerAlunoCurso;

public class Curso {

    ControllerAlunoCurso cac = new ControllerAlunoCurso();

    private int curso_cod;
    private String curso;
    private int carga_h;
    private String curso_desc;
    private String status;
    private int func_cod;
    private String professor;
    private int sala_cod;
    private String sala_nome;
    private String sala_local;
    private int capacidade;

    public Curso() {

    }

    public int getCurso_cod() {
        return curso_cod;
    }

    public void setCurso_cod(int curso_cod) {
        this.curso_cod = curso_cod;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCarga_h() {
        return carga_h;
    }

    public void setCarga_h(int carga_h) {
        this.carga_h = carga_h;
    }

    public String getCurso_desc() {
        return curso_desc;
    }

    public void setCurso_desc(String curso_desc) {
        this.curso_desc = curso_desc;
    }

    public int getFunc_cod() {
        return func_cod;
    }

    public void setFunc_cod(int func_cod) {
        this.func_cod = func_cod;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getSala_cod() {
        return sala_cod;
    }

    public void setSala_cod(int sala_cod) {
        this.sala_cod = sala_cod;
    }

    public String getSala_nome() {
        return sala_nome;
    }

    public void setSala_nome(String sala_nome) {
        this.sala_nome = sala_nome;
    }

    public String getSala_local() {
        return sala_local;
    }

    public void setSala_local(String sala_local) {
        this.sala_local = sala_local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Curso:\n\n" + "ID do curso: " + curso_cod + "\nCurso: " + curso + "\nCarga horaria: " + carga_h + "\nDescrição do curso: " + curso_desc + "\nStatus: " + status + "\nProfessor: " + professor
                + "\nID da sala: " + sala_cod + "\nNome da sala: " + sala_nome + "\nLocal da sala: "
                + sala_local + "\nCapacidade da sala: " + capacidade + "\nAlunos: \n" + cac.listagem(this) + "\n\n";
    }

}
