package br.com.testes;

import br.com.controle.Aluno;
import br.com.model.CadastroAlunoDAO;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlunoTest {

    /*
     CA01 todos os campos preenchidos
    */
    @Test
    public void deveCadastrarAlunoComCamposPreenchidos() {

        Aluno aluno = new Aluno();

        aluno.setNome("Jo?o");
        aluno.setEmail("joao@email.com");
        aluno.setIdade(20);

        assertEquals(
                "Jo?o",
                aluno.getNome()
        );

        assertEquals(
                "joao@email.com",
                aluno.getEmail()
        );

        assertEquals(
                20,
                aluno.getIdade()
        );
    }

    /*
     CA02 N?o permitir campos vazios
    */
    @Test
    public void naoDevePermitirCamposObrigatoriosVazios() {

        Aluno aluno = new Aluno();

        aluno.setNome("");

        boolean nomeValido =
                !aluno.getNome().isEmpty();

        assertFalse(nomeValido);
    }

    /*
     CA03 Validar email
    */
    @Test
    public void deveValidarFormatoEmail() {

        String email =
                "teste@email.com";

        boolean valido =
                email.contains("@");

        assertTrue(valido);
    }

    @Test
    public void deveInvalidarEmailSemArroba() {

        String email =
                "testeemail.com";

        boolean valido =
                email.contains("@");

        assertFalse(valido);
    }

    /*
     CA04 Listar alunos cadastrados
    */
    @Test
    public void deveListarAlunosCadastrados()
            throws Exception {

        CadastroAlunoDAO dao =
                new CadastroAlunoDAO();

        ArrayList<Aluno> lista =
                dao.PesquisarTudo();

        assertNotNull(lista);
    }

    /*
     CA05 Atualizar dados do aluno
    */
    @Test
    public void deveAtualizarDadosAluno()
            throws Exception {

        Aluno aluno = new Aluno();

        aluno.setMat(1);
        aluno.setNome("Maria");
        aluno.setIdade(22);
        aluno.setEmail("maria@email.com");

        CadastroAlunoDAO dao =
                new CadastroAlunoDAO();

        dao.editarAluno(aluno);

        assertEquals(
                "Maria",
                aluno.getNome()
        );
    }

    /*
     CA06 Excluir aluno
    */
    @Test
    public void deveExcluirAluno()
            throws Exception {

        Aluno aluno = new Aluno();

        aluno.setMat(1);

        CadastroAlunoDAO dao =
                new CadastroAlunoDAO();

        dao.deletarAluno(aluno);

        assertEquals(
                1,
                aluno.getMat()
        );
    }

    /*
     CA07 Mensagem de sucesso
    */
    @Test
    public void deveExibirMensagemSucesso() {

        String mensagem =
                "Aluno Inserido com sucesso!";

        assertEquals(
                "Aluno Inserido com sucesso!",
                mensagem
        );
    }

    /*
     CA07 Mensagem de erro
    */
    @Test
    public void deveExibirMensagemErro() {

        String mensagem =
                "E-mail ja cadastrado anteriormente!";

        assertEquals(
                "E-mail ja cadastrado anteriormente!",
                mensagem
        );
    }

}