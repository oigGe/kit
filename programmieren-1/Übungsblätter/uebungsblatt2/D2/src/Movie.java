public class Movie {
    private String title;
    private int runTime;
    private int releaseDayOfMonth;
    private int releaseMonth;
    private int releaseYear;
    private String genre;
    private static int movieId = -1;

    public Movie(String title, int runTime, int releaseDayOfMonth, int releaseMonth, int releaseYear, String genre) {
        this.title = title;
        this.runTime = runTime;
        this.releaseDayOfMonth = releaseDayOfMonth;
        this.releaseMonth = releaseMonth;
        this.releaseYear = releaseYear;
        this.genre = genre;
        ReleaseDate releaseDate = new ReleaseDate(this.releaseDayOfMonth,this.releaseMonth,this.releaseYear);
        movieId += 1;
    }


}

