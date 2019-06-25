public class Movie  {

    private static int movieId = 1;

    private String title;
    private int runTime;
    private int releaseDayOfMonth;
    private int releaseMonth;
    private int releaseYear;
    private String genre;


    public Movie(String title, int runTime, int releaseDayOfMonth, int releaseMonth, int releaseYear, String genre) {
        this.title = title;
        this.runTime = runTime;
        this.releaseDayOfMonth = releaseDayOfMonth;
        this.releaseMonth = releaseMonth;
        this.releaseYear = releaseYear;
        this.genre = genre;
        movieId += 1;
        MovieDataBank.setNewMovieInList(movieId);


    }



    public static int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getRunTime() {
        return runTime;
    }

    public int getReleaseDayOfMonth() {
        return releaseDayOfMonth;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }
}



//movieId += 1;
//        MovieDataBank.setMovies[movieId];