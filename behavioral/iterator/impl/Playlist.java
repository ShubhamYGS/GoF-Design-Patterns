package iterator.impl;

import iterator.intf.IterableCollection;
import iterator.intf.Iterator;

import java.util.ArrayList;
import java.util.List;

// Aggregate/collection: owns the data (songs) and can create an Iterator for it.
public class Playlist implements IterableCollection<String> {
    // Internal storage detail (clients shouldn't care about this).
    private final List<String> songs = new ArrayList<>();

    public void addSong(String song) {
        songs.add(song);
    }

    // Helper used by the iterator to read items by index.
    public String getSongAt(int index) {
        return songs.get(index);
    }

    public int getSize() {
        return songs.size();
    }

    @Override
    public Iterator<String> createIterator(String type) {
        // Returning an iterator keeps traversal logic outside the collection.
        switch (type) {
            case "Sequential" : return new SequentialPlaylistIterator(this);
            case "Shuffle": return new ShufflePlaylistIterator(this);
            default: throw new IllegalArgumentException("Playlist type not available");
        }
    }
}