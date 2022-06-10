package classes;

public class Curso {
    
    private int curso_cod;
    private String curso;
    private Double carga_h;
    private String curso_desc;
    private String professor;
    private String sala;

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

    public String getCurso_desc() {
        return curso_desc;
    }

    public void setCurso_desc(String curso_desc) {
        this.curso_desc = curso_desc;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Curso:\n\n" + "ID do curso: " + curso_cod + "\nCurso: " + curso + "\nCarga horaria: " + carga_h + "\nDescrição do curso: " + curso_desc + "\nProfessor: " + professor + "\nSala: " + sala;
    }

    
    
}