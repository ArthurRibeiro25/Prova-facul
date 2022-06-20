package prova;

import Controller.ControllerAluno;
import Controller.ControllerCurso;
import Controller.ControllerProfessor;
import Controller.ControllerSala;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Prova {

    public static void main(String[] args) {

        int op;

        ControllerCurso cc = new ControllerCurso();
        ControllerSala cs = new ControllerSala();
        ControllerAluno ca = new ControllerAluno();
        ControllerProfessor cp = new ControllerProfessor();
        Scanner input = new Scanner(System.in);

        do {

            op = Integer.parseInt(JOptionPane.showInputDialog("MENU: \n1- Manipular Professores\n2- Manipular Alunos\n3- Manipular Salas"
                    + "\n4- Manipular Cursos\n0- Termina programa\n\nOpção:"));

            switch (op) {
                case 1:
                    cp.menuProfessor();
                    break;
                case 2:
                    ca.menuAluno();
                    break;
                case 3:
                    cs.menuSala();
                    break;
                case 4:
                    cc.menuCurso();
                    break;
                case 0:

                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
    }

}
