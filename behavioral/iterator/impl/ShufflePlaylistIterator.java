package iterator.impl;

import iterator.intf.Iterator;

import java.util.random.RandomGenerator;

// Concrete iterator: knows how to walk through a Playlist in a shuffled way.
class ShufflePlaylistIterator implements Iterator<String> {
    private final Playlist playlist;

    // Remembers where we are in the traversal.
    private int index = 0;

    private final RandomGenerator randomGenerator = RandomGenerator.getDefault();

    public ShufflePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public String next() {
        // Use RandomGenerator to play any song randomly
        index = randomGenerator.nextInt(0, playlist.getSize()-1);
        return playlist.getSongAt(index);
    }
}