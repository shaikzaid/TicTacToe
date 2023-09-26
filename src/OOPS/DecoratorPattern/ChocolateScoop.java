package OOPS.DecoratorPattern;
//Only Add-On
public class ChocolateScoop implements Desert {
private Desert desert;

public ChocolateScoop(Desert desert){
    this.desert= desert;
}
    @Override
    public int getCost() {
        return desert.getCost() + 48;
    }

    @Override
    public String getDescription() {
        return desert.getDescription() + "ChocolateScoop";
    }
}
