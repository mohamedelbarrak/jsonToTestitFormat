package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("your file must be like this:");
        System.out.println("{\n...\n}");
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
            Boolean f = false;
            while((line = br.readLine()) != null)
            {
                line = AddSlach(line);// \
                line = AddQuotationMarks(line);// "
                if(f==true)
                line = AddPlus(line);// +
                f = true;
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Testit format of your file: ");
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static String AddPlus(String line) {
        StringBuffer str = new StringBuffer(line);
        // ajouter le caractère au début de la chaîne
        str.insert(0,'+');
        //System.out.println("AddQuotationMarks line: "+str);
        String lineDone = String.valueOf(str);
        return lineDone;
    }

    private static String AddSlach(String line) {
        StringBuffer str = new StringBuffer(line);
        List<Integer> list1 = new ArrayList<Integer>();
        int j=0;
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == '\"') {
                list1.add(i+j);
                j++;
            }
        }

        for (int z=0; z < list1.size() ; z++) {
            char a = '\\';
            int aa = list1.get(z);
            str.insert(aa, '\\');
        }
        // ajouter le caractère L au milieu de la chaîne
        //str.insert(5,'\\');
        String lineDone = String.valueOf(str);
        return lineDone;
    }

    private static String AddQuotationMarks(String line) {
        StringBuffer str = new StringBuffer(line);
        // ajouter le caractère au début de la chaîne
        str.insert(0,'"');
        // ajouter le caractère à la fin de la chaîne
        str.append('"');
        //System.out.println("AddQuotationMarks line: "+str);
        String lineDone = String.valueOf(str);
        return lineDone;
    }
}