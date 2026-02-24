public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];
        drinks[0] = new Coffee(1, "Bac siu", 30000, true);
        drinks[1] = new FruitJuice(2, "Nuoc Cam", 40000, 10);
        drinks[2] = null;
        for(int i=0; i<3; i++) {
            assert drinks[i] != null;
            drinks[i].calculatePrice();
            drinks[i].displayInfo();
            drinks[i].mix();
        }
    }
}