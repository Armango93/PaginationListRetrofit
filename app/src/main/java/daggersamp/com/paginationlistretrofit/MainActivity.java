package daggersamp.com.paginationlistretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import daggersamp.com.paginationlistretrofit.adapter.MyRecyclerAdapter;
import daggersamp.com.paginationlistretrofit.model.Example;
import daggersamp.com.paginationlistretrofit.retrofit.RetrofitApi;
import daggersamp.com.paginationlistretrofit.retrofit.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Example> listExample = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitApi service = RetrofitFactory.getClient().create(RetrofitApi.class);
        recyclerView = findViewById(R.id.recyclerView);


        Call<List<Example>> call = service.get10Units(1);
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                generateList(response.body());

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    private void generateList(List<Example> list){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(new MyRecyclerAdapter(this, list));
        recyclerView.setLayoutManager(layoutManager);
    }
}
