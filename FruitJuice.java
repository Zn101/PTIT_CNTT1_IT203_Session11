public class FruitJuice extends Drink {
    protected int discountPercent;

    public FruitJuice(int id, String name, int price, int discountPercent) {
        super(id, name, price);
    }

    @Override
    public int calculatePrice() {
        System.out.println(price - (price * discountPercent/100));
        return price;
    };

    @Override
    public void mix() {
        System.out.println("Dang ep trai cay tuoi...");
    };

    @Override
    public void displayInfo() {
        System.out.println("id do uong: " + id);
        System.out.println("ten do uong: " + name);
        System.out.println("gia do uong: " + price);
    };
}