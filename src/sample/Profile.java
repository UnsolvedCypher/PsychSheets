package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;

public class Profile {
    public Profile(String WCAID) {
        this.WCAID = WCAID;
        readPbsAndName();
    }

    private String WCAID, name;
    private HashMap<String, Result> pbSingles = new HashMap<>();
    private HashMap<String, Result> pbAverages = new HashMap<>();

    public HashMap<String, Result> getPbSingles() {
        return pbSingles;
    }

    public HashMap<String, Result> getPbAverages() {
        return pbAverages;
    }

    private void readPbsAndName() {
        try {
            Document page = Jsoup.connect("https://www.worldcubeassociation.org/results/p.php?i=" + WCAID).get();
            page.select("h1").text();
            Element resultsTable = page.select("table.results.table.table-condensed").get(1);
            List<Element> pbRows = resultsTable.child(0).children();
            // first 3 rows are titles, not actual pb rows
            // it's possible someone has no PBs if they've DNFed every solve ever
            if (pbRows.size() > 3) {
                for (Element row : pbRows.subList(3, pbRows.size())) {
                    String eventName = Main.officialNameOf(row.child(0).text());
                    String singlePBString = row.select("td.R2").first().text();
                    String averagePBString = row.select("td.R2").get(1).text();

                    // this could use some cleanup
                    if (eventName.equals("3x3x3 Fewest Moves")) {
                        pbSingles.put(eventName, (singlePBString.equals("") ? null : new FMCResult(singlePBString)));
                        pbAverages.put(eventName, (averagePBString.equals("") ? null : new FMCResult(averagePBString)));
                    } else if (eventName.equals("3x3x3 Multi-Blind")) {
                        pbSingles.put(eventName, (singlePBString.equals("") ? null : new MultiResult(singlePBString)));
                        pbAverages.put(eventName, (averagePBString.equals("") ? null : new MultiResult(averagePBString)));
                    } else {
                        pbSingles.put(eventName, (singlePBString.equals("") ? null : new NormalResult(singlePBString)));
                        pbAverages.put(eventName, (averagePBString.equals("") ? null : new NormalResult(averagePBString)));
                    }
                }
            }
            System.out.println("done reading pbs");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("couldn't connect to WCA profile");
        }

    }
}
