package Food;

import General.Check;
import General.Product;

public class MilkImpl extends Product implements Eat, Check { // 5. Liskov substitution principle - Принцип замены Барбары Лисков.

    String title = "Молоко";

    @Override
    public void check() {
        System.out.println(title + " проверено, срок годности в норме.");
    }

    @Override
    public void eat() {
        System.out.println(title + " можно употреблять.");
    }

    @Override
    public String toString() {
        return title;
    }

}
