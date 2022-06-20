package Controller;

/**
 * Essa classe é responsável por todas funções relacionadas aos alunos matriculados nos cursos
 */


import DAO.AlunoCursoDAO;
import DAO.AlunoDAO;
import DAO.CursoDAO;
import DAO.SalaDAO;
import classes.Aluno;
import classes.Curso;
import classes.Sala;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerAlunoCurso {

    SalaDAO sdao = new SalaDAO();
    AlunoCursoDAO acdao = new AlunoCursoDAO();
    AlunoDAO adao = new AlunoDAO();
    CursoDAO cdao = new CursoDAO();
    ControllerCurso cc = new ControllerCurso();

    public void matriculaAlunoCurso() {

        /**
         * Lista os alunos e os cursos e insere sua matricula no curso desejado (Matricula o aluno no curso)
         */
        
        Aluno aluno = new Aluno();
        Curso curso = new Curso();
        Sala sala = new Sala();
        int idaluno;
        int idcurso;
        int limite;

        ArrayList<Aluno> alu = adao.listarAlunos();
        String listagem = "";
        for (Aluno a : alu) {
            listagem += a.toString();
        }

        idaluno = Integer.parseInt(JOptionPane.showInputDialog(listagem + "\n\nDigite a matricula do aluno: "));
        idcurso = Integer.parseInt(JOptionPane.showInputDialog(cc.retornaListagem() + "\n\nDigite o id do curso que deseja matricular o aluno: "));

        aluno = adao.searchIndex(idaluno);
        curso = cdao.seartchIndex(idcurso);
        sala = sdao.searchIndex(curso.getSala_cod());
        curso.setCapacidade(sala.getCapacidade());
        limite = acdao.salaLimite(idcurso);
        
        //Verfica o tamanho da sala para ver se ainda é possível cadastrar alguém no curso
        if(curso.getCapacidade() > limite){
            acdao.matriculaAlunoCurso(aluno, curso);
        }else{
            JOptionPane.showMessageDialog(null, "Sala lotada!");
        }

    }

    public String listagem(Curso curso) { //retorna uma String com a lista de alunos
        ArrayList<Aluno> al = acdao.listarAlunoCurso(curso);
        String listagem = "";
        for (Aluno a : al) {
            listagem += a.getNome() + " - ";

        }
        return listagem;
    }
}
