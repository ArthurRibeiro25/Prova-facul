package Controller;

import DAO.ProfessorDAO;
import classes.Curso;
import classes.Professor;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControllerProfessor {

    private ArrayList<Curso> curso = new ArrayList<>();
    private ArrayList<Professor> professor = new ArrayList<>();
    private ProfessorDAO pdao = new ProfessorDAO();

    public void menuProfessor() {

        int option;

        option = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU: \n\n1- Cadastrar Professor\n2- Listar Professores\n3- Altera Professores"));

        switch (option) {
            case 1:
                cadastraProfessor();
                break;
            case 2:
                ArrayList<Professor> pfs = pdao.listarProfessores();
                String listagem = "";
                for (Professor p : pfs) {
                    listagem += p.toString();
                }
                JOptionPane.showMessageDialog(null, listagem);

                break;
            case 3:
                altera();
        }
    }

    public void cadastraProfessor() {

        Professor p = new Professor();

        p.setNome(JOptionPane.showInputDialog("Digite o nome: "));
        p.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF: ")));
        p.setEndereco(JOptionPane.showInputDialog("Digite o endereco: "));
        p.setEmail(JOptionPane.showInputDialog("Digite o email: "));
        p.setCelular(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ")));

        pdao.inserirProfessor(p);

    }

    public void altera() {

        Professor prof = new Professor();
        int id;

        ArrayList<Professor> pfs = pdao.listarProfessores();
        String listagem = "";
        for (Professor p : pfs) {
            listagem += p.toString();
        }
        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "\nCodigo de funcionario do professor que deseja alterar: "));
        Professor p = pdao.searchIndex(id);
        
        prof.setNome(JOptionPane.showInputDialog("Digite o nome: ", p.getNome()));
        prof.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF: ", p.getCpf())));
        prof.setEndereco(JOptionPane.showInputDialog("Digite o endereco: ", p.getEndereco()));
        prof.setEmail(JOptionPane.showInputDialog("Digite o email: ", p.getEmail()));
        prof.setCelular(Long.parseLong(JOptionPane.showInputDialog("Digite o celular: ", p.getCelular())));

        pdao.alteraProfessor(prof, id);
    }

}
