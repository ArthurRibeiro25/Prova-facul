package DAO;

import BD.Conexao;
import classes.Aluno;
import classes.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoCursoDAO {
    
        Connection conn = Conexao.getConnection();
    
        public void matriculaAlunoCurso(Aluno aluno, Curso curso){
        
        String sql = "INSERT INTO alunocurso(matricula, curso_cod) VALUES (?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.setInt(2, curso.getCurso_cod());
            stmt.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
        public void searchIndex(int id){
            
            String sql = "SELECT aluno.nome FROM alunocurso, aluno WHERE alunocurso.curso_cod =?";
            Curso c = new Curso();
            
            try{
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }            
        }
}
