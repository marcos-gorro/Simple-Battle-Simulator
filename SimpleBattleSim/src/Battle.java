import java.util.Random;
import java.util.Scanner;
public class Battle extends Main{
    Person player;
    Person enemy;
    Scanner scanner = new Scanner(System.in);


    public Battle(Person player, Person enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle(){
        System.out.println("\nBattle begins!");
        System.out.println("Enemy Health: " + enemy.getHealth());
        
        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            PlayerTurn();
        }        
        if(player.getHealth() <= 0){
            System.out.println("You have been defeated!");
            //scanner.close();
        }
        else if(enemy.getHealth() <= 0){
            System.out.println("You have defeated the enemy!");
            //scanner.close();
        }
    }

    public void PlayerTurn(){
        System.out.print("Attack or Defend: ");
        String action = scanner.nextLine().toLowerCase();
        Random random = new Random();
        int critChance = random.nextInt(50);
        String enemyAction = random.nextInt(2)==0 ? "attack" : "defend";


        if(action.equals("attack") && (enemyAction.equals("attack"))){                  //both attack
            if (critChance >=45){
            enemy.setHealth(enemy.getHealth() - (player.getAttack()*3));                                  //player crit chance
            player.setHealth(player.getHealth() - enemy.getAttack());
            System.out.println("\nYou landed a critical hit on the enemy! (*3 damage)");
            System.out.println("Enemy attacked you back for normal damage!");
            } else if(critChance <=5){
            player.setHealth(player.getHealth() - (enemy.getAttack()*3));                                 //enemy crit chance
            enemy.setHealth(enemy.getHealth() - player.getAttack());
            System.out.println("\nThe enemy landed a critical hit on you! (*3 damage)");
            System.out.println("You attacked the enemy for normal damage!");
            }else {
            enemy.setHealth(enemy.getHealth() - player.getAttack());
            player.setHealth(player.getHealth() - enemy.getAttack());
            System.out.println("\nYou attacked the enemy!");
            System.out.println("However, the enemy attacked you back!");
            }
        }

        else if(action.equals("attack") && (enemyAction.equals("defend"))){            //attack vs defend
            if(critChance >=40){
            enemy.setHealth(enemy.getHealth() - (player.getAttack()*2));                                 //player breaks through defense
            System.out.println("\nYou broke through the enemy's defense and landed a critical hit! (*2 damage)");
            }else{
            System.out.println("Enemy defended your attack!");
            }
        }

        else if(action.equals("defend") && (enemyAction.equals("attack"))){             //defend vs attack
            if(critChance <=10){
            player.setHealth(player.getHealth() - (enemy.getAttack()*2));                                 //Enemy breaks through defense
            System.out.println("\nEnemy broke through your defense and landed a critical hit! (*2 damage)");
            }else{
            System.out.println("You defended enemy attack!");
            }
        }
        else if(action.equals("defend") && (enemyAction.equals("defend"))){            //both defend
            if (critChance >=40){                                                                        //player crit chance
            enemy.setHealth(enemy.getHealth() - player.getAttack());
            System.out.println("\nYou guys both defended, but you attacked the enemy anyway!");
            }else if(critChance <=10){                                                                    //enemy crit chance
            player.setHealth(player.getHealth() - enemy.getAttack());
            System.out.println("\nYou guys both defended, but the enemy attacked you anyway!");
            }else{
            System.out.println("\nYou both defended. Nothing happened.");
            }   
        }else if(action.equals("cheatcodes") || action.equals("cheat codes") || action.equals("cc")){  //cheat codes menu
            cheatCodes();
        }else{                                                                                          
            System.out.println("\nInvalid action. Please choose Attack or Defend.");                   //invalid input
            System.out.println("Player:" + action +"Enemy:" + enemyAction);

        }
        System.out.println("\nYour health: " + player.getHealth());
        System.out.println("Enemy health: " + enemy.getHealth());
        
    }

    public void cheatCodes(){
        System.out.println("\n|Cheat Codes|\n- Godmode (sets your health to 999) (gm)\n- InstaKill (sets your attack to 999) (ik)\n(0 to quit)");
        String choice = scanner.nextLine().toLowerCase();
        if(choice.equals("godmode") || choice.equals("gm")){
            player.setHealth(999);
            System.out.println("Godmode activated! Your health is now 999.");
            cheatCodes();
        } else if(choice.equals("instantkill")|| choice.equals("ik")){
            player.setAttack(999);
            System.out.println("Instant Kill activated! Your attack is now 999.");
            cheatCodes();
        } else if(choice.equals("0")){
            System.out.println("Exiting cheat codes menu.");
        } else{
            System.out.println("Invalid cheat code.");
            cheatCodes();
        }
    }

    // scanner.close(); // Moved to a method if needed
}
