public class Player extends Creature {
    private static final int EXP_FOR_LEVEL_UP = 100;
    public static final double HEAL_FACTOR = 0.3;
    private int level;
    private int exp;
    private int healingCharges;

    public Player(String name, int attack, int defense, int healthMax, int damageMin, int damageMax) {
        super(name, attack, defense, healthMax, damageMin, damageMax);
        healingCharges = 4;
        level = 1;
        exp = 0;
    }

    public void heal(){
        if(healingCharges > 0) {
            int healthMax = getHealthMax();
            int healthCurrent = getHealthCurrent();
            int healthDifference = Math.min(healthMax - healthCurrent, (int) (HEAL_FACTOR * healthMax));
            setHealthCurrent(healthCurrent + healthDifference);
            healingCharges--;
            System.out.println(this.getName() + " излечил себя на " + healthDifference + " очков здоровья.");
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        while(exp >= EXP_FOR_LEVEL_UP){
            exp -= EXP_FOR_LEVEL_UP;
            level++;
            System.out.println(this.getName() + " получил " + level + " уровень.");
        }
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public int getHealingCharges() {
        return healingCharges;
    }
}
