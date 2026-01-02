package singleton;

import singleton.eager.EagerSingletonWithSerializationReflectionFix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Short demo that verifies common singleton safety guarantees:
 * 1) getInstance() returns the same object every time
 * 2) Serialization + deserialization do NOT create a new instance
 * 3) Reflection cannot create a second usable instance (constructor protection)
 * <p>
 * Expected console output (approx):
 * Are both instances the same? true
 * Is deserialized instance same? true
 * Reflection Safety PASSED: Instance already created.
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception {

        // 1️⃣ getInstance() equality test
        var instance1 = EagerSingletonWithSerializationReflectionFix.getInstance();
        var instance2 = EagerSingletonWithSerializationReflectionFix.getInstance();

        // Both references should point to the exact same object
        System.out.println("Are both instances the same? " + (instance1 == instance2));
        // -> true

        // 2️⃣ Serialization test
        // Serialize the singleton to disk, then read it back and ensure readResolve()
        // (in the singleton) returns the same instance instead of creating a new one.
        Path file = Path.of("singleton.ser");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.toFile()))) {
            oos.writeObject(instance1);
        }

        EagerSingletonWithSerializationReflectionFix deserializedInstance;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file.toFile()))) {
            deserializedInstance = (EagerSingletonWithSerializationReflectionFix) ois.readObject();
        }

        // Deserialized object should be == the original due to readResolve()
        System.out.println("Is deserialized instance same? " + (instance1 == deserializedInstance));
        // -> true

        // Remove demo file
        Files.deleteIfExists(file);

        // 3️⃣ Reflection test
        // Attempt to use reflection to call the private constructor. The singleton's
        // constructor should detect and prevent reflective creation (throws Exception).
        try {
            Constructor<EagerSingletonWithSerializationReflectionFix> constructor =
                    EagerSingletonWithSerializationReflectionFix.class.getDeclaredConstructor();

            constructor.setAccessible(true);
            constructor.newInstance();

            System.out.println("Reflection Safety FAILED");
        } catch (Exception e) {
            // We expect an exception; print the cause message for notes/readability
            String causeMsg = (e.getCause() != null) ? e.getCause().getMessage() : e.getMessage();
            System.out.println("Reflection Safety PASSED: " + causeMsg);
        }
    }
}
