package georggross.Grammar;


public class Variable implements ITermPart {
    private String name;
    //vermutlich unnoetig, da nur der wert benoetigt wird und die rechnung nicht wiedergegeben werden muss
    private Expressions expression;
    private Complex value;

    public Variable(String name, Expressions expression) {
        this.name = name;
        this.expression = expression;
    }
}
