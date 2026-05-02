package iterator.intf;

// Collection that can provide an Iterator to traverse its elements.
public interface IterableCollection<T> {
    Iterator<T> createIterator(String type);
}