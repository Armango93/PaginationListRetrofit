package daggersamp.com.paginationlistretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import daggersamp.com.paginationlistretrofit.R;
import daggersamp.com.paginationlistretrofit.model.Example;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    Context context;
    List<Example> list;

    public MyRecyclerAdapter(Context context, List<Example> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder viewHolder, int i) {
        Example example = list.get(i);
        viewHolder.textView_title.setText(example.getTitle());
        viewHolder.textView_body.setText(example.getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView_title;
        final TextView textView_body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_title = itemView.findViewById(R.id.textView);
            textView_body = itemView.findViewById(R.id.textView2);
        }
    }
}
