public class MovieDataBank {

    private static MovieDataBank instance;
    private static Movie[] movies = new Movie[100];
    private Actor[] actors = new Actor[100];
    private FilmStudio[] filmstudios = new FilmStudio[100];

    private MovieDataBank() {
    }

    public static MovieDataBank getMovieDataBank() {
        if (MovieDataBank.instance == null) {
            MovieDataBank.instance = new MovieDataBank();
        }
        return MovieDataBank.instance;
    }


    public static void setNewMovieInList(int i) {
       movies[i] = new Movie(movies[i].getTitle(), movies[i].getRunTime(), movies[i].getReleaseDayOfMonth(), movies[i].getReleaseMonth(), movies[i].getReleaseYear(), movies[i].getGenre());
    }

    public static void printMoviesInList(){
        for (int i = 0; i <= 100; i++){
            System.out.println(movies[i]);
        }
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public void setFilmstudios(FilmStudio[] filmstudios) {
        this.filmstudios = filmstudios;
    }
}


//    private Movie[] movies = new Movie[100];
//    private Actor[] actors = new Actor[100];
//    private  FilmStudio[] filmstudios = new FilmStudio[100];
//
//    public MovieDataBank(Movie[] movies, Actor[] actors, FilmStudio[] filmstudios) {
//        this.movies = movies;
//        this.actors = actors;
//        this.filmstudios = filmstudios;
//    }
//
//    public Movie[] getMovies() {
//        return movies;
//    }
//
//    public Actor[] getActors() {
//        return actors;
//    }
//
//    public FilmStudio[] getFilmstudios() {
//        return filmstudios;
//    }
//
//    public void setMovies(Movie[] movies) {
//        this.movies = movies;
//    }
//
//    public void setActors(Actor[] actors) {
//        this.actors = actors;
//    }
//
//    public void setFilmstudios(FilmStudio[] filmstudios) {
//        this.filmstudios = filmstudios;
//    }

