import java.util.*;

public class ChatGPT {

    public static List<Integer> compress(String input) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(Character.toString((char) i), i + 1);
        }

        String current = "";
        List<Integer> output = new ArrayList<>();
        for (char c : input.toCharArray()) {
            String combined = current + c;
            if (dictionary.containsKey(combined)) {
                current = combined;
            } else {
                output.add(dictionary.get(current));
                dictionary.put(combined, dictionary.size() + 1);
                current = Character.toString(c);
            }
        }
        if (!current.equals("")) {
            output.add(dictionary.get(current));
        }
        return output;
    }

    public static String decompress(List<Integer> compressed) {
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(i + 1, Character.toString((char) i));
        }

        int current = compressed.remove(0);
        StringBuilder output = new StringBuilder(dictionary.get(current));
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k)) {
                entry = dictionary.get(k);
            } else if (k == dictionary.size() + 1) {
                entry = dictionary.get(current) + dictionary.get(current).charAt(0);
            } else {
                throw new IllegalArgumentException("Bad compressed k: " + k);
            }
            output.append(entry);
            dictionary.put(dictionary.size() + 1, dictionary.get(current) + entry.charAt(0));
            current = k;
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "WABBAWABBA";
        List<Integer> compressed = compress(input);
        System.out.println("Compressed: " + compressed);
        String decompressed = decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}
