import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC - O(Songs * Users)
// SC - O(Songs)

public class FavouriteGenres {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap,
            Map<String, List<String>> genreMap) {
        Map<String, List<String>> userToFavGenreMap = new HashMap<>();
        Map<String, String> songToGenreMap = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                songToGenreMap.put(song, genre);
            }
        }

        for (String user : userMap.keySet()) {
            Map<String, Integer> genreToFreqMap = new HashMap<>();
            int maxFreq = 0;
            List<String> songs = userMap.get(user);
            for (String song : songs) {
                String genre = songToGenreMap.get(song);
                genreToFreqMap.put(genre, genreToFreqMap.getOrDefault(genre, 0) + 1);
                maxFreq = Math.max(maxFreq, genreToFreqMap.get(genre));
            }

            userToFavGenreMap.put(user, new ArrayList<>());
            for (String genre : genreToFreqMap.keySet()) {
                if (genreToFreqMap.get(genre) == maxFreq) {
                    userToFavGenreMap.get(user).add(genre);
                }
            }
        }
        return userToFavGenreMap;
    }

    public static void main(String[] args) {

        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[] { "song1", "song2", "song3", "song4", "song8" }));

        userSongs.put("Emma", Arrays.asList(new String[] { "song5", "song6", "song7" }));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[] { "song1", "song3" }));

        songGenres.put("Dubstep", Arrays.asList(new String[] { "song7" }));

        songGenres.put("Techno", Arrays.asList(new String[] { "song2", "song4" }));

        songGenres.put("Pop", Arrays.asList(new String[] { "song5", "song6" }));

        songGenres.put("Jazz", Arrays.asList(new String[] { "song8", "song9" }));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);

    }
}