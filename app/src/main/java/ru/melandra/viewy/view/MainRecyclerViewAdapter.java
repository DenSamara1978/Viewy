package ru.melandra.viewy.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.melandra.viewy.R;
import ru.melandra.viewy.model.API.Hit;
import ru.melandra.viewy.presenter.GlideLoader;
import ru.melandra.viewy.presenter.MainPresenter;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private AdapterView.OnItemClickListener listener;
    private MainPresenter presenter;

    public MainRecyclerViewAdapter(MainPresenter presenter, AdapterView.OnItemClickListener listener) {
        this.listener = listener;
        this.presenter = presenter;
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
        GlideLoader.loadImage ( holder.imageView, presenter.getHit ( position ).previewUrl );
    }

    @Override
    public int getItemCount() {
        return presenter.getHitsSize();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        AdapterView.OnItemClickListener listener;

        public ViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            this.listener = listener;
        }
    }
}
