package coinmarket.cryptoarbitragetracking.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import coinmarket.cryptoarbitragetracking.R;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {
    Context context;

    public FavoriteAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.item_allcoin, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder rholder, int position) {
        final MyViewHolder holder = (MyViewHolder) rholder;

        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgFavorite.setImageResource(R.drawable.favyellow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 2;
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
