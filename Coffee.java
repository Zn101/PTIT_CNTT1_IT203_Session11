public class Coffee extends Drink {
    protected boolean hasMilk;

    public Coffee(int id, String name, int price, boolean hasMilk) {
        super(id, name, price);
    }

    @Override
    public int calculatePrice() {
        if (hasMilk) {
            System.out.println(price + 5000);
        } else {
            System.out.println(price);
        }
        return price;
    }

    @Override
    public void displayInfo() {
        System.out.println("id do uong: " + id);
        System.out.println("ten do uong: " + name);
        System.out.println("gia do uong: " + price);
    };
}