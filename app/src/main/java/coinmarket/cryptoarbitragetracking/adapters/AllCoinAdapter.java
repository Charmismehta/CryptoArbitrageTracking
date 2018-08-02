package coinmarket.cryptoarbitragetracking.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coinmarket.cryptoarbitragetracking.R;
import coinmarket.cryptoarbitragetracking.jsonpojo.AllCoinRes;

public class AllCoinAdapter extends RecyclerView.Adapter<AllCoinAdapter.MyViewHolder> {

    Context context;

    public AllCoinAdapter(Context context) {
        this.context = context;
    }

    public void add(Object data){
//        allCoinlist.add(data);
        notifyDataSetChanged();
    }
    public void clear(){
//        allCoinlist.clear();
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.item_allcoin, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder rholder, int position) {
        final MyViewHolder holder = (MyViewHolder) rholder;
//        AllCoinRes.Data recipe = (AllCoinRes.Data) allCoinlist.get(position);
//        holder.tvCoinId.setText(recipe.details.id);
//        holder.tvCoinName.setText(recipe.details.name);
//        holder.tvCoinPrice.setText("Price : $ "+recipe.details.quotes.uSD.price);
//        holder.tvCoinMarketPrice.setText("MarketCap : $ "+recipe.details.quotes.uSD.marketCap);
//        holder.tvDay.setText(String.valueOf(recipe.details.quotes.uSD.percentChange7d));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCoinId)
        TextView tvCoinId;
        @BindView(R.id.imgCoinPic)
        ImageView imgCoinPic;
        @BindView(R.id.tvCoinName)
        TextView tvCoinName;
        @BindView(R.id.tvCoinPrice)
        TextView tvCoinPrice;
        @BindView(R.id.tvCoinMarketPrice)
        TextView tvCoinMarketPrice;
        @BindView(R.id.tvDay)
        TextView tvDay;
        @BindView(R.id.imgFavorite)
        ImageView imgFavorite;


        public MyViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
