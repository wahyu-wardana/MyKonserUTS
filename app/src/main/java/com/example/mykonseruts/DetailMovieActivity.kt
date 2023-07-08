package com.example.mykonseruts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mykonseruts.fragment.ExploreFragment

class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val superhero = intent.getParcelableExtra<Movie>(ExploreFragment.INTENT_PARCELABLE)

        val imageMovie = findViewById<ImageView>(R.id.img_item_photo)
        val titleMovie = findViewById<TextView>(R.id.tv_item_name)
        val descMovie = findViewById<TextView>(R.id.tv_item_description)

        imageMovie.setImageResource(superhero?.imageMovie!!)
        titleMovie.text = superhero.titleMovie
        descMovie.text = superhero.descMovie
    }
}