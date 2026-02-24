public abstract class Drink {

    protected int id;
    protected String name;
    protected int price;

    public Drink(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public int getBaseSalary() {return price;}

    public abstract int calculatePrice();

    public void displayInfo() {};

    public void mix() {};
}
