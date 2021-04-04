package praticando.dio.abreviacoes;

import java.io.*;
import java.util.*;

public class Abreviacoes {
    public static void main(String[] args) throws IOException {

        File file = new File("abreviacao.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        var line = br.readLine();
        while (!line.equals(".")) {
            StringTokenizer st = new StringTokenizer(line);

            Map<String, String> words = new HashMap<>();
            List<String> listWords = new ArrayList<>();
            Map<String, Integer> wordsLength = new HashMap<>();

            var output = "";
            while (st.hasMoreTokens()) {
                var word = st.nextToken();
                if (word.equals("."))
                    continue;

                if (wordsLength.containsKey(word)) {
                    Integer length = wordsLength.get(word);
                    wordsLength.put(word, (word.length() - 2) + length);
                } else {
                    wordsLength.put(word, word.length() - 2);
                }

                listWords.add(word);
            }

            for (String word : listWords) {
                String key = word.charAt(0) + ".";

                Integer lengthWord = wordsLength.get(word);
                Integer lengthInMap = wordsLength.get(words.get(key));

                if (!words.containsKey(key) && word.length() > 2) {
                    words.put(key, word);
                } else if (words.containsKey(key) && lengthInMap < lengthWord) {
                    words.put(key, word);
                }
            }

            for (String word : listWords) {
                var key = word.charAt(0) + ".";

                if (!words.containsValue(word)) {
                    output += output.isEmpty() ? word : " " + word;
                } else {
                    output += output.isEmpty() ? key : " " + key;
                }
            }

            if (words.size() > 0) {
                System.out.println(output);
                System.out.println(words.size());
                words.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, String>comparingByKey())
                        .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
            }

            line = br.readLine();
        }
    }
}