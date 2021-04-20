import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> conjuntoDePalavras = new ArrayList<>();

        try {
            BufferedReader lerArquivoBuffer =
                    new BufferedReader(new FileReader("conjunto.txt"));//BufferedReader ler o arquivo e armazena em um Buffer

            String linhaDoConjunto = lerArquivoBuffer.readLine();//readLine ler a primeira linha do conjunto de paralavras

            while (linhaDoConjunto != null) {

                String[] keys = linhaDoConjunto.split(" "); //split quebra a frase em palavras
                for (int i = 0; i < keys.length; i++) {
                    conjuntoDePalavras.add(keys[i].toLowerCase());//toLowerCase deixa todas as letras minusculas
                }

                linhaDoConjunto = lerArquivoBuffer.readLine();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < conjuntoDePalavras.size() - 1; i++) {
            String x = conjuntoDePalavras.get(i);
            for(int j = i+1; j < conjuntoDePalavras.size(); j++) {
                String y = conjuntoDePalavras.get(j);

                if((y.length() == x.length()) && !y.equals(x)) {
                    char[] palavraX = y.toCharArray();
                    char[] palavraY = x.toCharArray();

                    Arrays.sort(palavraX);
                    Arrays.sort(palavraY);

                    if(String.valueOf(palavraX).equals(String.valueOf(palavraY))) {
                        System.out.println(String.format("%s e %s são anagramas", x, y));
                    }
                }
            }
        }
    }
}
