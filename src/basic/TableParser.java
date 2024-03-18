package basic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class TableParser {
    private static Document document;
    private static final String url = "https://www.w3schools.com/html/html_tables.asp";

    public static void main(String[] args) {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.err.println("Check HTTP connection to the url " + url);
        }

        //#customers>tbody>tr>td
        ////*[@id="customers"]/tbody/tr[2]

        Elements headers = document.select("#customers>tbody>th>td");
        int index = 0;
        for (Element header : headers) {
            System.out.println(header.html());
            Elements cells = document.select(String.format("#costomers>tbody>tr>td:eq(%d)", index++));
            for (Element cell : cells) {
                System.out.println("\t" + cell.html());
            }
        }
    }
}

