package iterator.intf;

// Basic iterator contract: check if more items exist, then fetch the next item.
public interface Iterator<T> {
    boolean hasNext();

    T next();
}