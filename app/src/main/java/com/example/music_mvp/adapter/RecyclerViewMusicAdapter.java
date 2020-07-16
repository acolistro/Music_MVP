package com.example.music_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_mvp.R;
import com.example.music_mvp.model.Track;

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
        Track track = trackList.get(position); //ech track inside of the list
        holder.artistName.setText(track.getArtistName());
        holder.trackName.setText(track.getTrackName());
        holder.albumName.setText(track.getCollectionName());

    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView artistName;
        public TextView trackName;
        public TextView albumName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistName.findViewById(R.id.artistName);
            trackName.findViewById(R.id.trackName);
            albumName.findViewById(R.id.albumName);

        }
    }
}
