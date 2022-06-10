package Controller;

import DAO.CursoDAO;
import classes.Curso;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerCurso {
    
    private ArrayList<Curso> curso = new ArrayList<>();
    private CursoDAO cdao = new CursoDAO();

    public void menuCurso() {

        int option;

        option = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n\n1- Cadastrar Curso\n2- Listar Cursos\n3- Altera Curso"));

        switch (option) {
            case 1:
                cadastraCurso();
                break;
            case 2:
                ArrayList<Curso> curs = cdao.listarCursos();
                String listagem = "";
                for (Curso a : curs) {
                    listagem += a.toString();
                }
                JOptionPane.showMessageDialog(null, listagem);

                break;
            case 3:
                alterar();
                break;

        }
    }

    public void cadastraCurso() {

        Curso c = new Curso();

        c.setCurso(JOptionPane.showInputDialog("Digite o nome do curso: "));
        c.setCarga_h(Double.parseDouble(JOptionPane.showInputDialog("Digite a carga horaria do curso: ")));
        c.setCurso_desc(JOptionPane.showInputDialog("Digite a descrição: "));

        cdao.inserirCurso(c);

    }

    public void listarCurso() {

        for (Curso a : curso) {
            JOptionPane.showMessageDialog(null, a.toString());
        }
    }

    public void alterar() {

        Curso curso = new Curso();
        int id;

        ArrayList<Curso> cso = cdao.listarCursos();
        String listagem = "";
        for (Curso c : cso) {
            listagem += c.toString();
        }

        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "\nDigite o id curso que deseja alterar: "));

        curso.setCurso(JOptionPane.showInputDialog("Digite o nome: ", cso.get(id - 1).getCurso()));
        curso.setCarga_h(Double.parseDouble(JOptionPane.showInputDialog("Digite o CPF: ", cso.get(id - 1).getCarga_h())));
        curso.setCurso_desc(JOptionPane.showInputDialog("Digite o endereco: ", cso.get(id - 1).getCurso_desc()));

        cdao.alteraCurso(curso, id);
    }
    
}
