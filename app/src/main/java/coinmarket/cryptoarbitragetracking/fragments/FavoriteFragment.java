package coinmarket.cryptoarbitragetracking.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import coinmarket.cryptoarbitragetracking.R;
import coinmarket.cryptoarbitragetracking.adapters.AllCoinAdapter;
import coinmarket.cryptoarbitragetracking.adapters.FavoriteAdapter;

public class FavoriteFragment extends Fragment {
    FavoriteAdapter favoriteAdapter;
    ProgressDialog progressDialog;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipelayout)
    SwipeRefreshLayout swipelayout;
    @BindView(R.id.llMarketCap)
    LinearLayout llMarketCap;


    public FavoriteFragment getFragmetnInstance(String data) {
        FavoriteFragment favoriteFragment = new FavoriteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        favoriteFragment.setArguments(bundle);
        return favoriteFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_coins, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    public void init() {

        llMarketCap.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        favoriteAdapter = new FavoriteAdapter(getActivity());
        recyclerView.setAdapter(favoriteAdapter);

    }
}
