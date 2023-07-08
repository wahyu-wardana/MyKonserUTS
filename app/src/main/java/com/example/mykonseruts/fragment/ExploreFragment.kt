package com.example.mykonseruts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mykonseruts.DetailMovieActivity
import com.example.mykonseruts.Movie
import com.example.mykonseruts.MovieAdapter
import com.example.mykonseruts.R

class ExploreFragment : Fragment() {
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.aril,
            R.drawable.wali,
            R.drawable.ginanjar,
            R.drawable.coldplay,
            R.drawable.senja,
            R.drawable.seranjana,
            R.drawable.sambo,
            R.drawable.djsnake,
            R.drawable.virgoun,
            R.drawable.kribo,


            )

        title = arrayOf(
            "Aril",
            "Wali",
            "Ginanjar",
            "Coldplay",
            "Senja",
            "Seranjana",
            "Sambo",
            "DJ snake",
            "Virgoun",
            "Kribo",



            )

        descriptions = arrayOf(
            "300orang",
            "5500orang",
            "100orang",
            "3100orang",
            "200orang",
            "360orang",
            "2300orang",
            "300orang",
            "3400orang",
            "200orang",
        )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }


}