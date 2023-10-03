import java.util.Random;

public class Fight {
    private final Player player;
    private final Monster monster;


    public Fight(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void attack(Creature attacking, Creature defending){
        if(attacking.equals(defending)){
            System.out.println("Невозможно атаковать самого себя.");
            return;
        }
        if(!defending.isAlive()) {
            System.out.println("Невозможно атаковать мертвое существо.");
            return;
        }
        System.out.println(attacking.getName() + " пытается атаковать " + defending.getName() + ".");
        int attackModifier = attacking.getAttack() - defending.getDefense() + 1;
        int dicesNumber = Math.max(attackModifier, 1);
        Random random = new Random();
        boolean isSuccessful = false;
        System.out.print(attacking.getName() + " бросает " + dicesNumber + " кубика: ");
        for(int i = 0; i < dicesNumber; i++){
            int dice = random.nextInt(6) + 1;
            if(i < dicesNumber - 1) {
                System.out.print(dice + ", ");
            }
            else {
                System.out.println(dice + ".");
            }
            if(dice >= 5){
                isSuccessful = true;
            }
        }
        if(isSuccessful){
            int damage = random.nextInt(attacking.getDamageMax() - attacking.getDamageMin()) + attacking.getDamageMin();
            int defendingHealth = defending.getHealthCurrent();
            defending.setHealthCurrent(Math.max(0, defendingHealth - damage));
            System.out.println(attacking.getName() + " наносит " + damage + " урона.");
        }
        else {
            System.out.println(attacking.getName() + " промахивается.");
        }
    }

    public void simulate(){
        System.out.println("Начинается бой между " + this.player.getName() + " и " + this.monster.getName() + ".");
        int step = 1;
        while(player.isAlive() && monster.isAlive()){
            System.out.println("Ход " + step + ":");
            if(player.getHealthCurrent() <= (1 - Player.HEAL_FACTOR)*player.getHealthMax()){
                player.heal();
            }
            attack(player, monster);
            if(monster.isAlive()){
                attack(monster, player);
            }
            step++;
        }
        Creature winner = player.isAlive() ? player : monster;
        System.out.println("Победитель боя - " + winner.getName() + ".");
        if(winner.equals(player)){
            player.setExp(player.getExp() + monster.getExpForKill());
        }
    }
}
