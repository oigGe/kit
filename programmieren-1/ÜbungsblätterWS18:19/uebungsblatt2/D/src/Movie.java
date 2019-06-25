public class Movie {
    private String title;
    private double runTime;
    private ReleaseDate releaseDate;
    private int day;
    private int month;
    private int year;
    private int idNumber;
    private String genre;
    private Genre newGenre;

    public Movie(String title, double runTime, int day, int month, int year, String genre) {
        this.title = title;
        this.runTime = runTime;
        this.genre = genre;
        this.newGenre = new Genre(this.genre);
        this.day = day;
        this.month = month;
        this.year = year;
        this.releaseDate = new ReleaseDate(this.day,this.month,this.year);
    }
}



