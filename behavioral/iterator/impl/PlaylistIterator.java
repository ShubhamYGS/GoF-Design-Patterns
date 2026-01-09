package iterator.impl;

import iterator.intf.Iterator;

// Concrete iterator: knows how to walk through a Playlist from start to end.
class PlaylistIterator implements Iterator<String> {
    private final Playlist playlist;

    // Remembers where we are in the traversal.
    private int index = 0;

    public PlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public String next() {
        // Return current item and move the cursor forward.
        return playlist.getSongAt(index++);
    }
}