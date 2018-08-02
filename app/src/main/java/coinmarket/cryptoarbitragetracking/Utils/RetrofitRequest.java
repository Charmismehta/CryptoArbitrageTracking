package coinmarket.cryptoarbitragetracking.Utils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest extends OkHttpClient {

    private static String MAIN_URL = "http://develop.ithetasolution.com/api/";

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
                                .header("Authorization",Utils.getPref(context, Utils.TOKEN, ""))
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

//    public static Call newRequestPost(Context context, RequestBody body, String url) {
//
//        Builder builder = new Builder();
//
//        OkHttpClient client = builder.build();
//        Request.Builder request = new Request.Builder()
//                .url(url)
////                .addHeader(RequestParamsUtils.AUTHORIZATION, Utils.getUserToken(context))
//                .post(body);
//        Call call = client.newCall(request.build());
//        return call;
//    }
//
//    public static Call newRequestPut(Context context, RequestBody body, String url) {
//
//        Builder builder = new Builder();
//
//        OkHttpClient client = builder.build();
//        Request.Builder request = new Request.Builder()
//                .url(url)
////                .addHeader(RequestParamsUtils.AUTHORIZATION, Utils.getUserToken(context))
//                .put(body);
//        Call call = client.newCall(request.build());
//        return call;
//    }
//
//    public static Call newRequestGet(Context context, String url) throws IOException {
//        Builder builder = new Builder();
//
//        OkHttpClient client = builder.build();
//        Request.Builder request = new Request.Builder()
////                .addHeader(RequestParamsUtils.AUTHORIZATION, Utils.getUserToken(context))
//                .url(url);
//        Call call = client.newCall(request.build());
//        return call;
//    }

//    public static RetrofitService newRequestPost(Context context, RequestBody body) throws IOException {
//        Builder builder = new Builder();
//
//        OkHttpClient client = builder.build();
//
//        Request.Builder request = new Request.Builder()
//                .post(body)
//                .addHeader(RequestParamsUtils.ACCESS_TOKEN, Utils.getUserToken(context))
//                .addHeader(RequestParamsUtils.CONTENT_TYPE, Constant.APP_JSON);
//
//        RetrofitService retrofit = new Retrofit.Builder()
//                .baseUrl(URLs.MAIN_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build().create(RetrofitService.class);
//
//
////        Call call = client.newCall(request.build());
//        return retrofit;
//    }
//
//    public static RetrofitService newRequestGet(Context context) throws IOException {
//        Builder builder = new Builder();
//
//        OkHttpClient client = builder.build();
//        Request.Builder request = new Request.Builder()
//                .get()
//                .addHeader(RequestParamsUtils.ACCESS_TOKEN, Utils.getUserToken(context))
//                .addHeader(RequestParamsUtils.CONTENT_TYPE, Constant.APP_JSON);
//
//        RetrofitService retrofit = new Retrofit.Builder()
//                .baseUrl(URLs.MAIN_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build().create(RetrofitService.class);
//
//
////        Call call = client.newCall(request.build());
//        return retrofit;
//    }
//
//    public static Retrofit newRequestRetrofit() throws IOException {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URLs.MAIN_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
////        GitHubService service = retrofit.create(GitHubService.class);
//        return retrofit;
//    }



//    public static Retrofit newRequestRetrofit(final Context context, String url) throws IOException {
//
//        OkHttpClient okHttpClient = new Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        Request original = chain.request();
//
////                        okhttp3.Response response = chain.proceed(original);
//
////                        if (!response.isSuccessful()) {
////
////                            Debug.e("Failed","Failed");
////
////                            return response;
////                        }
//
//                        Request request = original.newBuilder()
//                                .header(RequestParamsUtils.ACCESS_TOKEN, Utils.getUserToken(context))
//                                .header(RequestParamsUtils.CONTENT_TYPE, Constant.APP_JSON)
//                                .method(original.method(), original.body())
//                                .build();
//
//
//                        return chain.proceed(request);
//                    }
//                })
//                .build();
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(url)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        return retrofit;
//    }

//    public static Retrofit newRequestRetrofit(OkHttpClient okHttpClient) throws IOException {
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(URLs.MAIN_URL)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        return retrofit;
//    }
//
//    public static OkHttpClient newRequestOkHttpClient(final Context context) throws IOException {
//
//        OkHttpClient okHttpClient = new Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        Request original = chain.request();
//
////                        okhttp3.Response response = chain.proceed(original);
//
////                        if (!response.isSuccessful()) {
////
////                            Debug.e("Failed","Failed");
////
////                            return response;
////                        }
//
//                        Request request = original.newBuilder()
//                                .header(RequestParamsUtils.ACCESS_TOKEN, Utils.getUserToken(context))
//                                .header(RequestParamsUtils.CONTENT_TYPE, Constant.APP_JSON)
//                                .method(original.method(), original.body())
//                                .build();
//
//
//                        return chain.proceed(request);
//                    }
//                })
//                .build();
//
//        return okHttpClient;
//    }


}
