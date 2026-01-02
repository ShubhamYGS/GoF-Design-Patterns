package singleton;

import singleton.eager.EagerSingleton;
import singleton.eager.EnumSingleton;
import singleton.eager.StaticBlockSingleton;
import singleton.lazy.BillPughSingleton;
import singleton.lazy.DoubleCheckedSingleton;
import singleton.lazy.LazySingleton;
import singleton.lazy.ThreadSafeSingleton;

// Simple runner that demonstrates different singleton implementations
public class SingletonMain {
    public static void main(String[] args) {
        // 1. Test Eager Singleton
        EagerSingleton eagerInstance1 = EagerSingleton.getInstance();
        EagerSingleton eagerInstance2 = EagerSingleton.getInstance();
        System.out.println("Eager Singleton: " + (eagerInstance1 == eagerInstance2));

        // 2. Test Static Block Singleton (similar to eager but handles exceptions)
        StaticBlockSingleton staticBlockInstance1 = StaticBlockSingleton.getInstance();
        StaticBlockSingleton staticBlockInstance2 = StaticBlockSingleton.getInstance();
        System.out.println("Static Block Singleton: " + (staticBlockInstance1 == staticBlockInstance2));

        // 3. Test Enum Singleton (best way to implement singleton in Java)
        EnumSingleton enumInstance1 = EnumSingleton.INSTANCE;
        EnumSingleton enumInstance2 = EnumSingleton.INSTANCE;
        System.out.println("Enum Singleton: " + (enumInstance1 == enumInstance2));

        // 4. Test Bill Pugh Singleton (uses static inner helper class)
        BillPughSingleton billPughInstance1 = BillPughSingleton.getInstance();
        BillPughSingleton billPughInstance2 = BillPughSingleton.getInstance();
        System.out.println("Bill Pugh Singleton: " + (billPughInstance1 == billPughInstance2));

        // 5. Test Lazy Singleton (Not Thread-Safe)
        LazySingleton lazyInstance1 = LazySingleton.getInstance();
        LazySingleton lazyInstance2 = LazySingleton.getInstance();
        System.out.println("Lazy Singleton: " + (lazyInstance1 == lazyInstance2));

        // 6. Test Lazy Singleton (Thread-Safe, Synchronized Method)
        ThreadSafeSingleton threadSafeInstance1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton threadSafeInstance2 = ThreadSafeSingleton.getInstance();
        System.out.println("Thread-Safe Singleton: " + (threadSafeInstance1 == threadSafeInstance2));

        // 7. Test Lazy Singleton (Thread-safe, Double-Checked Locking)
        DoubleCheckedSingleton doubleCheckedInstance1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton doubleCheckedInstance2 = DoubleCheckedSingleton.getInstance();
        System.out.println("Double-Checked Locking Singleton: " + (doubleCheckedInstance1 == doubleCheckedInstance2));
    }
}
