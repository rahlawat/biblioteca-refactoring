package main;

public class Movie {
    private String movieTitle;
    private String movieDirector;
    private String movieRanking;

    public Movie(String movieTitle, String movieDirector, String movieRanking) {
        this.movieTitle=movieTitle;
        this.movieDirector = movieDirector;
        this.movieRanking =  movieRanking;
    }


    @Override
    public String toString() {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}