package Controller;

import DAO.AlunoDAO;
import classes.Aluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerAluno {

    private ArrayList<Aluno> aluno = new ArrayList<>();
    private AlunoDAO adao = new AlunoDAO();
    
    
    public void menuAluno() {

        int option;

        option = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n\n1- Cadastrar Aluno\n2- Listar Alunos"));

        switch (option) {
            case 1:
                cadastraAluno();
                break;
            case 2:
                ArrayList<Aluno> alu = adao.listarAlunos();
                String listagem = "";
                for(Aluno a : alu){
                    listagem += a.toString();
                }
                JOptionPane.showMessageDialog(null, listagem);
                
                break;

        }
    }

    public void cadastraAluno() {

        Aluno a = new Aluno();

        a.setNome(JOptionPane.showInputDialog("Digite o nome: "));
        a.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF: ")));
        a.setEndereco(JOptionPane.showInputDialog("Digite o endereco: "));
        a.setEmail(JOptionPane.showInputDialog("Digite o email: "));
        a.setCelular(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ")));
        
        adao.inserirAluno(a);
        
    }

    public void listarAluno() {

        for (Aluno a : aluno) {
            JOptionPane.showMessageDialog(null, a.toString());
        }
    }
}
