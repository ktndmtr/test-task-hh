public class Creature {

    private static final int MAX_ATTACK_DEFENSE = 30;
    private static final int MIN_ATTACK_DEFENSE = 1;

    private String name;
    private int attack;
    private int defense;
    private int healthCurrent;
    private int healthMax;

    private int damageMin;

    private int damageMax;
    public Creature(String name, int attack, int defense, int healthMax, int damageMin, int damageMax) {
        this.name = name;
        if(attack < MIN_ATTACK_DEFENSE || attack > MAX_ATTACK_DEFENSE) {
            throw new IllegalArgumentException("Недопустимый параметр атаки.");
        }
        if(defense < MIN_ATTACK_DEFENSE || defense > MAX_ATTACK_DEFENSE) {
            throw new IllegalArgumentException("Недопустимый параметр защиты.");
        }
        this.attack = attack;
        this.defense = defense;
        if(healthMax <= 0) {
            throw new IllegalArgumentException("Максимальное здоровье должно быть больше нуля.");
        }
        this.healthMax = healthMax;
        if(damageMin <= 0 || damageMax <= 0) {
            throw new IllegalArgumentException("Границы диапазона урона должны быть натуральными числами.");
        }
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        healthCurrent = healthMax;
    }

    public boolean isAlive(){
        return healthCurrent > 0;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealthCurrent() {
        return healthCurrent;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setHealthCurrent(int healthCurrent) {
        if(healthCurrent < 0 || healthCurrent > healthMax){
            throw new IllegalArgumentException("Нельзя установить здоровье меньше нуля или больше максимального.");
        }
        this.healthCurrent = healthCurrent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        if(attack < MIN_ATTACK_DEFENSE || attack > MAX_ATTACK_DEFENSE) {
            throw new IllegalArgumentException("Недопустимый параметр атаки.");
        }
        this.attack = attack;
    }

    public void setDefense(int defense) {
        if(defense < MIN_ATTACK_DEFENSE || defense > MAX_ATTACK_DEFENSE) {
            throw new IllegalArgumentException("Недопустимый параметр защиты.");
        }
        this.defense = defense;
    }

    public void setHealthMax(int healthMax) {
        if(healthMax <= 0) {
            throw new IllegalArgumentException("Максимальное здоровье должно быть больше нуля.");
        }
        this.healthMax = healthMax;
    }

    public void setDamageMin(int damageMin) {
        if(damageMin <= 0) {
            throw new IllegalArgumentException("Границы диапазона урона должны быть натуральными числами.");
        }
        this.damageMin = damageMin;
    }

    public void setDamageMax(int damageMax) {
        if(damageMax <= 0) {
            throw new IllegalArgumentException("Границы диапазона урона должны быть натуральными числами.");
        }
        this.damageMax = damageMax;
    }
}
