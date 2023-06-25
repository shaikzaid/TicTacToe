import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please insert the quantiy of the Item purchased");
        int quantity = scn.nextInt();
        ArrayList<String> list = new ArrayList<>();
        double saleTax=0;
        double importedTax= 5;
        double salesTax=10;
        while(quantity > 0) {
            System.out.println("if imported please type imported or n");
            String type=scn.next();
            System.out.println("price");
            double priceTaxInc=scn.nextDouble();
            System.out.println("product");
            String product= scn.next();

                if(Objects.equals(product, "book") || Objects.equals(product, "medicine") || Objects.equals(product, "food")){
                    if(Objects.equals(type, "imported")){
                        double Tax= (priceTaxInc * importedTax)/100;
                        priceTaxInc=Tax + priceTaxInc;
                        String statement= "\" \"+quantity+\" \"+type+\" \"+product+\" \"+priceTaxInc+\" \"";
                        list.add(statement);
                        System.out.println(" "+quantity+" "+type+" "+product+" "+priceTaxInc+" ");
                        saleTax= Tax + saleTax;
                    }
                    else {
                        saleTax =0;
                        String statement=" "+quantity+" "+type+" "+product+" "+priceTaxInc+" ";
                        list.add(statement);
                        System.out.println(" "+quantity+" "+type+" "+product+" "+priceTaxInc+" ");
                    }
                }
                else {
                    if (Objects.equals(type, "imported")){
                        double impSaleTax= ImportedTax(priceTaxInc);
                       // double impSaleTax= priceTaxInc * (importedTax + salesTax)/100;
                        priceTaxInc = impSaleTax+priceTaxInc;
                        String statment=" "+quantity+" "+type+" "+product+" "+priceTaxInc+" ";
                        list.add(statment);
                        System.out.println(" "+quantity+" "+type+" "+product+" "+priceTaxInc+" ");
                        saleTax=impSaleTax + saleTax;

                    }
                    else {
                       double Sale1Tax= tax(priceTaxInc);
                        //double Sale1Tax= (priceTaxInc * salesTax)/100;
                        priceTaxInc=Sale1Tax+priceTaxInc;
                        String statement=" "+quantity+" "+product+" "+priceTaxInc+" ";
                        list.add(statement);
                        System.out.println(" "+quantity+" "+product+" "+priceTaxInc+" ");
                        saleTax=Sale1Tax + saleTax;
                    }
                }
                System.out.println("next product quantity if no product remaining press 0 ");
                quantity=scn.nextInt();
            }

        System.out.println(list);
        System.out.println(saleTax);

        }

    public static double tax(double price){
        int percent= 10;
        double ans= (price * percent)/100;
        return ans;
    }
    public static double ImportedTax(double price){
        int percent = 5;
        double ans= (price * percent)/100;
        return ans;
    }
    }

