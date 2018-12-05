public class Genre {
    private boolean isAction;
    private boolean isHorror;
    private boolean isScienceFiction;
    private boolean isComedy;
    private boolean isThriller;
    private boolean isWestern;
    private boolean isAdventure;

//
//    public Genre(boolean isAction, boolean isHorror, boolean isScienceFiction, boolean isComedy, boolean isThriller, boolean isWestern, boolean isAdventure) {
//        this.isAction = isAction;
//        this.isHorror = isHorror;
//        this.isScienceFiction = isScienceFiction;
//        this.isComedy = isComedy;
//        this.isThriller = isThriller;
//        this.isWestern = isWestern;
//        this.isAdventure = isAdventure;

    private String genre;

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
        genre.toLowerCase();
    }

    private void whichGenre(String genre) {



        switch (genre) {
            case "action":
                isAction = true;
                break;
            case "horror":
                isHorror = true;
                break;
            case "science-fiction":
                isScienceFiction = true;
                break;
            case "comedy":
                isComedy = true;
                break;
            case "thriller":
                isThriller = true;
                break;
            case "western":
                isWestern = true;
                break;
            case "adventure":
                isAdventure = true;
                break;
            default:
                System.out.println("not a known genre!");

        }


    }

    public boolean isAction() {
        return isAction;
    }

    public boolean isHorror() {
        return isHorror;
    }

    public boolean isScienceFiction() {
        return isScienceFiction;
    }

    public boolean isComedy() {
        return isComedy;
    }

    public boolean isThriller() {
        return isThriller;
    }

    public boolean isWestern() {
        return isWestern;
    }

    public boolean isAdventure() {
        return isAdventure;
    }
}


