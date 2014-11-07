import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Some costum edits to the files by SierraExport.java 
 * 
 * @author Feras Deiratany
 * 
 */
public final class FinalFixes {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private FinalFixes() {
    }

    private static void generateTextFile(PrintWriter out, List<String> l) {
        while (l.size() > 0) {
            out.println(l.remove(0));
        }
    }

    private static List<String> fix(BufferedReader in) throws IOException {
        List<String> l = new ArrayList<String>();
        String line = in.readLine();
        while (line != null) {
            if (!line.equals("AUTHOR = ") && !line.equals("TITLE = ")
                    && !line.equals("IMPRINT = ") && !line.equals("SUBJECT = ")
                    && !line.equals("EDITION = ")
//                    && !line.equals("SUBJECT = 490-00")
//                    && !line.equals("SUBJECT = 490-03")
//                    && !line.equals("SUBJECT = 490-04")
//                    && !line.equals("SUBJECT = 490-05")
//                    && !line.equals("SUBJECT = 490-06")
//                    && !line.equals("SUBJECT = 500-03")
//                    && !line.equals("SUBJECT = 500-04")
//                    && !line.equals("SUBJECT = 500-05")
//                    && !line.equals("SUBJECT = 500-06")
//                    && !line.equals("SUBJECT = 700-03")
//                    && !line.equals("SUBJECT = 700-04")
//                    && !line.equals("SUBJECT = 700-05")
//                    && !line.equals("SUBJECT = 700-06")
//                    && !line.equals("SUBJECT = 700-07")
//                    && !line.equals("SUBJECT = 700-08")
//                    && !line.equals("SUBJECT = 700-09")
//                    && !line.equals("SUBJECT = 700-10")
            ) {
//                l.add(line);
                if (line.contains("880-01")) {
                    line = line.replace("880-01", "AUTHOR = ");
                    l.add(line);
                } else if (line.contains("880-02")) {
                    line = line.replaceFirst("880-02", "TITLE = ");
                    l.add(line);
                } else if (line.contains("880-03")) {
                    line = line.replaceFirst("880-03", "IMPRINT = ");
                    l.add(line);
                } else if (line.contains("880-04")) {
                    line = line.replaceFirst("880-04", "IMPRINT = ");
                    l.add(line);
                } else if (line.contains("880-05")) {
                    line = line.replaceFirst("880-05", "SUBJECT = ");
                    l.add(line);
                } else if (line.contains("880-06")) {
                    line = line.replaceFirst("880-06", "SUBJECT = ");
                    l.add(line);
                } else if (line.contains("880-07")) {
                    line = line.replaceFirst("880-07", "SUBJECT = ");
                    l.add(line);
                } else if (line.contains("880-08")) {
                    line = line.replaceFirst("880-08", "SUBJECT = ");
                    l.add(line);
                } else if (line.contains("880-09")) {
                    line = line.replaceFirst("880-09", "SUBJECT = ");
                    l.add(line);
                } else if (line.contains("880-10")) {
                    line = line.replaceFirst("880-10", "SUBJECT = ");
                    l.add(line);
                } else if (line.contains("v.")) {
                    line = line.replaceFirst("v.", "VOLUME = v.");
                    l.add(line);
                    //Arabic lines
//          } else if (line.contains("100-01")) {
//              line = line.replaceFirst("100-01", "AUTHOR = ");
//              l.add(line);
//          } else if (line.contains("245-01")) {
//              line = line.replaceFirst("245-01", "TITLE = ");
//              l.add(line);
//          } else if (line.contains("245-02")) {
//              line = line.replaceFirst("245-02", "TITLE = ");
//              l.add(line);
//          } else if (line.contains("250-01")) {
//              line = line.replaceFirst("250-01", "EDITION = ");
//              l.add(line);
//          } else if (line.contains("250-02")) {
//              line = line.replaceFirst("250-02", "EDITION = ");
//              l.add(line);
//          } else if (line.contains("250-03")) {
//              line = line.replaceFirst("250-03", "EDITION = ");
//              l.add(line);
//          } else if (line.contains("250-04")) {
//              line = line.replaceFirst("250-04", "EDITION = ");
//              l.add(line);
//          } else if (line.contains("260-02")) {
//              line = line.replaceFirst("260-02", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("260-03")) {
//              line = line.replaceFirst("260-03", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("260-04")) {
//              line = line.replaceFirst("260-04", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("260-05")) {
//              line = line.replaceFirst("260-05", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("264-02")) {
//              line = line.replaceFirst("264-02", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("264-03")) {
//              line = line.replaceFirst("264-03", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("264-04")) {
//              line = line.replaceFirst("264-04", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("264-05")) {
//              line = line.replaceFirst("264-05", "IMPRINT = ");
//              l.add(line);
//          } else if (line.contains("600-03")) {
//              line = line.replaceFirst("600-03", "SUBJECT = ");
//              l.add(line);
//          } else if (line.contains("600-04")) {
//              line = line.replaceFirst("600-04", "SUBJECT = ");
//              l.add(line);
//          } else if (line.contains("600-05")) {
//              line = line.replaceFirst("600-05", "SUBJECT = ");
//              l.add(line);
//          } else if (line.contains("600-06")) {
//              line = line.replaceFirst("600-06", "SUBJECT = ");
//              l.add(line);
//          } else if (line.contains("600-07")) {
//              line = line.replaceFirst("600-07", "SUBJECT = ");
//              l.add(line);
//          } else if (line.contains("v.")) {
//              line = line.replaceFirst("v.", "VOLUME = v.");
//              l.add(line);
                } else if (line.contains("OCLC")) {
                    l.add(line);
                } else if (line.contains("CALL")) {
                    l.add(line);
                } else if (line.isEmpty()) {
                    l.add("");
                } else {
                    l.add("SUBJECT = " + line);
                }
            }
            line = in.readLine();

        }
        return l;
    }

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
         * Asks the user for the name of the input file to fix and for the name
         * of the fixed output file to be saved.
         */
        System.out.println("Enter the name of the input file to fix "
                + "\"ex: data/NameOfFile.txt\": ");
        String inFileName = in.nextLine();
        System.out.println("Enter the name of the fixed output file "
                + "\"ex: data/NameOfFile.txt\": ");
        String outFileName = in.nextLine();
        List<String> l;
        BufferedReader inFile;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));
            l = fix(inFile);
            inFile.close();
        } catch (IOException e) {
            System.err.println("Error oppening file");
            return;
        }
        /**
         * Generate txt file
         */
        PrintWriter outFile;
        try {
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(
                    outFileName)));
            generateTextFile(outFile, l);

            outFile.close();
        } catch (IOException e) {
            System.err.println("Error writing to file");
            return;
        }
    }
}
