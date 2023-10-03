public class Main {
    public static void main(String[] args) {
        Player player = new Player("Dmitriy", 15, 19, 100, 20, 40);
        Monster ogre = new Monster("Ogre", 20, 13, 200, 30, 60, 150);
        Fight fight = new Fight(player, ogre);
        fight.simulate();
    }
}