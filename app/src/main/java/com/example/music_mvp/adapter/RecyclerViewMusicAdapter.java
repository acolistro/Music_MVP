package com.example.music_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_mvp.R;
import com.example.music_mvp.model.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewMusicAdapter extends RecyclerView.Adapter<RecyclerViewMusicAdapter.ViewHolder> {

    private Context context;
    private List<Track> trackList;

    public RecyclerViewMusicAdapter(Context context, List<Track> trackList) {
        this.context = context;
        this.trackList = trackList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Track track = trackList.get(position); //each track inside of the list
        holder.artistName.setText(track.getArtistName());
        holder.trackName.setText(track.getTrackName());
        holder.albumName.setText(track.getCollectionName());
        holder.albumArt.setImageURI(track.getArtworkUrl100());

        Picasso.get()
                .load(track.getArtworkUrl100())
                .resize(50, 50)
                .centerCrop()
                .into(holder.albumArt);
//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView artistName;
        public TextView trackName;
        public TextView albumName;
        public ImageView albumArt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistName = itemView.findViewById(R.id.artistName);
            trackName = itemView.findViewById(R.id.trackName);
            albumName = itemView.findViewById(R.id.albumName);
            albumArt = itemView.findViewById(R.id.albumArt);

        }
    }
}
