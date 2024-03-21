package parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import java.io.IOException;

public class CitiesParsing {
    private static Document document;
    private static final String url = "https://en.wikipedia.org/wiki/List_of_cities_and_towns_in_Belarus";

    public static void main(String[] args) throws IOException {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.err.println("Check HTTP connection to the url " + url);
        }
//https://upload.wikimedia.org/wikipedia/commons/thumb/6/69/Flag_of_Minsk%2C_Belarus.svg/23px-Flag_of_Minsk%2C_Belarus.svg.png
        //#customers>tbody>tr>td
        ////*[@id="customers"]/tbody/tr[2]

        Elements images = document.select("table>tbody>tr>td>span>span>span>img");
        for (Element image : images) {
            String imageUrl = "https:" + image.attr("src");

            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            int index = 0;
            OutputStream os = new FileOutputStream(String.format("src/basic/images/%d.png",index++));

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        }
    }
}

