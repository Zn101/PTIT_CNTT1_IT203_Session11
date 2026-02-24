public class YasuoUltimate implements UltimateSkill {

    @Override
    public void use(GameCharacter caster, GameCharacter target) {

        if (caster.getMana() < 40) {
            System.out.println(caster.getName() + " khong du mana.");
            return;
        }

        caster.reduceMana(40);

        int damage = caster.getAttack() * 2;
        System.out.println(caster.getName() + " tung Bao Kiem!");
        target.takePhysicalDamage(damage);
    }
}