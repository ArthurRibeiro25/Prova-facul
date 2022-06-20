package Controller;

/**
 * Essa classe possui todas as funções de alunos, aonde recebe dados, formata e envia para o DAO
**/
import DAO.AlunoDAO;
import classes.Aluno;
import classes.Curso;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerAluno {

    private ControllerAlunoCurso cac = new ControllerAlunoCurso();
    private ControllerCurso cc = new ControllerCurso();
    private ArrayList<Aluno> aluno = new ArrayList<>();
    private AlunoDAO adao = new AlunoDAO();
    Curso curso = new Curso();

    public void menuAluno() {
        //menu de alunos, possui as funções disponiveis dos mesmos
        int option;

        option = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n\n1- Cadastrar Aluno\n2- Listar Alunos\n3- Altera Aluno\n4 - Matricula Aluno em curso"));

        switch (option) {
            case 1:
                cadastraAluno();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, retornaListagem());

                break;
            case 3:
                alterar();
                break;
            case 4:
                cac.matriculaAlunoCurso();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                break;

        }
    }

    public void cadastraAluno() { //invocada para receber os dados do novo aluno e enviar para o DAO

        Aluno a = new Aluno();

        a.setNome(JOptionPane.showInputDialog("Digite o nome: "));
        a.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF: ")));
        a.setEndereco(JOptionPane.showInputDialog("Digite o endereco: "));
        a.setEmail(JOptionPane.showInputDialog("Digite o email: "));
        a.setCelular(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ")));

        adao.inserirAluno(a);

    }

    public void listarAluno() { //Percorre o array de alunos e printa os mesmos em um painel JOptionPane

        for (Aluno a : aluno) {
            JOptionPane.showMessageDialog(null, a.toString());
        }
    }

    public void alterar() {
/**
 * O programa coleta a matricula do aluno e pesquisa suas informações no banco de dados, assim retorna as antigas informações para
 * serem alteradas pelo usuário
 */
        Aluno alun = new Aluno();
        int id;

        ArrayList<Aluno> alu = adao.listarAlunos();
        String listagem = "";
        for (Aluno a : alu) {
            listagem += a.toString();
        }

        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "\nDigite a matricula do aluno que deseja alterar: "));
        Aluno a = adao.searchIndex(id);

        alun.setNome(JOptionPane.showInputDialog("Digite o nome: ", a.getNome()));
        alun.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF: ", a.getCpf())));
        alun.setEndereco(JOptionPane.showInputDialog("Digite o endereco: ", a.getEndereco()));
        alun.setEmail(JOptionPane.showInputDialog("Digite o email: ", a.getEmail()));
        alun.setCelular(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ", a.getCelular())));

        adao.alteraAluno(alun, id);
    }

    private String retornaListagem() { //Passa todas as informações do arrayList de aluno para uma String, para assim ser listada
        //sem erros

        ArrayList<Aluno> alu = adao.listarAlunos();
        String listagem = "";
        for (Aluno a : alu) {
            listagem += a.toString();
        }

        return listagem;
    }
}
