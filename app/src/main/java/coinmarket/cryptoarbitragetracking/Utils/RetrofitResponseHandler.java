package coinmarket.cryptoarbitragetracking.Utils;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitResponseHandler implements Callback<ResponseBody> {
    private Activity context;

    public RetrofitResponseHandler(Activity context) {
        this.context = context;
    }

    abstract public void onStart();

    abstract public void onSuccess(String content);

    abstract public void onFinish();

    abstract public void onFailure(Throwable e, String content);

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

        Debug.e("Response" , response+"");

        onFinish();

        if (response.isSuccessful()) {

            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(response.body().source().inputStream()));
            String read;

            try {
                while ((read = br.readLine()) != null) {
                    sb.append(read);
                }

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            if (res.St == 506) {
//
//                Utils.clearLoginCredetials(context);
//
//                LocalBroadcastManager.getInstance(context)
//                        .sendBroadcast(
//                                new Intent(Constant.FINISH_ACTIVITY));
//
//                Intent intent = new Intent(context,
//                        LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
//                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                context.startActivity(intent);
//                return;
//            }

            try {
                onSuccess(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            StringBuilder sb = new StringBuilder();
            String read;

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(response.body().source().inputStream()));
                while ((read = br.readLine()) != null) {
                    sb.append(read);
                }

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            onFailure(new Throwable(""), "" + sb.toString());
        }

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        onFailure(t, "");
    }


}
