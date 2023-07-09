package ar.com.sodhium.commons.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        System.out.println(StringUtils.capitalizeFirst("hola xx"));
        System.out.println(StringUtils.capitalizeFirst(" hola xx"));
        System.out.println(StringUtils.capitalizeFirst("Hola xx"));
        System.out.println(StringUtils.capitalizeFirst("h"));
        System.out.println(StringUtils.capitalizeFirst("H"));
        System.out.println(StringUtils.capitalizeFirst(""));

        System.out.println(StringUtils.lowCase("BUSINESS IT SR ANALYST"));
    }

    @Test
    public void testLimit() {
        System.out.println("1234567".substring(0, 5));
        System.out.println("1234567".length());
        System.out.println("12345".length());
    }

    @Test
    public void testTokens() {
        List<String> tokensFromPath = StringUtils.getTokensFromPath("/bot/testbot/status");
        System.out.println(tokensFromPath);
    }

    @Test
    public void testDistance() {
        String[] companies = { "Globant", "Verizon", "Wizards of the Coast", "SightGain",
                "ITConnect Business Solutions", "Gabriela N. Smith, Legal Counsel | Asesora Legal", "DataSunrise, Inc.",
                "SOLUTIX S.A. [Soluciones de Recursos de TI]", "Active Countermeasures", "Kellwell Food Management",
                "DRIVING FORCE Vehicle Rentals, Sales and Leasing", "IBC - Industrial Supply Plus, Inc.",
                "Revenue Analytics, Inc.", "Quick18 Golf", "Automatski", "rjlinvestigations.com", "D2C Media Inc",
                "Baraka-Multi-Services", "Ridgeway Country Club", "Namu Travel Group", "SynergyCP", "Zipdev",
                "Cura Search", "Wave Reaction", "Bethel-Tate Local Schools", "Dti Publishing Corp", "CronJ",
                "Craters & Freighters National", "Grubhub Holdings Inc", "parkroad.tech",
                "Monticello Spring Corporation", "Florida State University Credit Union", "Rootstack", "ThirstySprout",
                "BetterPool", "InfiSense", "The ONE Group", "Narrativa", "BIZBUD", "ZENCOLOR® COMPANY, LLC",
                "Iris ID Systems Inc", "ActiveProspect", "MorganAsh", "RethinkFirst", "Bgood - Descubrí tu causa",
                "CodeScience", "easytechgreen", "lattice.co", "Gradiahealth", "Standard Express, Inc.",
                "C&R Electric, LLC", "Citizens", "assetc.com", "Hi-Tech Auto Repair", "LVT — LiveView Technologies",
                "Osoigo", "Aumni", "Breeze Airways™", "NUVAsuite", "Scaled Agile, Inc.", "ACME",
                "Impel | Built on the XDC Network", "eResponders Inc.", "Proinit Consulting", "Boldcoachingstudio",
                "PREDICTif Solutions", "Hillstock & Associates, LLC", "Solospace", "0xWork Networks",
                "Consultare America LLC", "hubbl.ai", "BigRio", "Thrive Outdoors", "Validity Inc.", "Applica solutions",
                "Medius" };

        String[] companies2 = { "Huawei", "Prediktive", "TikTok", "SAP", "YouHelp.com", "The Twelve Thirty Club",
                "Wolfe", "I28 Technologies Corporation", "Dialpad", "Center for Vein Restoration", "Braintrust",
                "Highland Principals", "Emonics", "UST Xpanxion", "Allio Finance", "TechIntelli Solutions, Inc.",
                "LDT Technology", "Launchpad Technologies Inc.", "Farwest Aircraft, Inc.", "SportsBot.io",
                "Radiant.digital", "Formstack", "Avela", "UST Xpanxion", "Data Crunch", "Oowlish", "Teal Media", "WDG",
                "Leadstack Inc", "UnionHub", "Reftab LLC", "DUST Identity", "DUST Identity", "DUST Identity",
                "DUST Identity", "Corra", "DUST Identity", "DUST Identity", "DUST Identity", "DUST Identity",
                "DUST Identity", "DUST Identity", "Tactical Response Security Consulting Inc",
                "Admiral Security Services", "Gateway Group One", "Accenture Argentina", "SUS Global Enterprises LLC",
                "CARNEVALE", "Tier One Services, Inc", "Cozymeal", "Mitchell Distributing Leland",
                "Leland Saylor Associates", "Northrop Grumman", "Barnes &amp; Noble", "Adviters", "Airstack", "WorkCog",
                "Tata Consultancy Services", "Booz Allen Hamilton", "UST Xpanxion", "UST Xpanxion",
                "Booz Allen Hamilton", "NaviRetail", "GrantWriterTeam", "UST Xpanxion", "eHungry",
                "Zillion Technologies", "Augusta Precious Metals", "UST Xpanxion", "GEGI LLC", "DEPT�", "KPIT",
                "Walmart", "Hyve Solutions", "No-IP", "NexGen Technologies, Inc", "Dream World Partners, Inc.",
                "OPENMIND TECHNOLOGIES INC", "Data Crunch", "BCP", "ThunderYard", "MRC", "Hurricane Electric", "FBS",
                "Crunch Fitness", "BlueCloud Technologies", "Ecolab", "LUXOTTICA", "Cengage Group",
                "CR Fitness Holdings, LLC", "Orases", "Bain &amp; Company", "Global Commerce Media GmbH", "GE Aviation",
                "DirMOD", "Global Commerce Media GmbH", "DirMOD", "Oscar David Morales", "Bain &amp; Company",
                "Bain &amp; Company", "EY", "Perfect Patterns, Inc", "Strive Health", "Prime Machine", "Chime",
                "Teladoc Health", "Farmingdale State College", "Reyes Beverage Group", "Enbridge",
                "Rainbow Design Services", "Jobot", "Nansen Europe, Remote? $60k - $120k*", "EY",
                "Greater Omaha Packing Co., Inc", "KesarWeb", "Utility Relay Company LTD", "Chime", "Pest Share",
                "CEFCO Convenience Stores", "Teledyne Relays", "Locate Software", "Health In Tech, Inc", "Merican",
                "Jobot", "empirical", "EY", "Oldcastle BuildingEnvelope, Inc.", "excelon solutuion", "Chime",
                "Teladoc Health", "Northeast Power Coordinating Council, Inc.", "Reyes Beverage Group", "Jobot",
                "Jobot", "Able", "Jobot", "empirical", "Imedview, Inc", "PINNACLE Climate Technologies Inc",
                "Grupo Consultores de Empresas", "Qualitest", "Tangent UXD", "Chime", "Amplify Education, Inc.",
                "Versio", "WAE", "Leading Reach, Inc.", "Accenture Argentina", "Jobot", "Globant SRL", "Globant S.R.L.",
                "Verizon Inc.", "VERIZON" };

        ArrayList<String> cleanComp1 = cleanRepetitions(companies);
        ArrayList<String> cleanComp2 = cleanRepetitions(companies2);

        for (String company : cleanComp2) {
            String nearest = getNearest(company, cleanComp1);
            int distance = StringUtils.distance(company.toLowerCase(), nearest.toLowerCase());
            System.out.println("" + company + " -> " + nearest + " (distance: " + distance + ")");
        }

    }

    private String getNearest(String name, ArrayList<String> otherNames) {
        Integer distance = null;
        String nearest = null;
        for (String otherName : otherNames) {
            Integer newDistance = StringUtils.distance(name.toLowerCase(), otherName.toLowerCase());
            if (distance == null || distance.intValue() > newDistance.intValue()) {
                distance = newDistance;
                nearest = otherName;
            }
        }
        return nearest;
    }

    private ArrayList<String> cleanRepetitions(String[] names) {
        ArrayList<String> output = new ArrayList<>();
        HashMap<String, String> allnames = new HashMap<>();
        for (String name : names) {
            if (!allnames.containsKey(name)) {
                allnames.put(name, name);
                output.add(name);
            }
        }
        return output;
    }

}
