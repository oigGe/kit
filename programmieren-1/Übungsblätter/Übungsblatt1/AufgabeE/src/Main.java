public class Main {
    public static void main(String[] args) {

        Agency kaAgency = new Agency();
        Actor john = new Actor();

        kaAgency.agencyName = "KaAgency";

        john.forename = "John";
        john.surname = "Wayne";
        john.catchphrase = "All battles are fought by scared men who’d rather be some place else.";

        System.out.println(kaAgency.agencyName);
        System.out.println(john.surname);
        System.out.println(john.catchphrase);


    }
}
