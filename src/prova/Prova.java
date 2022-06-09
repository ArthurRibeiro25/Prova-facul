package prova;

import Controller.ControllerAluno;
import Controller.ControllerProfessor;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Prova {

    public static void main(String[] args) {
        
        int op;
        
        ControllerAluno ca = new ControllerAluno();
        ControllerProfessor cp = new ControllerProfessor();
        Scanner input = new Scanner(System.in);
        
        do{
        
        op = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n1- Manipular Professores\n2- Manipular Alunos\n3- Manipular Salas"
                + "\n4- Manipular Cursos")); 
        
        switch(op){
            case 1:
                    cp.menuProfessor();
                break;
            case 2:
                    ca.menuAluno();
                break;
            case 3:
                    
                break;
            case 4:
                    
                break;
            case 0:
                
                break;
                
            default:
                System.out.println("Opção inválida!");
                break;
        }
        }while(op != 0);
    }
    
}
