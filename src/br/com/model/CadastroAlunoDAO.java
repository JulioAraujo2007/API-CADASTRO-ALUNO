package br.com.model;

import br.com.controle.Aluno;
import br.com.controle.Professor;
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

    public void inserir(Professor p) throws Exception {
        try {
        abrirBanco();
        String existe =
                "SELECT email FROM PROFESSOR WHERE email=?";

        ps = con.prepareStatement(existe);
        ps.setString(1, p.getEmail());
        ResultSet tr = ps.executeQuery();

        if (tr.next()) {
            JOptionPane.showMessageDialog(null,
                    "E-mail j? cadastrado anteriormente!");

        } else {
            String queryProfessor =
                    "INSERT INTO PROFESSOR " +
                    "(ra, nome, email, materia) " +
                    "VALUES (null, ?, ?, ?)";

            ps = con.prepareStatement(
                    queryProfessor,
                    java.sql.Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getMateria());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int raGerado = 0;
            if (rs.next()) {
                raGerado = rs.getInt(1);
            }
            String queryEndereco =
                    "INSERT INTO ENDERECO " +
                    "(cidade, bairro, numero, rua, ra) " +
                    "VALUES (?, ?, ?, ?, ?)";

            ps = con.prepareStatement(queryEndereco);
            ps.setString(1, p.getCidade());
            ps.setString(2, p.getBairro());
            ps.setInt(3, p.getNumero());
            ps.setString(4, p.getRua());
            ps.setInt(5, raGerado);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Professor inserido com sucesso!");
        }
        fecharBanco();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Erro ao cadastrar: " + e.getMessage());
    }
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

    public void deletarProfessor(Professor p) throws Exception {
        abrirBanco();
        String query = "delete from Professor where ra=?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setInt(1, p.getRa());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Professor deletado com sucesso!");
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

    public void PesquisarRegistro(Professor p) throws Exception {
        try {
        abrirBanco();

        String query = "select ra, nome, email, materia FROM professor where ra=?";

        ps = con.prepareStatement(query);

        System.out.println("RA recebido no DAO: " + p.getRa());

        ps.setInt(1, p.getRa());

        ResultSet tr = ps.executeQuery();

        if (tr.next()) {
            System.out.println("Professor encontrado!");

            p.setRa(tr.getInt("ra"));
            p.setNome(tr.getString("nome"));
            p.setEmail(tr.getString("email"));
            p.setMateria(tr.getString("materia"));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
        }

        fecharBanco();

    } catch (Exception e) {
        System.out.println("Erro " + e.getMessage());
    }
    }

    public ArrayList<Professor> PesquisarTudoProfessor() throws Exception {
        ArrayList<Professor> professores = new ArrayList<Professor>();
        try {
            abrirBanco();
            String query = "select ra, nome FROM Professor";
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet tr = ps.executeQuery();
            Professor p;
            while (tr.next()) {
                p = new Professor();
                p.setRa(tr.getInt("ra"));
                p.setNome(tr.getString("nome"));
                professores.add(p);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return professores;
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

    public void editarProfessor(Professor p) throws Exception {
        abrirBanco();
        String query = "UPDATE Professor set nome = ?, email = ?, materia = ? where ra = ?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getEmail());
        ps.setString(3, p.getMateria());
        ps.setInt(4, p.getRa());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Professor Alterado com sucesso!");
        fecharBanco();
    }

    public ArrayList<Aluno> PesquisarTudo() {
        ArrayList<Aluno> alunos = new ArrayList<>();

    try {

        abrirBanco();

        String query =
                "SELECT mat, nome, idade, email FROM alunos";

        ps = con.prepareStatement(query);

        ResultSet tr = ps.executeQuery();

        while (tr.next()) {

            Aluno a = new Aluno();

            a.setMat(tr.getInt("mat"));
            a.setNome(tr.getString("nome"));
            a.setIdade(tr.getInt("idade"));
            a.setEmail(tr.getString("email"));

            alunos.add(a);
        }

        fecharBanco();

    } catch (Exception e) {

        System.out.println("Erro: " + e.getMessage());
    }

    return alunos;
    }

}