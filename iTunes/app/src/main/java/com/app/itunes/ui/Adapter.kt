package com.app.itunes.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app.itunes.R
import com.app.itunes.databinding.SongItemBinding
import com.bumptech.glide.Glide

class Adapter(
    var context: Context,
    var songs: List<SongViewModel>
) : RecyclerView.Adapter<Adapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        var songItemBinding = SongItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return SongViewHolder(songItemBinding, context)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    override fun getItemCount(): Int {
        return songs.size
    }


    class SongViewHolder(
        private var songItemBinding: SongItemBinding,
        var context: Context
    ) :
        RecyclerView.ViewHolder(songItemBinding.root) {

        var image: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(songViewModel: SongViewModel) {
            Glide.with(context).load(songViewModel.url).into(image)
            this.songItemBinding.songItem = songViewModel
        }

        fun getSongItemBinding(): SongItemBinding {
            return songItemBinding
        }
    }


}