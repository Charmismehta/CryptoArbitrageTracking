package coinmarket.cryptoarbitragetracking.fragments;

import android.content.Context;

import java.io.IOException;

import coinmarket.cryptoarbitragetracking.Utils.Utils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class RetrofitRequest extends OkHttpClient {

        private static String MAIN_URL = "https://api.coinmarketcap.com/v2/";

        public static Retrofit newRequestRetrofit(final Context context) throws IOException {

            OkHttpClient okHttpClient = new Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();

//                        okhttp3.Response response = chain.proceed(original);

//                        if (!response.isSuccessful()) {
//
//                            Debug.e("Failed","Failed");
//
//                            return response;
//                        }

                            Request request = original.newBuilder()
//                                    .header("Authorization", Utils.getPref(context, Utils.TOKEN, ""))
                                    .method(original.method(), original.body())
                                    .build();


                            return chain.proceed(request);
                        }
                    })
                    .build();

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(MAIN_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            return retrofit;
        }

    }
