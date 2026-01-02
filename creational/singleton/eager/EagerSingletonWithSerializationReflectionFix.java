package singleton.eager;

import java.io.Serializable;

// Eager singleton with protections against serialization, cloning and reflection.
public final class EagerSingletonWithSerializationReflectionFix implements Serializable {

    private static final long serialVersionUID = 1L;

    // Eager initialization
    private static final EagerSingletonWithSerializationReflectionFix INSTANCE =
            new EagerSingletonWithSerializationReflectionFix();

    private EagerSingletonWithSerializationReflectionFix() {
        // Protection against reflection: if an instance already exists, prevent re-creation
        if (INSTANCE != null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static EagerSingletonWithSerializationReflectionFix getInstance() {
        return INSTANCE;
    }

    // Ensure deserialization returns the existing instance
    private Object readResolve() {
        return INSTANCE;
    }

    // Prevent cloning of singleton
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton is not allowed");
    }
}
