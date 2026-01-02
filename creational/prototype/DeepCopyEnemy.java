package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Prototype implementation demonstrating a deep copy.
 * The list of weapons is copied so clones can be modified independently.
 */
public class DeepCopyEnemy implements EnemyPrototype {
    private String type;
    private int health;
    private double speed;
    private boolean armored;
    private List<String> weapon;

    public DeepCopyEnemy(String type, int health, double speed, boolean armored, List<String> weapon) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.armored = armored;
        this.weapon = new ArrayList<>(weapon);  // Deep copy of the list
    }

    @Override
    public EnemyPrototype clone() {
        return new DeepCopyEnemy(type, health, speed, armored, new ArrayList<>(weapon));    // Deep copy of the list
    }

    public void addWeapon(String w) {
        this.weapon.add(w);
    }

    public void printStats() {
        System.out.println(type + " [Health: " + health +
                ", Speed: " + speed +
                ", Armored: " + armored +
                ", Weapons: " + weapon + "]");
    }
}
