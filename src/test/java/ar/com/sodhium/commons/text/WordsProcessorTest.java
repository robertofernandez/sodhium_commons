package ar.com.sodhium.commons.text;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordsProcessorTest {
    private WordsWeightManager wordsWeightManager;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        String[] suffixesArray = { "srl", "s.r.l.", "inc.", "inc", "corporation", "ltd.", "ltd", "llc", "l.l.c.",
                "group", "corp.", "corp", "llp", "l.l.p.", "co", "co.", "gmbh", "incorporated", "limited",
                "corporation", "limited", "liability", "partnership", "company", "studio", "studios" };

        String[] modifierssArray = { "solutions", "technologies", "solutions", "technologies", "systems",
                "international", "holdings", "consulting", "it", "technologies", "software", "systems", "tech",
                "services", "consulting", "digital", "innovations", "labs", "development", "media", "the", "associates",
                "state", "work" };

        HashMap<String, String> commonSuffixes = new HashMap<>();
        HashMap<String, String> commonModifiers = new HashMap<>();

        for (String suffix : suffixesArray) {
            commonSuffixes.put(suffix, suffix);
        }

        for (String modifier : modifierssArray) {
            commonModifiers.put(modifier, modifier);
        }

        wordsWeightManager = new WordsWeightManager() {
            @Override
            public Double getWeight(ChainedWordsBlock block, int index) {
                String text = block.getWords().get(index).getText();
                if (commonSuffixes.containsKey(text)) {
                    return 1D;
                }
                if (commonModifiers.containsKey(text)) {
                    return 4D;
                }
                return 10D;
            }
        };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetLongestCommonSequence() {
        Character[] separatorsArray = { ',', ';', ':', '-', '(', ')', '{', '}', '[', ']' };
        SeparatorsSet separators = new SeparatorsSet(separatorsArray, true);
        WordsProcessor processor = new WordsProcessor(separators);
        processor.setWordsWeightManager(wordsWeightManager);
        WeightedChainedWordsBlock sequence = processor.getLongestCommonSequence("Globant", "Globant");
        System.out.println(sequence);
        sequence = processor.getLongestCommonSequence("Globant", "Globant Inc.");
        System.out.println(sequence);
    }

    @Test
    public void testGetLongestCommonSequenceForCompanyNames() {
        Character[] separatorsArray = { ',', ';', ':', '-', '(', ')', '{', '}', '[', ']' };
        SeparatorsSet separators = new SeparatorsSet(separatorsArray, true);
        WordsProcessor processor = new WordsProcessor(separators);
        processor.setWordsWeightManager(wordsWeightManager);

        String[] companies = { "Globant", "Verizon", "Wizards of the Coast", "SightGain",
                "ITConnect Business Solutions", "Gabriela N. Smith, Legal Counsel | Asesora Legal", "DataSunrise, Inc.",
                "SOLUTIX S.A. [Soluciones de Recursos de TI]", "Active Countermeasures", "Kellwell Food Management",
                "DRIVING FORCE Vehicle Rentals, Sales and Leasing", "IBC - Industrial Supply Plus, Inc.",
                "Revenue Analytics, Inc.", "Quick18 Golf", "Automatski", "rjlinvestigations.com", "D2C Media Inc",
                "Baraka-Multi-Services", "Ridgeway Country Club", "Namu Travel Group", "SynergyCP", "Zipdev",
                "Cura Search", "Wave Reaction", "Bethel-Tate Local Schools", "Dti Publishing Corp", "CronJ",
                "Craters & Freighters National", "Grubhub Holdings Inc", "parkroad.tech",
                "Monticello Spring Corporation", "Florida State University Credit Union", "Rootstack", "ThirstySprout",
                "BetterPool", "InfiSense", "The ONE Group", "Narrativa", "BIZBUD", "ZENCOLORA� COMPANY, LLC",
                "Iris ID Systems Inc", "ActiveProspect", "MorganAsh", "RethinkFirst", "Bgood - Descubrí tu causa",
                "CodeScience", "easytechgreen", "lattice.co", "Gradiahealth", "Standard Express, Inc.",
                "C&R Electric, LLC", "Citizens", "assetc.com", "Hi-Tech Auto Repair", "LVT A�� LiveView Technologies",
                "Osoigo", "Aumni", "Breeze AirwaysA��", "NUVAsuite", "Scaled Agile, Inc.", "ACME",
                "Impel | Built on the XDC Network", "eResponders Inc.", "Proinit Consulting", "Boldcoachingstudio",
                "PREDICTif Solutions", "Hillstock & Associates, LLC", "Solospace", "0xWork Networks",
                "Consultare America LLC", "hubbl.ai", "BigRio", "Thrive Outdoors", "Validity Inc.", "Applica solutions",
                "Medius", "Sodhium work group" };

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
                "Verizon Inc.", "VERIZON", "Sodhium games studio", "Sodhium studio" };

        ArrayList<String> cleanComp1 = cleanRepetitions(companies);
        ArrayList<String> cleanComp2 = cleanRepetitions(companies2);

        ArrayList<String> notMatching = new ArrayList<>();
        int matchNumber = 1;
        for (String company : cleanComp2) {
            String bestMatch = getBestMatch(company, cleanComp1, processor);
            WeightedChainedWordsBlock longestCommonSequence = processor.getLongestCommonSequence(company.toLowerCase(),
                    bestMatch.toLowerCase());
            Double totalWeight = getTotalWeight(company, wordsWeightManager)
                    + getTotalWeight(bestMatch, wordsWeightManager);
            Double weightPercentage = 0D;
            if (totalWeight > 0D) {
                weightPercentage = (longestCommonSequence.getTotalWeight() / totalWeight) * 100D;
            }
            if (weightPercentage > 70) {
                System.out.println("[MATCH #" + (matchNumber++) + "] " + company + " -> " + bestMatch + " "
                        + weightPercentage + "% (" + longestCommonSequence + ")");
            } else if (weightPercentage > 0) {
                System.out.println("" + company + " -> " + bestMatch + " " + weightPercentage + "% ("
                        + longestCommonSequence + ")");
            } else {
                notMatching.add(company);
            }
        }
        System.out.print("Not matching: " + notMatching);
    }

    public Double getTotalWeight(String input, WordsWeightManager weightManager) {
        ChainedWordsBlock block = new ChainedWordsBlock(input);
        Double weight = 0D;
        for (int i = 0; i < block.getWords().size(); i++) {
            weight += weightManager.getWeight(block, i);
        }
        return weight;
    }

    private String getBestMatch(String name, ArrayList<String> otherNames, WordsProcessor processor) {
        WeightedChainedWordsBlock bestMatch = processor.getEmpyBlock();
        String output = "";
        for (String anotherName : otherNames) {
            WeightedChainedWordsBlock longestCommonSequence = processor.getLongestCommonSequence(name.toLowerCase(),
                    anotherName.toLowerCase());
            if (bestMatch.compareTo(longestCommonSequence) < 0) {
                bestMatch = longestCommonSequence;
                output = anotherName;
            }
        }
        return output;
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
