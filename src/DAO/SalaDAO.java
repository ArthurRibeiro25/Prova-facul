package DAO;

import BD.Conexao;
import classes.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaDAO {

    Connection conn = Conexao.getConnection();//estabelece conexão com o banco

    public void inserirSala(Sala sala) {//recebe as informações do ControllerSala e cadastra no banco

        String sql = "INSERT INTO sala(nome, local, capacidade) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setString(2, sala.getLocal());
            stmt.setString(3, "" + sala.getCapacidade());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Sala> listarSala() { //coleta todas salas registradas no banco e insere em um arraylist para assim serem listadas

        String sql = "SELECT * FROM sala";
        ArrayList<Sala> sala = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Sala sl = new Sala();
                sl.setId(rs.getInt("id_sala"));
                sl.setNome(rs.getString("nome"));
                sl.setLocal(rs.getString("local"));
                sl.setCapacidade(rs.getInt("capacidade"));

                sala.add(sl);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return sala;
    }

    public Sala searchIndex(int id) { //envia o id da sala e retorna todas as informações da mesma

        String sql = "SELECT * FROM sala WHERE id_sala=?";
        Sala sl = new Sala();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sl.setId(rs.getInt("id_sala"));
                sl.setNome(rs.getString("nome"));
                sl.setLocal(rs.getString("local"));
                sl.setCapacidade(rs.getInt("capacidade"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return sl;
    }

    public void alteraProfessor(Sala sala, int id) { //recebe as atualizações dos dados da sala
        String sql = "UPDATE sala SET nome=?, local=?, capacidade=? WHERE id_sala=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, sala.getNome());
            stmt.setString(2, sala.getLocal());
            stmt.setString(3, "" + sala.getCapacidade());
            stmt.setString(4, "" + id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
