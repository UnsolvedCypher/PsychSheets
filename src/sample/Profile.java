package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.List;

public class Profile {
    private String WCAID;

    private void readPBs() {
        try {
            Document page = Jsoup.connect("https://www.worldcubeassociation.org/results/p.php?i=" + WCAID).get();
            Node resultsTable = page.getElementsByClass("results.table.tablecondensed").get(0);
            List<Node> pbRows = resultsTable.childNode(0).childNodes();
            // first 3 rows are titles, not actual pb rows
            if (pbRows.size() > 3) {
                for (Node row : pbRows.subList(3, pbRows.size())) {
                    String eventName = ((Element)row.childNode(0).childNode(0)).text();
                    String singlePBString = ((Element)row.childNode(2).childNode(0)).text();
                    String averagePBString = ((Element)row.childNode(2).childNode(0)).text();
                }
            }

        } catch (Exception e) {
            System.out.println("couldn't connect to WCA profile");
        }

    }
}
