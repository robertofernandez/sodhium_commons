package ar.com.sodhium.commons.strings;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChangeCases {

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
    public void fromConstantsToVars() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("WCS_API_CONFIGURATION_FILE");
        inputs.add("SERVER_CONFIGURATION_FILE");
        inputs.add("SKILLS_INFORMATION_FILE");
        inputs.add("OFFBOARDING_EVENTS_FILE");
        inputs.add("EVENTS_SKILLS_FILE");
        inputs.add("JOB_OPPORTUNITIES_FILE");
        inputs.add("KEYWORDS_TRANSLATION_FILE");
        inputs.add("SITE_SEARCHES_FILE");
        inputs.add("USED_POSTS_FILE");
        inputs.add("HISTORY_FOLDER");
        inputs.add("SEARCHES_HISTORY_FOLDER");
        inputs.add("HISTORY_FILE_SUFFIX");

        for (String input : inputs) {
            System.out.println(fromConstantToVar(input));
        }
    }

    @Test
    public void fromConstantsToSetters() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("WCS_API_CONFIGURATION_FILE");
        inputs.add("SERVER_CONFIGURATION_FILE");
        inputs.add("SKILLS_INFORMATION_FILE");
        inputs.add("OFFBOARDING_EVENTS_FILE");
        inputs.add("EVENTS_SKILLS_FILE");
        inputs.add("JOB_OPPORTUNITIES_FILE");
        inputs.add("KEYWORDS_TRANSLATION_FILE");
        inputs.add("SITE_SEARCHES_FILE");
        inputs.add("USED_POSTS_FILE");
        inputs.add("HISTORY_FOLDER");
        inputs.add("SEARCHES_HISTORY_FOLDER");
        inputs.add("HISTORY_FILE_SUFFIX");

        for (String input : inputs) {
            System.out.println("serverFilesConfiguration.set" + fromConstantToCamel(input) + "(" + input + ");");
        }
    }

    private String fromConstantToVar(String input) {
        String[] splitted = input.split("_");
        String output = "";
        int i = 0;
        for (String piece : splitted) {
            i++;
            if (i == 1) {
                output += piece.toLowerCase();
            } else {
                output += capitalize(piece);
            }
        }
        return output;
    }

    private String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1, input.length()).toLowerCase();
    }

    private String fromConstantToCamel(String input) {
        String[] splitted = input.split("_");
        String output = "";
        for (String piece : splitted) {
            output += capitalize(piece);
        }
        return output;
    }

}
