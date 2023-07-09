package ar.com.sodhium.commons.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Utility for reading csv files line by line.
 * 
 * @author Sergio Maciorowski
 * 
 */
public class CsvReader {

    /**
     * Parse a csv file and returns a list with a line of the file in each
     * position.
     * 
     * @param filePath
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public List<String> getLineByLine(String filePath) throws NumberFormatException, IOException {
        CSVReader reader = new CSVReader(new FileReader(filePath), ';');
        List<String> list = new ArrayList<String>();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String line = "";
            for (String tempLine : nextLine) {
                line = line + tempLine + ",";
            }
            list.add(line.substring(0, line.length() - 1));
        }
        reader.close();
        return list;
    }

    /**
     * Parse a csv file and returns a list with a line of the file in each
     * position.
     * 
     * @param filePath
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public List<List<String>> getLines(String filePath) throws NumberFormatException, IOException {
        List<List<String>> records = new ArrayList<List<String>>();
        CSVReader csvReader = new CSVReader(new FileReader(filePath), ',');
        String[] values = null;
        while ((values = csvReader.readNext()) != null) {
            records.add(Arrays.asList(values));
        }
        csvReader.close();
        return records;
    }

    public List<List<Integer>> getIntegersMatrix(String filePath) throws NumberFormatException, IOException {
        ArrayList<List<Integer>> output = new ArrayList<>();
        List<String> lines = getLineByLine(filePath);
        for (String line : lines) {
            ArrayList<Integer> integersRow = new ArrayList<>();
            String[] nextTile = line.split(",");
            for (String tile : nextTile) {
                integersRow.add(Integer.valueOf(tile));
            }
            output.add(integersRow);
        }
        return output;
    }

    public List<List<Double>> getDoubleMatrix(String filePath) throws NumberFormatException, IOException {
        ArrayList<List<Double>> output = new ArrayList<>();
        List<String> lines = getLineByLine(filePath);
        for (String line : lines) {
            ArrayList<Double> integersRow = new ArrayList<>();
            String[] nextTile = line.split(",");
            for (String tile : nextTile) {
                integersRow.add(Double.valueOf(tile));
            }
            output.add(integersRow);
        }
        return output;
    }

    /**
     * Parse a csv file which contains only numbers and returns a list with a
     * value in each position, regardless of the number of lines in the file.
     * 
     * @param filePath
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public List<Integer> getAsIntegerList(String filePath) throws NumberFormatException, IOException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<Integer> tiles = new ArrayList<Integer>();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            String[] nextTile = nextLine[0].split(";");
            for (String tile : nextTile) {
                tiles.add(Integer.valueOf(tile));
            }
        }
        reader.close();
        return tiles;
    }
}
