package General;

public class Product { // 4. Open-Closed principle - Принцип открытости / закрытости.
    private String title;
    private int price;
    private int count;

    public String getTitle() {
        return title;
    }

    public Product setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Product setCount(int count) {
        this.count += count;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }


    public String toString() {
        return title;
    }
}
