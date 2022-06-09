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
    
    public void menuProfessor(){
        
        int option;
        
        option = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU: \n\n1- Cadastrar Professor\n2- Listar Professores"));
        
        switch(option){
            case 1:
                cadastraProfessor();
                break;
            case 2:
                ArrayList<Professor> pfs = pdao.listarProfessores();
                String listagem = "";
                for(Professor p : pfs){
                    listagem += p.toString();
                }
                JOptionPane.showMessageDialog(null, listagem);
                
                break;
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
    


}
