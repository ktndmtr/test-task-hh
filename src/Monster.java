public class Monster extends Creature {
    private int expForKill;

    public Monster(String name, int attack, int defense, int healthMax, int damageMin, int damageMax, int expForKill) {
        super(name, attack, defense, healthMax, damageMin, damageMax);
        this.expForKill = expForKill;
    }
    public int getExpForKill() {
        return expForKill;
    }

    public void setExpForKill(int expForKill) {
        this.expForKill = expForKill;
    }
}
