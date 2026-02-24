import java.util.Random;

public class GameCharacter {

    private String name;

    private int maxHp;
    private int hp;

    private int attack;
    private int magicAttack;

    private int defense;
    private int magicDefense;

    private int speed;
    private double accuracy;   // 0.0 -> 1.0
    private double critChance; // 0.0 -> 1.0

    private int mana;

    private static Random random = new Random();

    public GameCharacter(String name,
                         int hp,
                         int attack,
                         int magicAttack,
                         int defense,
                         int magicDefense,
                         int speed,
                         double accuracy,
                         double critChance,
                         int mana) {

        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.magicAttack = magicAttack;
        this.defense = defense;
        this.magicDefense = magicDefense;
        this.speed = speed;
        this.accuracy = accuracy;
        this.critChance = critChance;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMana() {
        return mana;
    }

    public void reduceMana(int amount) {
        mana -= amount;
        if (mana < 0) mana = 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    // ===== Physical Attack =====
    public void attack(GameCharacter target) {

        if (!isAlive()) {
            System.out.println(name + " da chet, khong the tan cong.");
            return;
        }

        // check miss
        if (random.nextDouble() > accuracy) {
            System.out.println(name + " tan cong hut!");
            return;
        }

        int damage = attack;

        // check crit
        if (random.nextDouble() < critChance) {
            damage *= 2;
            System.out.println("Chi mang!");
        }

        System.out.println(name + " tan cong vat ly " + target.name);
        target.takePhysicalDamage(damage);
    }

    // ===== Magic Attack =====
    public void magicAttack(GameCharacter target) {

        if (!isAlive()) {
            System.out.println(name + " da chet, khong the tung chieu.");
            return;
        }

        if (mana < 10) {
            System.out.println(name + " khong du mana.");
            return;
        }

        mana -= 10;

        if (random.nextDouble() > accuracy) {
            System.out.println(name + " tung chieu hut!");
            return;
        }

        int damage = magicAttack;

        if (random.nextDouble() < critChance) {
            damage *= 2;
            System.out.println("Chi mang phep!");
        }

        System.out.println(name + " tan cong phep " + target.name);
        target.takeMagicDamage(damage);
    }

    // ===== Take Damage =====
    public void takePhysicalDamage(int damage) {

        int realDamage = damage - defense;
        if (realDamage < 0) realDamage = 0;

        hp -= realDamage;

        if (hp < 0) hp = 0;

        System.out.println(name + " mat " + realDamage + " HP. Con: " + hp);

        if (hp == 0) {
            System.out.println(name + " da bi ha guc!");
        }
    }

    public void takeMagicDamage(int damage) {

        int realDamage = damage - magicDefense;
        if (realDamage < 0) realDamage = 0;

        hp -= realDamage;

        if (hp < 0) hp = 0;

        System.out.println(name + " mat " + realDamage + " HP. Con: " + hp);

        if (hp == 0) {
            System.out.println(name + " da bi ha guc!");
        }
    }

    private UltimateSkill ultimate;

    public void setUltimate(UltimateSkill ultimate) {
        this.ultimate = ultimate;
    }

    public void useUltimate(GameCharacter target) {
        if (!isAlive()) {
            System.out.println(name + " da chet.");
            return;
        }

        if (ultimate == null) {
            System.out.println(name + " khong co ultimate.");
            return;
        }

        ultimate.use(this, target);
    }

    public void displayInfo() {
        System.out.println("==== " + name + " ====");
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("ATK: " + attack);
        System.out.println("MATK: " + magicAttack);
        System.out.println("DEF: " + defense);
        System.out.println("MDEF: " + magicDefense);
        System.out.println("SPD: " + speed);
        System.out.println("ACC: " + accuracy);
        System.out.println("CRIT: " + critChance);
        System.out.println("MANA: " + mana);
        System.out.println();
    }
}