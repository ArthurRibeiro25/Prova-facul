package Controller;

import DAO.AlunoCursoDAO;
import DAO.AlunoDAO;
import DAO.CursoDAO;
import classes.Aluno;
import classes.Curso;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerAlunoCurso {
    
        AlunoCursoDAO acdao = new AlunoCursoDAO();
        AlunoDAO adao = new AlunoDAO();
        CursoDAO cdao = new CursoDAO();
        ControllerCurso cc = new ControllerCurso();
    
        public void matriculaAlunoCurso() {

        Aluno aluno = new Aluno();
        Curso curso = new Curso();

        int idaluno;
        int idcurso;

        ArrayList<Aluno> alu = adao.listarAlunos();
        String listagem = "";
        for (Aluno a : alu) {
            listagem += a.toString();
        }

        idaluno = Integer.parseInt(JOptionPane.showInputDialog(listagem, "\n\nDigite a matricula do aluno: "));
        idcurso = Integer.parseInt(JOptionPane.showInputDialog(cc.retornaListagem(), "\n\nDigite o id do curso que deseja matricular o aluno: "));
        
        aluno = adao.searchIndex(idaluno);
        curso = cdao.seartchIndex(idcurso);
        
        
        acdao.matriculaAlunoCurso(aluno, curso);
    }
}
