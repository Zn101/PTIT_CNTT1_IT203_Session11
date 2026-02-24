public class LuxUltimate implements UltimateSkill {

    @Override
    public void use(GameCharacter caster, GameCharacter target) {

        if (caster.getMana() < 60) {
            System.out.println(caster.getName() + " khong du mana.");
            return;
        }

        caster.reduceMana(60);

        int damage = caster.getMagicAttack() * 3;
        System.out.println(caster.getName() + " tung Cau Vong Toi Thuong!");
        target.takeMagicDamage(damage);
    }
}