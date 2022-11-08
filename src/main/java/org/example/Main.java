package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main1 {
    public void main1(String[] args) {
        System.out.println("Main1 match");
        try
        {
            // Le fichier d'entrée
            File file = new File("C:\\melbarrak\\projets\\CHANEL_PEARL\\Exercices\\jsonToTestitFormat\\src\\main\\java\\org\\example\\file.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)
            {

                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Testit format: ");
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}