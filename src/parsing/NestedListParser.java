package parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class NestedListParser {
    private static Document document;

    public static void main(String[] args) {
        File file = new File("src/basic/nestedList.html");
        try {
            document = Jsoup.parse(file, "UTF-8", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements items = document.select("body>ul>li"); // ищет связку ul>li !!!
        for (Element item : items) {
            System.out.println(item.id());
            Elements inners = item.select("ul>li");
            for (Element inner : inners)
                System.out.println("\t" + inner.text());
        }
    }
}
