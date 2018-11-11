package pl.coderslab.Workshop1;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.onet.pl/");
        String str = "";
        String address = "./popular_words.txt";
        String address2 = "./filtered_popular_words.txt";
        String[] censureWords = {"oraz", "ponieważ", "także", "natomiast", "jeszcze", "się", "już", "tak", "nie", "samo"};
        int count = 0;

        try {
            FileWriter fw = new FileWriter(address, false);
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                StringTokenizer st = new StringTokenizer(elem.text(), ",.- ");
                while (st.hasMoreTokens()) {
                    str = st.nextToken().replaceAll("\"", "");
                    if (str.length() >= 3) {
                        fw.append(str + "\n");
                        count++;
                    }
                }
            }

            fw.close();
            System.out.println("Zapisano " + count + " słów do " + address);

            File file = new File(address);
            Scanner scan = new Scanner(file);
            FileWriter fw1 = new FileWriter(address2, false);
            boolean writeThis;
            count = 0;

            while (scan.hasNextLine()) {
                writeThis = true;
                str = scan.nextLine();
                for (String word : censureWords) {
                    if (str.toLowerCase().equals(word.toLowerCase())) {
                        writeThis = false;
                        break;
                    }
                }

                if (writeThis) {
                    fw1.append(str + "\n");
                    count++;
                }
            }

            scan.close();
            fw1.close();
            System.out.println("Zapisano " + count + " słów po przefiltrowaniu do " + address2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}