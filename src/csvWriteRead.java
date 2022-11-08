import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class csvWriteRead {

    private static final String COMMA = ",";
    private static final String DEFAULT_SEPARATOR = COMMA;
    private static final String DOUBLE_QUOTES = "\"";
    private static final String EMBEDDED_DOUBLE_QUOTES = "\"\"";
    private static final String NEW_LINE_UNIX = "\n";
    private static final String NEW_LINE_WINDOWS = "\r\n";

    static File f = new File("tools");
    // Get the absolute path of file f
    static String absolute = f.getAbsolutePath();
    private static final String CSV_FILE_PATH = absolute+"\\csvfile.csv";


    public static void main(String[] args) throws IOException {

        csvWriteRead writer = new csvWriteRead();
        writer.writeToCsvFile(createCsvDataSpecial(), new File(CSV_FILE_PATH));
        System.out.println("Read Data Line by Line With Header \n");
        readAllDataAtOnce(CSV_FILE_PATH);
    }

    public String convertToCsvFormat(final String[] line) {
        return convertToCsvFormat(line, DEFAULT_SEPARATOR);
    }

    public String convertToCsvFormat(final String[] line, final String separator) {
        return convertToCsvFormat(line, separator, true);
    }

    // if quote = true, all fields are enclosed in double quotes
    public String convertToCsvFormat(
            final String[] line,
            final String separator,
            final boolean quote) {

        return Stream.of(line)                              // convert String[] to stream
                .map(l -> formatCsvField(l, quote))         // format CSV field
                .collect(Collectors.joining(separator));    // join with a separator

    }

    // put your extra login here
    private String formatCsvField(final String field, final boolean quote) {

        String result = field;

        if (result.contains(COMMA)
                || result.contains(DOUBLE_QUOTES)
                || result.contains(NEW_LINE_UNIX)
                || result.contains(NEW_LINE_WINDOWS)) {

            // if field contains double quotes, replace it with two double quotes \"\"
            result = result.replace(DOUBLE_QUOTES, EMBEDDED_DOUBLE_QUOTES);

            // must wrap by or enclosed with double quotes
            result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;

        } else {
            // should all fields enclosed in double quotes
            if (quote) {
                result = DOUBLE_QUOTES + result + DOUBLE_QUOTES;
            }
        }

        return result;

    }

    // a standard FileWriter, CSV is a normal text file
    private void writeToCsvFile(List<String[]> list, File file) throws IOException {

        List<String> collect = list.stream()
                .map(this::convertToCsvFormat)
                .collect(Collectors.toList());

        // CSV is a normal text file, need a writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : collect) {
                bw.write(line);
                bw.newLine();
            }
        }

    }

    private static List<String[]> createCsvDataSpecial() {

        String[] header = {"Make", "Model", "Description", "Price"};
        String[] record1 = {"Dell", "P3421W", "Dell 34, Curved, USB-C Monitor", "2499.00"};
        String[] record2 = {"Dell", "", "Alienware 38 Curved \"Gaming Monitor\"", "6699.00"};
        String[] record3 = {"Samsung", "", "49\" Dual QHD, QLED, HDR1000", "6199.00"};
        String[] record4 = {"Samsung", "", "Promotion! Special Price\n49\" Dual QHD, QLED, HDR1000", "4999.00"};
        String[] record5 = {"RealMe", "50\" Dual QHD, QLED, HDR1000", "70000"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);
        list.add(record3);
        list.add(record4);
        list.add(record5);
        return list;

    }

    public static void readAllDataAtOnce(String file)
    {
        try {

            // Create an object of filereader class
            // with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object
            // and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");

                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


