package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    @Test
    void deveNotificarUmLivro(){
        Cadastro cadastro = new Cadastro(1, 2026);
        Livro livro = new Livro("Livro 1");
        livro.cadastrar(cadastro);
        cadastro.definirPreco();

        assertEquals("Livro 1 = valor cadastrado na loja: Cadastro{loja = 1,data = 2026}", livro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarLivros(){
        Cadastro cadastro = new Cadastro(1, 2026);
        Livro livro1 = new Livro("Livro 1");
        Livro livro2 = new Livro("Livro 2");
        livro1.cadastrar(cadastro);
        livro2.cadastrar(cadastro);
        cadastro.definirPreco();

        assertEquals("Livro 1 = valor cadastrado na loja: Cadastro{loja = 1,data = 2026}", livro1.getUltimaNotificacao());
        assertEquals("Livro 2 = valor cadastrado na loja: Cadastro{loja = 1,data = 2026}", livro2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLivro(){
        Cadastro cadastro = new Cadastro(1, 2026);
        Livro livro = new Livro("Livro");
        cadastro.definirPreco();

        assertEquals(null, livro.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCadastro1(){
        Cadastro cadastro1 = new Cadastro(1, 2026);
        Cadastro cadastro2 = new Cadastro(2, 2026);
        Livro livro1 = new Livro("Livro 1");
        Livro livro2 = new Livro("Livro 2");
        livro1.cadastrar(cadastro1);
        livro2.cadastrar(cadastro2);
        cadastro2.definirPreco();

        assertEquals("Livro 2 = valor cadastrado na loja: Cadastro{loja = 2,data = 2026}", livro2.getUltimaNotificacao());
        assertEquals(null, livro1.getUltimaNotificacao());
    }
}
