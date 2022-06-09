package classes;

public class Curso {
    
    private int curso_cod;
    private String curso;
    private Double carga_h;
    private String aluno_desc;
    private Professor professor;
    private Sala sala;

    public Curso(){
        
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

    public Double getCarga_h() {
        return carga_h;
    }

    public void setCarga_h(Double carga_h) {
        this.carga_h = carga_h;
    }

    public String getAluno_desc() {
        return aluno_desc;
    }

    public void setAluno_desc(String aluno_desc) {
        this.aluno_desc = aluno_desc;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
}