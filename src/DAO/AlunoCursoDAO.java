package DAO;

/**
 * Classe responsável por inserir a matricula dos alunos em um curso no banco de dados
 */

import BD.Conexao;
import classes.Aluno;
import classes.Curso;
import classes.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoCursoDAO {

    AlunoDAO adao = new AlunoDAO();
    Connection conn = Conexao.getConnection();

    public void matriculaAlunoCurso(Aluno aluno, Curso curso) { //insere a matricula do aluno no id do curso no banco de dados

        String sql = "INSERT INTO alunocurso(matricula, curso_cod) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aluno.getMatricula());
            stmt.setInt(2, curso.getCurso_cod());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Aluno> listarAlunoCurso(Curso curso) { //retorna um arraylist com a matricula dos alunos matriculados nos cursos

        ArrayList<Aluno> aluno = new ArrayList<>();
        String sql = "SELECT aluno.matricula FROM alunocurso, aluno WHERE aluno.matricula = alunocurso.matricula AND alunocurso.curso_cod =?";
        Aluno a = new Aluno();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, curso.getCurso_cod());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("matricula");
                a = adao.searchIndex(id2);
                aluno.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return aluno;
    }

    public int salaLimite(int id) {
        /**
         * verifica a quantidade de alunos matriculados no curso x e verifica se a sala atribuida ao mesmo ainda comporta mais
         * alunos. Retorna o numero de alunos matriculados no curso
         */

        int count = 0;
        int cap = 0;
        String sql = "SELECT COUNT(alunocurso.curso_cod) as turma FROM alunocurso WHERE alunocurso.curso_cod =?";
        //String sql = "SELECT COUNT(alunocurso.curso_cod) as turma, sala.capacidade FROM alunocurso, sala, curso WHERE alunocurso.curso_cod = ? AND alunocurso.curso_cod = curso.curso_cod AND curso.sala_cod = sala.id_sala";
        Curso curso = new Curso();
        Sala sala = new Sala();

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("turma");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }
}
