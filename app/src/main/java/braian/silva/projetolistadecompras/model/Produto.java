package braian.silva.projetolistadecompras.model;

import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

import braian.silva.projetolistadecompras.R;

import static android.content.ContentValues.TAG;

public class Produto {
    private String nome;
    private double preco;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    ArrayList<Produto> produtos;


    @Override
    public String toString() {
        return "\n Nome:" + nome +
                "\n Preço:" + preco;
    }
}
