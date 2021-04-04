package praticando.dio.maiorSubstring;

import java.io.*;

public class MaiorSubstring {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        File file = new File("maiorSubstring.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line, nextLine, min ; //declare suas variaveis aqui
        while ((line = in.readLine()) != null && !line.isEmpty() && line.length() <=50) { // complete seu código
            nextLine = in.readLine();

            if (nextLine == null && nextLine.isEmpty() && nextLine.length() > 50) break;

            int maxSubstring =0 ;
            int lengthSubstring = 0;

            for(var i = 0; i < line.length(); i++){
                lengthSubstring = 0;
                for(var j = i; j< line.length(); j++){
                    var li = line.substring(i,j+1);

                    if(nextLine.contains(li))
                        lengthSubstring++;
                    else
                        break;
                }
                if(lengthSubstring>maxSubstring)
                    maxSubstring = lengthSubstring;
            }
            System.out.println(maxSubstring);

        }
        out.close();
    }

}
