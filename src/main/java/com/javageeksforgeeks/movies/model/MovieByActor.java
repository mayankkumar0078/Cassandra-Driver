package com.javageeksforgeeks.movies.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

@Table(name = "movies_by_actor")
public class MovieByActor {

    @PartitionKey
    @Column(name = "actor")
    private String actor;


    @Column(name ="title")
    private String title;

    @ClusteringColumn(1)
    @Column(name = "movie_id")
    private UUID movieId;

    @ClusteringColumn(0)
    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name="rating")
    private Float rating;

    public MovieByActor(String actor, String title, UUID movieId, Integer releaseYear, Float rating) {
        this.actor = actor;
        this.title = title;
        this.movieId = movieId;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getActor() {
        return actor;
    }

    public String getTitle() {
        return title;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Float getRating() {
        return rating;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMovieId(UUID movieId) {
        this.movieId = movieId;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieByActor{" +
                "actor='" + actor + '\'' +
                ", title='" + title + '\'' +
                ", movieId=" + movieId +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }

    public MovieByActor() {
    }
}
