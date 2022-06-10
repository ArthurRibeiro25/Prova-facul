package DAO;

import BD.Conexao;
import classes.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {
    
    Connection conn = Conexao.getConnection();
    
    public void inserirCurso(Curso curso) {

        String sql = "INSERT INTO curso(curso, carga_h, curso_desc) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            stmt.setString(2, "" + curso.getCarga_h());
            stmt.setString(3, curso.getCurso_desc());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex); 
            System.out.println("teste");
        }
    }

    public ArrayList<Curso> listarCursos() {

        String sql = "SELECT * FROM curso";
        ArrayList<Curso> curso = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso cr = new Curso();
                cr.setCurso_cod(rs.getInt("curso_cod"));
                cr.setCurso(rs.getString("curso"));
                cr.setCarga_h(rs.getDouble("carga_h"));
                cr.setCurso_desc(rs.getString("curso_desc"));

                curso.add(cr);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return curso;
    }

    public void alteraCurso(Curso curso, int id) {
        String sql = "UPDATE curso SET curso=?, carga_h=?, curso_desc=? WHERE curso_cod=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getCurso());
            stmt.setString(2, "" + curso.getCarga_h());
            stmt.setString(3, curso.getCurso_desc());
            stmt.setString(4, "" + id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }    
}
