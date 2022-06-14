package DAO;

import BD.Conexao;
import classes.Aluno;
import classes.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDAO {

    Connection conn = Conexao.getConnection();

    public void inserirAluno(Aluno aluno) {

        String sql = "INSERT INTO aluno(nome, cpf, endereco, email, celular) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, "" + aluno.getCpf());
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCelular() + "");
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    }
    
    public ArrayList<Aluno> listarAlunos() {

        String sql = "SELECT * FROM aluno";
        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno al = new Aluno();
                al.setMatricula(rs.getInt("matricula"));
                al.setNome(rs.getString("nome"));
                al.setCpf(rs.getLong("cpf"));
                al.setEndereco(rs.getString("endereco"));
                al.setEmail(rs.getString("email"));
                al.setCelular(rs.getInt("celular"));

                alunos.add(al);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return alunos;
    }
    
        public Aluno searchIndex(int id) {

        String sql = "SELECT * FROM aluno WHERE matricula=?";
        Aluno a = new Aluno();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getLong("cpf"));
                a.setEndereco(rs.getString("endereco"));
                a.setEmail(rs.getString("email"));
                a.setCelular(rs.getInt("celular"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return a;
    }
    
        public void alteraAluno(Aluno aluno, int id) {
        String sql = "UPDATE aluno SET nome=?, cpf=?, endereco=?, email=?, celular=? WHERE matricula=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, "" + aluno.getCpf());
            stmt.setString(3, aluno.getEndereco());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getCelular() + "");
            stmt.setString(6, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

}
