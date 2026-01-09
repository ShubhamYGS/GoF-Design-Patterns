package iterator;

import iterator.impl.Playlist;
import iterator.intf.Iterator;

// Client/demo: shows how to loop over a collection using an Iterator.
// The MusicPlayer doesn't need to know how Playlist stores songs internally.
public class MusicPlayer {
    public static void main(String[] args) {
        // Our "collection" (aggregate) that holds songs.
        Playlist playlist = new Playlist();
        playlist.addSong("Shape of You");
        playlist.addSong("Bohemian Rhapsody");
        playlist.addSong("Blinding Lights");

        // Ask the collection for an Iterator to traverse songs one by one.
        Iterator<String> iterator = playlist.createIterator();

        System.out.println("Now Playing:");
        while (iterator.hasNext()) {
            System.out.println(" 🎵 " + iterator.next());
        }
    }
}