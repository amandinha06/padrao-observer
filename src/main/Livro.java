package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Livro implements Observer {

    private String titulo;
    private String ultimaNotificacao;

    public Livro(String titulo) {this.titulo = titulo;}

    public String getUltimaNotificacao(){return this.ultimaNotificacao;}

    public void cadastrar(Cadastro cadastro) {
        cadastro.addObserver(this);
    }

    public void update(Observable cadastro, Object arg1){
        this.ultimaNotificacao = this.titulo + " = valor cadastrado na loja: " + cadastro.toString();
    }
}
