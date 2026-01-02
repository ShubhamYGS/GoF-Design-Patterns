package prototype;

/**
 * Prototype contract for enemies.
 * Implementations must be able to return a copy of themselves.
 */
interface EnemyPrototype {
    EnemyPrototype clone();
}