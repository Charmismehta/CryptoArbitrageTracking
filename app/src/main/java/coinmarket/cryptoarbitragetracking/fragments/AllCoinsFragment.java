package coinmarket.cryptoarbitragetracking.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coinmarket.cryptoarbitragetracking.R;
import coinmarket.cryptoarbitragetracking.Utils.Debug;
import coinmarket.cryptoarbitragetracking.Utils.RetrofitResponseHandler;
import coinmarket.cryptoarbitragetracking.adapters.AllCoinAdapter;
import coinmarket.cryptoarbitragetracking.Utils.APIInterface;
import coinmarket.cryptoarbitragetracking.jsonpojo.AllCoinRes;
import retrofit2.Retrofit;

public class AllCoinsFragment extends Fragment {

    AllCoinAdapter allCoinAdapter;
    ProgressDialog progressDialog;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipelayout)
    SwipeRefreshLayout swipelayout;
    AllCoinRes allCoinRes;
    List<Object> allCoinlist = new ArrayList<>();


    public AllCoinsFragment getFragmetnInstance(String data) {
        AllCoinsFragment allCoinsFragment = new AllCoinsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        allCoinsFragment.setArguments(bundle);
        return allCoinsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        String str = getArguments().getString("data");
        View view = inflater.inflate(R.layout.fragment_all_coins, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void init() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        allCoinAdapter = new AllCoinAdapter(getActivity());
        recyclerView.setAdapter(allCoinAdapter);

        getProfileDataList();

    }
    public void getProfileDataList() {

        try {

            if (!swipelayout.isRefreshing()) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setMessage("Please Wait...");
                progressDialog.show();
            }
            Debug.e("getAllCoinData --> ", "");

            Retrofit retrofit = RetrofitRequest.newRequestRetrofit(getActivity());
            APIInterface retrofitService = retrofit.create(APIInterface.class);
            retrofitService.getAllCoinData().enqueue(new getAllCoinData(getActivity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class getAllCoinData extends RetrofitResponseHandler {

        public getAllCoinData(Activity context) {
            super(context);
        }

        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(String content) {
            progressDialog.dismiss();
            swipelayout.setRefreshing(false);

            try {
                Debug.e("getAllCoinData --> ", new JSONObject(content).toString());

                allCoinRes = new Gson().fromJson(new JSONObject(content).toString(), new TypeToken<AllCoinRes>() {
                }.getType());
                allCoinAdapter.clear();
                allCoinlist.clear();
                allCoinlist.add(allCoinRes.data);
                allCoinAdapter.add(allCoinlist);
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFinish() {
//            dismissDialog();
        }

        @Override
        public void onFailure(Throwable e, String content) {
//            dismissDialog();
        }

    }
}