package rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 7/17/2019.
 */

public class ApiClient
{
    public static final String BASE_URL = "http://192.168.10.8/eazyhr_api/";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance(Integer connectTimeout,Integer writeTimeout) {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                    .readTimeout(writeTimeout, TimeUnit.SECONDS)
                    .build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)//added
                    .build();
        }
        return retrofit;
    }
}
