package Clothes;

import General.Check;
import General.Product;

public class DressImpl extends Product implements Check, Measure {

    String title = "Платье";


    public void check() {
        System.out.println(title + " проверено, без повреждений.");
    }

    public void measure() {
        System.out.println(title + " померили.");
    }


    @Override
    public String toString() {
        return title;
    }

}
