package kz.sking.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static kz.sking.retrofit.UnsafeOkHttpClient.getUnsafeOkHttpClient;

// АДАПТЕР ЧТЕНИЯ С САЙТА ЧЕРЕЗ ТЕХНОЛОГИЮ RETROFIT 2
class RestAdapter {

    private static final String URL = "https://api.github.com";
    private static final String API = "/users/skingtop/followers";

    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface;

    // Наш интерфес передачи параметров сайту
    interface ApiInterface {
        @GET(API)
        Call<List<DataModel>> getData(@Query("pretty") String param);
    }

    static ApiInterface getApiClient() {
        if (apiInterface == null) {
            try {
                retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .client(getUnsafeOkHttpClient().build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

            } catch (Exception ignore) {
            }
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }

}