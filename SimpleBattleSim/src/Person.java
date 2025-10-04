public class Person extends Main{
    int health;
    int attack;


    public Person(int health, int attack){
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
}
