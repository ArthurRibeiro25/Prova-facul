package DAO;

//Recebe as informações do ControllerProfessor e insere no banco de dados

import BD.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import classes.Professor;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ProfessorDAO {

    Connection conn = Conexao.getConnection(); // estabelece conexão com o banco

    public void inserirProfessor(Professor professor) { //insere as informações vindas do ControllerProfessor no banco de dados

        String sql = "INSERT INTO professor(nome, cpf, endereco, email, celular) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, "" + professor.getCpf());
            stmt.setString(3, professor.getEndereco());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.getCelular() + "");
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Professor> listarProfessores() { //retorna um arraylist com todos os professores cadastrados no banco de dados

        String sql = "SELECT * FROM professor";
        ArrayList<Professor> professor = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Professor pf = new Professor();
                pf.setFunc_cod(rs.getInt("func_cod"));
                pf.setNome(rs.getString("nome"));
                pf.setCpf(rs.getLong("cpf"));
                pf.setEndereco(rs.getString("endereco"));
                pf.setEmail(rs.getString("email"));
                pf.setCelular(rs.getInt("celular"));

                professor.add(pf);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return professor;
    }

    public Professor searchIndex(int id) { //retorna todas informações presentes no codigo de funcionário enviado

        String sql = "SELECT * FROM professor WHERE func_cod=?";
        Professor pf = new Professor();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                pf.setFunc_cod(rs.getInt("func_cod"));
                pf.setNome(rs.getString("nome"));
                pf.setCpf(rs.getLong("cpf"));
                pf.setEndereco(rs.getString("endereco"));
                pf.setEmail(rs.getString("email"));
                pf.setCelular(rs.getInt("celular"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return pf;
    }

    public ArrayList<Professor> listarProfessoresIDNome() { //lista apenas o codigo de funcionário e o nome do professor 

        String sql = "SELECT professor.func_cod, professor.nome FROM professor";
        ArrayList<Professor> p = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Professor pf = new Professor();
                pf.setFunc_cod(rs.getInt("func_cod"));
                pf.setNome(rs.getString("nome"));

                p.add(pf);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return p;
    }

    public void alteraProfessor(Professor professor, int id) { //recebe as alterações feitas no professor cadastrado
        String sql = "UPDATE professor SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE func_cod=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, "" + professor.getCpf());
            stmt.setString(3, professor.getEndereco());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, "" + professor.getCelular());
            stmt.setString(6, "" + id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
