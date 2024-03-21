package parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class ListParser {
    private static Document document;

    public static void main(String[] args) {
        File file = new File("src/basic/list.html");
        try {
            document = Jsoup.parse(file, "UTF-8", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements items = document.select("ul>li");
        for (Element item : items) {
            String text = item.text().trim();
            System.out.println(text);
        }
    }
}
