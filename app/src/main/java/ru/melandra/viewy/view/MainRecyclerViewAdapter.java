package ru.melandra.viewy.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.melandra.viewy.R;
import ru.melandra.viewy.presenter.MainPresenter;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private AdapterView.OnItemClickListener listener;

    public MainRecyclerViewAdapter(MainPresenter presenter, AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_main_item, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setOnClickListener(v -> holder.listener.onItemClick(null, v, position, 0));
        holder.setImage(R.drawable.ic_sample_image);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        AdapterView.OnItemClickListener listener;

        public ViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            this.listener = listener;
        }

        public void setImage(int image) {
            imageView.setImageResource(image);
        }
    }
}
