package com.devmeist3r.movie.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.devmeist3r.movie.data.api.TheMovieDBInterface
import com.devmeist3r.movie.data.repository.MovieDetailsNewtorkDataSource
import com.devmeist3r.movie.data.repository.NetworkState
import com.devmeist3r.movie.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService: TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNewtorkDataSource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNewtorkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}