package prototype;

/**
 * Demo client showing usage of prototype and deep-copy prototype examples.
 * It registers prototypes in the registry and requests clones for modification.
 */
public class Client {
    public static void main(String[] args) {
        Enemy goblin = new Enemy("Goblin", 100, 1.5, false, "Dagger");
        Enemy orc = new Enemy("Orc", 200, 1.0, true, "Axe");
        Enemy dragon = new Enemy("Dragon", 500, 2.0, true, "Fire Breath");

        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", goblin);
        registry.register("orc", orc);
        registry.register("dragon", dragon);

        Enemy goblinClone = (Enemy) registry.get("goblin");
        goblinClone.setHealth(80); // Modify clone's health
        goblinClone.printStats(); // Should show health as 80
        goblin.printStats(); // Original should remain 100

        // Demonstrating Deep Copy Prototype
        DeepCopyEnemy armoredGoblin = new DeepCopyEnemy("DeepGoblin", 120, 1.6, false, java.util.Arrays.asList("Shield", "Sword"));
        DeepCopyEnemy fireDragon = new DeepCopyEnemy("FireDragon", 600, 2.5, true, java.util.Arrays.asList("Fire Breath", "Claw"));
        registry.register("ArmoredGoblin", armoredGoblin);
        registry.register("FireDragon", fireDragon);

        DeepCopyEnemy armoredGoblinClone = (DeepCopyEnemy) registry.get("ArmoredGoblin");
        armoredGoblinClone.addWeapon("Bow"); // Modify clone's weapons
        armoredGoblinClone.printStats(); // Should show the new weapon
        armoredGoblin.printStats(); // Original should not have the new weapon
    }
}
