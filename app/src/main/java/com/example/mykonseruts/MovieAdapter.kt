package com.example.mykonseruts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val context: Context, private val movieList: ArrayList<Movie>, val listener: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,
            parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.imageView.setImageResource(currentItem.imageMovie)
        holder.titleMovie.text = (currentItem.titleMovie)
        holder.descMovie.text = (currentItem.descMovie)
        holder.bindView(movieList[position], listener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageView : ImageView = itemView.findViewById(R.id.iv_img)
        val titleMovie : TextView = itemView.findViewById(R.id.tv_title)
        val descMovie : TextView = itemView.findViewById(R.id.tv_desc)

        fun bindView(movie: Movie, listener: (Movie) -> Unit){
            imageView.setImageResource(movie.imageMovie)
            titleMovie.text = movie.titleMovie
            descMovie.text = movie.descMovie
            itemView.setOnClickListener{
                listener(movie)
            }
        }
    }
}