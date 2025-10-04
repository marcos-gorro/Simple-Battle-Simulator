import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    // Clear terminal (Windows)
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Ignore if clear fails
        }

       Scanner scanner = new Scanner(System.in);

        System.out.print("Choose your character(1,2): ");
        int choice = scanner.nextInt();

        System.out.println("You chose character " + choice);
        System.out.print("Enter health(50-100): ");
        int health = scanner.nextInt();
        while(health < 50 || health > 100){
            System.out.println("Health must be between 50 and 100.");
            System.out.print("Enter health: ");
            health = scanner.nextInt();
        }
        System.out.print("Enter attack(5-10): ");
        int attack = scanner.nextInt();
        while(attack < 5 || attack > 10){
            System.out.println("Attack must be between 5 and 10.");
            System.out.print("Enter attack: ");
            attack = scanner.nextInt();
        }

        Person player = new Person(health, attack);

        System.out.println("Player health: " + player.getHealth() + " and Attack: " + player.getAttack());
        Person enemy = new Person(150, 15);
        Battle battle = new Battle(player, enemy);
        battle.startBattle();
        scanner.close();

    }
}
