package OOPS.DecoratorPattern;
//both addon and base
public class VanillaCone implements Desert {

    private Desert desert;
    public VanillaCone (Desert desert){
        this.desert=desert;
    }
    @Override
    public int getCost() {
        if(desert == null){
        return 0;}
        else{
            return desert.getCost() + 25;
        }
    }

    @Override
    public String getDescription() {
        if(desert == null){
        return null;
    }
        else {
             return desert.getDescription() + "VanillaCone";
        }
}}
