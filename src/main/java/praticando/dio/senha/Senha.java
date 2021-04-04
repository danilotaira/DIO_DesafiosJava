package praticando.dio.senha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Senha {
    public final static int MAX = 200;

    public static void main(String[] args) throws IOException {
        File file = new File("senha.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?!.*[áàâãéèêíïóôõöúçñ])(?=.*[A-Z])(?!.*\\s)(?!.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,32}$";

        String line;
        while ((line = br.readLine()) != null && line.length() <=50) {
            if(line.isEmpty()) continue;

            if(line.matches(regexPassword))
                System.out.println("Senha valida.");
            else
                System.out.println("Senha invalida.");

        }
    }

}
