package braian.silva.projetolistadecompras.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import braian.silva.projetolistadecompras.R;
import braian.silva.projetolistadecompras.model.Produto;

public class ProdutoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Produto> produtos;


    public ProdutoAdapter(@NonNull Context context, ArrayList<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(
                R.layout.linha_produto,
                viewGroup,
                false);

        ViewHolder holder = new ViewHolder(v);

        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ViewHolder holder = (ViewHolder) viewHolder;
        Produto p = produtos.get(i);

        holder.tvNome.setText("Nome: "+p.getNome());
        holder.tvPreco.setText("Preço: R$ "+p.getPreco());


        Picasso.get()
                .load(R.mipmap.ic_launcher)
                .into(holder.ivCarrinho);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvNome;
        private final TextView tvPreco;
        private final ImageView ivCarrinho;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.lp_tv_produto);
            tvPreco= itemView.findViewById(R.id.lp_tv_preco);
            ivCarrinho = itemView.findViewById(R.id.lp_iv_carrinho);
        }
    }
}
