package DAO;

/**
 * Essa classe recebe as informações do ControllerCurso e as insere no banco de dados
 */

import BD.Conexao;
import classes.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {

    Connection conn = Conexao.getConnection();

    public void inserirCurso(Curso curso) {//responsável por coletar as informações do ControllerCurso e enviar ao banco de dados

        String sql = "INSERT INTO curso(curso, carga_h, curso_desc, status, func_cod, sala_cod) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            stmt.setString(2, "" + curso.getCarga_h());
            stmt.setString(3, curso.getCurso_desc());
            stmt.setString(4, curso.getStatus());
            stmt.setString(5, "" + curso.getFunc_cod());
            stmt.setString(6, "" + curso.getSala_cod());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Curso> listarCursos() {//Lista todas as informações relacionadas a curso

        String sql = "SELECT curso.curso_cod, curso.curso, curso.carga_h, curso.curso_desc, curso.status, professor.nome, curso.sala_cod, "
                + "sala.nome, sala.local, sala.capacidade FROM curso, professor, sala "
                + "WHERE curso.func_cod = professor.func_cod AND curso.sala_cod = sala.id_sala";
        ArrayList<Curso> curso = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso cr = new Curso();
                cr.setCurso_cod(rs.getInt("curso_cod"));
                cr.setCurso(rs.getString("curso"));
                cr.setCarga_h(rs.getInt("carga_h"));
                cr.setCurso_desc(rs.getString("curso_desc"));
                cr.setStatus(rs.getString("status"));
                cr.setProfessor(rs.getString("professor.nome"));
                cr.setSala_cod(rs.getInt("curso.sala_cod"));
                cr.setSala_nome(rs.getString("sala.nome"));
                cr.setSala_local(rs.getString("sala.local"));
                cr.setCapacidade(rs.getInt("sala.capacidade"));
                curso.add(cr);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return curso;
    }

    public Curso seartchIndex(int id) {//recebe o id de um curso e retorna suas informações

        String sql = "SELECT * FROM curso WHERE curso_cod=?";
        Curso cr = new Curso();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cr.setCurso_cod(rs.getInt("curso_cod"));
                cr.setCurso(rs.getString("curso"));
                cr.setCarga_h(rs.getInt("carga_h"));
                cr.setCurso_desc(rs.getString("curso_desc"));
                cr.setStatus(rs.getString("status"));
                cr.setFunc_cod(rs.getInt("func_cod"));
                cr.setSala_cod(rs.getInt("sala_cod"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return cr;
    }

    public void alteraCurso(Curso curso, int id) { //recebe o id do curso que será alterado e as novas informações
        String sql = "UPDATE curso SET curso=?, carga_h=?, curso_desc=?, status=?, func_cod=?, sala_cod=? WHERE curso_cod=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            stmt.setString(2, "" + curso.getCarga_h());
            stmt.setString(3, curso.getCurso_desc());
            stmt.setString(4, curso.getStatus());
            stmt.setString(5, "" + curso.getFunc_cod());
            stmt.setString(6, "" + curso.getSala_cod());
            stmt.setString(7, "" + id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
