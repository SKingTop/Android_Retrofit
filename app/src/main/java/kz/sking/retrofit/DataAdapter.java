package kz.sking.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

// КЛАСС СОЗДАТЕЛЯ СПИСКА RecyclerView
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<DataModel> dataList;

    DataAdapter(List<DataModel> dataList) {
        this.dataList = dataList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView rate;

        ViewHolder(View itemView) {
            super(itemView);
            // ---- Наши поля ----
            name = itemView.findViewById(R.id.postitem_name);
            rate = itemView.findViewById(R.id.postitem_rate);
            // -------------------
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataModel data = dataList.get(position);
        holder.name.setText("Логин: "+data.getLogin());
        holder.rate.setText("Ссылка: "+data.getHtmlUrl());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

}
