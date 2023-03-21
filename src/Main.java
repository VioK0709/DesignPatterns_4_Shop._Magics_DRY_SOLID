import Clothes.DressImpl;
import Food.MilkImpl;
import General.Product;
import Technic.PlayerImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int productNumber;
        int productCount;
        int sumProducts = 0;

        Scanner scanner = new Scanner(System.in);
        Product[] products = {new MilkImpl(), new DressImpl(), new PlayerImpl()}; // 5. Liskov substitution principle
        int[] prices = new int[]{100, 200, 10000};
        int[] sum = new int[prices.length];
        int[] count = new int[products.length];

        printProducts(products, prices);

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`.");
            String basket = scanner.nextLine();
            if ("end".equals(basket)) {
                break;
            }
            printProducts(products, prices); // 2. DRY
            String[] parts = basket.split(" ");
            productNumber = Integer.parseInt(parts[0]) - 1;
            productCount = Integer.parseInt(parts[1]);
            if (productNumber >= products.length || productNumber < 0) {
                System.out.println("Введен неверный номер товара.");
            }

            count[productNumber] += productCount;
            sum[productNumber] += prices[productNumber] * productCount;
        }


        System.out.println("Ваша корзина: ");
        for (int i = 0; i < prices.length; i++) {
            if (count[i] != 0) {
                System.out.println(products[i] + "-> количество: " + count[i] + ", цена: " + prices[i] + " руб.");
            }
            sumProducts += sum[i];
        }
        System.out.println("Итого: " + sumProducts + " руб.");

        System.out.println();

        System.out.println("Производится проверка товара:");
        MilkImpl milkImpl = new MilkImpl();
        milkImpl.check();
        milkImpl.eat();
        DressImpl dressImpl = new DressImpl();
        dressImpl.check();
        dressImpl.measure();
        PlayerImpl playerImpl = new PlayerImpl();
        playerImpl.check();
        playerImpl.playMusic();

    }

    private static void printProducts(Product[] products, int[] prices) { // 2. DRY - вынос в отдельный метод
        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < products.length; i++) {  // 1. Избегания магических чисел
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
    }
}


// 1. Magic - избегания магических чисел. Вместо конкретного числа указываем длину массива,
// при необходимости можно будет добавить или убрать продукт не меняя внутри код.
// 2. DRY - вынос печати списка возможные продуктов в отдельный метод.
// 3. Single-Responsibility principly - Принцип единственной ответственности.
// Разбила программу на пакеты и классы с соблюдением логики.
// 4. Open-Closed principle - Принцип открытости / закрытости.
// Класс Product не требует изменений, он расширен за счет наследования классами: MilkImpl, DressImpl, PlayerImpl.
// При этом поля name, price, count закрыты для модификации.
// 5. Liskov substitution principle - Принцип замены Барбары Лисков.
// Наследники класса Product логически имеют возможность сыграть роль предка.
// 6. Interface segregation principle - Принцип сегрегации (разделения) интерфейса.
// Создано несколько различных логически независимых интерфейсов: Measure, Eat, PlayMusic.