

public class Movie {
//    movieCount is counting how many objects of the class movie have been initialized.
//    movieId gives every Object its own Id depending on movieCount.
    private static int movieCount = 0;
    private int movieId = movieCount;
    private String title;
    private double runTime;
    private Date releaseDate;
    private Genre genre;
    private Actor[] starringActors;
    private String starring = "";




    public Movie(String title, double runTime, Date releaseDate,Genre genre){
        this(title,runTime,releaseDate,genre,null);
    }

    public Movie(String title, double runTime, Date releaseDate, Genre genre, Actor[] starringActors) {
        this.title = title;
        this.runTime = runTime;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.starringActors = starringActors;
        movieCount += 1;
    }


    public String toString() {
//      Take all the elements of the starringActors array and put them into one single String. The individual names are seperated by a comma and a space.
        for (int i = 0; i < starringActors.length; i++) {
            starring += starringActors[i].getName();
            if (i < starringActors.length) {
                starring += ", ";
            }
        }
//        Return a string containing the title, the run time, the release date, the genre and Starring actors.
//        the different attributes are divided by a comma.
//        The string for release date is created by the toString method of Date.
        return "Title: " + this.title + ", " + "Run Time: " + this.runTime + ", " + "Release Date: " + releaseDate.toString() + ", " + "Genre: " + genre + ", " + "Starring: " + starring;
    }

    //    Getters are needed to get all variable values of an object since they are private. The static int movieCount
    //    is missing because it is a class variable and therefor not specific for an instance.
    public String getTitle() {
        return title;
    }

    public double getRunTime() {
        return runTime;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public Actor[] getStarringActors() {
        return starringActors;
    }

    public String getStarring() {
        return starring;
    }


    // Setters are needed to change values of a certain object.
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setStarringActors(Actor[] starringActors) {
        this.starringActors = starringActors;
    }


}
