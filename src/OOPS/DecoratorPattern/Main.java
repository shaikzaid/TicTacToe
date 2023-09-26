package OOPS.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
    Desert desert= new ChocolateScoop(new OrangeCone());

    System.out.println(desert.getCost() + "  ");
    System.out.println(desert.getDescription());
}}
