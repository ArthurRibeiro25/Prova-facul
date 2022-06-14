package Controller;

import DAO.SalaDAO;
import classes.Sala;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerSala {

    private SalaDAO sdao = new SalaDAO();
    private ArrayList<Sala> sala = new ArrayList<>();

    public void menuSala() {

        int option;

        option = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n1- Cadastrar Sala\n2- Listar Salas\n3- Alterar Salas"));

        switch (option) {
            case 1:
                cadastraSala();
                break;
            case 2:
                ArrayList<Sala> sal = sdao.listarSala();
                String listagem = "";
                for (Sala s : sal) {
                    listagem += s.toString();
                }
                JOptionPane.showMessageDialog(null, listagem);
                break;
            case 3:
                altera();
                break;
        }
    }

    public void cadastraSala() {

        Sala s = new Sala();

        s.setNome(JOptionPane.showInputDialog("Digite o nome da sala: "));
        s.setLocal(JOptionPane.showInputDialog("Digite o local da sala: "));
        s.setCapacidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade da sala: ")));

        sdao.inserirSala(s);
    }

    public void altera() {

        Sala sala = new Sala();
        int id;

        ArrayList<Sala> sa = sdao.listarSala();
        String listagem = "";
        for (Sala s : sa) {
            listagem += s.toString();
        }

        id = Integer.parseInt(JOptionPane.showInputDialog(null, listagem + "\n\nID da sala que deseja alterar: "));
        Sala s = sdao.searchIndex(id);

        sala.setNome(JOptionPane.showInputDialog("Digite o nome: ",s.getNome()));
        sala.setLocal(JOptionPane.showInputDialog("Digite o CPF: ", s.getLocal()));
        sala.setCapacidade(Integer.parseInt(JOptionPane.showInputDialog("Digite o endereco: ", s.getCapacidade())));

        sdao.alteraProfessor(sala, id);
    }

}
