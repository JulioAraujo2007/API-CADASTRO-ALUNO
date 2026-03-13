package br.com.model;

import br.com.controle.Aluno;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroAlunoDAO extends DAO {

    public void inserir(Aluno a) throws Exception {
        abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String existe = "select mat, nome, idade, email FROM alunos where email=?";
        ps = (PreparedStatement) con.prepareStatement(existe);
        ps.setString(1, a.getEmail());
        ResultSet tr = ps.executeQuery();
        if (tr.next()) {
            JOptionPane.showMessageDialog(null, "E-mail ja cadastrado anteriormente!");
        } else {
            String query = "INSERT INTO alunos (mat,nome,idade,email) values(null,?,?,?)";
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());
            ps.setString(3, a.getEmail());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Aluno Inserido com sucesso!");
        }

        fecharBanco();
    }

    public void deletarAluno(Aluno a) throws Exception {
        abrirBanco();
        String query = "delete from alunos where mat=?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setInt(1, a.getMat());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
        fecharBanco();
    }

    public void PesquisarRegistro(Aluno a) throws Exception {
        try {
            abrirBanco();
            String query = "select mat, nome, idade, email FROM alunos where mat=?";
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, a.getMat());
            ResultSet tr = ps.executeQuery();
            if (tr.next()) {
                a.setMat(tr.getInt("mat"));
                a.setNome(tr.getString("nome"));
                a.setIdade(tr.getInt("idade"));
                a.setEmail(tr.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado! ");
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public ArrayList<Aluno> PesquisarTudo() throws Exception {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        try {
            abrirBanco();
            String query = "select mat, nome FROM alunos";
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet tr = ps.executeQuery();
            Aluno a;
            while (tr.next()) {
                a = new Aluno();
                a.setMat(tr.getInt("mat"));
                a.setNome(tr.getString("nome"));
                alunos.add(a);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return alunos;
    }

    public void editarAluno(Aluno a) throws Exception {
        abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE alunos set nome = ?, idade = ?, email = ? where mat = ?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setString(1, a.getNome());
        ps.setInt(2, a.getIdade());
        ps.setString(3, a.getEmail());
        ps.setInt(4, a.getMat());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Aluno Alterado com sucesso!");
        fecharBanco();
    }

}
