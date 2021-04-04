package praticando.dio.conjuntos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Conjuntos {
    public static void main(String[] args) throws IOException {

        File file = new File("conjuntos.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        var line = br.readLine();
        while (!line.equals("0")) {
            boolean prefix = false;
            Integer numberWords =  Integer.parseInt(line);
            List<String> listWords = new ArrayList<>();
            for(var i = 1; i <= numberWords; i++){
                line = br.readLine();
                listWords.add(line);
            }
            Collections.sort(listWords, Comparator.comparingInt(String :: length));
            for(var i =0; i < listWords.size()-1; i++){
                for(var j = i+1; j < listWords.size() ; j++){
                    if(listWords.get(j).substring(0, listWords.get(i).length()).equals(listWords.get(i))) {
                        prefix = true;
                        break;
                    }
                }
                if(prefix){
                    System.out.println("Conjunto Ruim");
                    break;
                }
            }
            if(!prefix) System.out.println("Conjunto Bom");
            line = br.readLine();
        }
    }
}