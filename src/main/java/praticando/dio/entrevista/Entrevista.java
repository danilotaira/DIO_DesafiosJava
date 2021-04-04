package praticando.dio.entrevista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Entrevista {
    public static void main(String[] args) throws IOException {
        File file = new File("entrevista.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null && line.length() <=50) {
            if(line.isEmpty()) continue;
            int size = line.length();
            boolean sufix = false;

            for (int i = 1; i < size; i++) {
                var wordStart = line.substring(0, i);
                var wordFinal = line.substring(i);

                if (wordStart.endsWith(wordFinal)) {
                    System.out.println(wordStart);
                    sufix = true;
                }
            }

            if (!sufix) {
                System.out.println(line);
            }
        }
    }

}