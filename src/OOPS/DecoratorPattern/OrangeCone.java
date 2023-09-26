package OOPS.DecoratorPattern;
// usable as a base only
public class OrangeCone implements Desert {

    public OrangeCone(){
    }


    @Override
    public int getCost() {
        return 30 ;
    }

    @Override
    public String getDescription() {
        return "Orange Cone";
    }
}
