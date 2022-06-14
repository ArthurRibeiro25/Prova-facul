package Controller;

import DAO.CursoDAO;
import DAO.ProfessorDAO;
import DAO.SalaDAO;
import classes.Curso;
import classes.Professor;
import classes.Sala;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerCurso {

    private SalaDAO sd = new SalaDAO();
    private ProfessorDAO pd = new ProfessorDAO();
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
                JOptionPane.showMessageDialog(null, retornaListagem());
                break;
            case 3:
                alterar();
                break;

        }
    }

    public void cadastraCurso() {

        ArrayList<Sala> s = sd.listarSala();
        ArrayList<Professor> p = pd.listarProfessoresIDNome();
        Curso c = new Curso();

        c.setCurso(JOptionPane.showInputDialog("Digite o nome do curso: "));
        c.setCarga_h(Double.parseDouble(JOptionPane.showInputDialog("Digite a carga horaria do curso: ")));
        c.setCurso_desc(JOptionPane.showInputDialog("Digite a descrição: "));
        c.setStatus("Ativo"); //ativo por padrão
        String listagem = "";
        for (Professor pf : p) {
            listagem += pf.listaIDnome();
        }
        c.setFunc_cod(Integer.parseInt(JOptionPane.showInputDialog(listagem + "\n\nDigite o codigo do professor que deseja designar para este curso: ")));

        String listasala = "";
        for (Sala sl : s) {
            listasala += sd.listarSala();
        }
        c.setSala_cod(Integer.parseInt(JOptionPane.showInputDialog(listasala + "\n\nDigite o ID da sala que deseja designar para este curso: ")));

        cdao.inserirCurso(c);

    }

    public void listarCurso() {

        for (Curso a : curso) {
            JOptionPane.showMessageDialog(null, a.toString());
        }
    }

    public void alterar() {

        ArrayList<Sala> s = sd.listarSala();
        ArrayList<Professor> p = pd.listarProfessoresIDNome();
        Curso curso = new Curso();
        int id;
        int result;
        ArrayList<Curso> cso = cdao.listarCursos();
        String listagem = "";
        for (Curso c : cso) {
            listagem += c.toString();
        }

        id = Integer.parseInt(JOptionPane.showInputDialog(listagem + "\nDigite o id curso que deseja alterar: "));
        Curso c = cdao.seartchIndex(id);

        curso.setCurso(JOptionPane.showInputDialog("Digite o nome: ", c.getCurso()));
        curso.setCarga_h(Double.parseDouble(JOptionPane.showInputDialog("Digite a caraga horaria: ", c.getCarga_h())));
        curso.setCurso_desc(JOptionPane.showInputDialog("Digite o endereco: ", c.getCurso_desc()));
        result = JOptionPane.showConfirmDialog(null, "Este curso está ativo? ", "Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            curso.setStatus("Ativo");
        }
        if (result == JOptionPane.NO_OPTION) {
            curso.setStatus("Inativo");
        }
        String listagem2 = "";
        for (Professor pf : p) {
            listagem2 += pf.listaIDnome();
        }
        curso.setFunc_cod(Integer.parseInt(JOptionPane.showInputDialog(listagem2 + "\n\nDigite o codigo do professor que deseja designar para este curso: ", c.getFunc_cod())));
        String listagem3 = "";
        for (Sala sl : s) {
            listagem3 += sl.toString();
        }
        curso.setSala_cod(Integer.parseInt(JOptionPane.showInputDialog(listagem3 + "\n\nDigite o ID da sala que deseja designar para este curso: ", c.getSala_cod())));

        cdao.alteraCurso(curso, id);
    }

    public String retornaListagem() {
        ArrayList<Curso> curs = cdao.listarCursos();
        String listagem = "";
        for (Curso a : curs) {
            listagem += a.toString();
        }
        return listagem;
    }

}
