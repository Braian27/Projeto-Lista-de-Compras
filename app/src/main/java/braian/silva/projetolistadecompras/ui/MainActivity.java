package braian.silva.projetolistadecompras.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import braian.silva.projetolistadecompras.Adapter.ProdutoAdapter;
import braian.silva.projetolistadecompras.R;
import braian.silva.projetolistadecompras.model.Produto;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etPreco;
    private Button btADD;
    private TextView tvSoma;
    private RecyclerView rvProdutos;
    private ArrayList<Produto> produtos;
    private ProdutoAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            init();

            btADD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Produto p = new Produto();
                    p.setNome(etNome.getText().toString());
                    p.setPreco(Double.parseDouble(etPreco.getText().toString()));

                    produtos.add(p);
                    adapter.notifyDataSetChanged();
                    toast(produtos+ "adicionado com sucesso!");
                    limpar();
                    tvSoma.setText("Total: " +somarTotal());
                }
            });

        }//end oncreate

        private double somarTotal(){
            double total = 0;
            for (int i =0 ; i<produtos.size() ; i++){
                total = total + produtos.get(i).getPreco();
            }
            return total;
        }

        private void limpar(){
            etNome.setText("");
            etPreco.setText("");
        }

        private void init(){
            etNome = findViewById(R.id.ma_et_nome);
            etPreco = findViewById(R.id.ma_et_preco);
            btADD = findViewById(R.id.ma_bt_add);
            tvSoma = findViewById(R.id.ma_tv_soma);
            rvProdutos = findViewById(R.id.ma_rv_lista);

            produtos = new ArrayList<>();//vazio
            adapter = new ProdutoAdapter(MainActivity.this, produtos);

            rvProdutos.setAdapter(adapter);
            rvProdutos.setHasFixedSize(true);
            rvProdutos.setLayoutManager(new LinearLayoutManager(this));

        }//end init

        private void toast(String msg){
            Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
        }

}//end class
