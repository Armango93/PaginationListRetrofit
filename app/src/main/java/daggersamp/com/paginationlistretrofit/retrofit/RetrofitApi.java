package daggersamp.com.paginationlistretrofit.retrofit;

import java.util.List;

import daggersamp.com.paginationlistretrofit.model.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("posts")
    Call<List<Example>> get10Units(@Query("_page") int pageNumber);
}
