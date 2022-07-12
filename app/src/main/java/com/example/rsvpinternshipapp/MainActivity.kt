package com.example.rsvpinternshipapp

import android.animation.AnimatorSet
import android.animation.LayoutTransition
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rsvpinternshipapp.adapters.CastCrewRVAdapter
import com.example.rsvpinternshipapp.adapters.CategoryOfMovieRVAdapter
import com.example.rsvpinternshipapp.adapters.MovieTrailerRVAdapter
import com.example.rsvpinternshipapp.adapters.SimilarMoviesRVAdapter
import com.example.rsvpinternshipapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupRecyclerViewForMovieTrailer()
        setupRecyclerViewForCategoryOfMovie()
        setupRecyclerViewForCastCrewMembers()
        setupRecyclerViewForSimilarMovies()
        binding.tvReadMore.setOnClickListener {
            if (binding.tvReadMore.text.equals("Read Less")) {
                binding.tvReadMore.text = "Read More"
                slideUpDownView(
                    binding.castCrewLayout.root,
                    binding.castCrewLayout.root.layoutParams.height,
                    1
                )
            } else {
                binding.tvReadMore.text = "Read Less"
                slideUpDownView(
                    binding.castCrewLayout.root,
                    binding.castCrewLayout.root.layoutParams.height,
                    850
                )
            }
        }

    }

    private fun slideUpDownView(view: View, currentHeight: Int, newHeight: Int) {
        val slideAnimator = ValueAnimator
            .ofInt(currentHeight, newHeight)
            .setDuration(200)
        slideAnimator.addUpdateListener {
            view.layoutParams.height = it.animatedValue as Int
            view.requestLayout()
        }
        val animationSet = AnimatorSet();
        animationSet.interpolator = AccelerateDecelerateInterpolator()
        animationSet.play(slideAnimator)
        animationSet.start()
    }

    private fun setupRecyclerViewForSimilarMovies() {
        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        binding.similarMoviesLayout.recyclerViewSimilarMovies.layoutManager = layoutManager
        val adapter =SimilarMoviesRVAdapter()
        binding.similarMoviesLayout.recyclerViewSimilarMovies.adapter = adapter
    }

    private fun setupRecyclerViewForCastCrewMembers() {
        val layoutManager1 = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager2 = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        binding.castCrewLayout.recyclerViewCastMembers.layoutManager = layoutManager1
        binding.castCrewLayout.recyclerViewCrewMembers.layoutManager = layoutManager2
        val adapterCast =CastCrewRVAdapter(true)
        val adapterCrew =CastCrewRVAdapter(false)
        binding.castCrewLayout.recyclerViewCastMembers.adapter = adapterCast
        binding.castCrewLayout.recyclerViewCrewMembers.adapter = adapterCrew
    }

    private fun setupRecyclerViewForCategoryOfMovie() {
        val layoutManager =
            GridLayoutManager(baseContext, 2) // this 2 is basically number of columns u want
        binding.postTopImageLayout.recyclerViewCategoryOfMovie.layoutManager = layoutManager
        val adapter = CategoryOfMovieRVAdapter()
        binding.postTopImageLayout.recyclerViewCategoryOfMovie.adapter = adapter
    }

    private fun setupRecyclerViewForMovieTrailer() {
        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewMovieTrailers.layoutManager = layoutManager
        val adapter =MovieTrailerRVAdapter()
        binding.recyclerViewMovieTrailers.adapter = adapter
    }

}
