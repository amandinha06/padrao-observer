package padroescomportamentais.observer;

import java.util.Observable;

public class Cadastro extends Observable {

    private Integer loja;
    private Integer data;

    public Cadastro(Integer loja, Integer data){
        this.loja = loja;
        this.data = data;
    }

    public void definirPreco(){
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        return "Cadastro{" + "loja = " + loja + ",data = " + data + "}";
    }
}
