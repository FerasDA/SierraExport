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
 * This code parses an exported Sierra file with delim[^@] and outputs an
 * organized text file.
 * 
 * @author Feras Deiratany
 * 
 */
public final class SierraExport {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private SierraExport() {
    }

    /**
     * Definition of caret and at separators.
     */
    private static final String SEPARATORS = "^@";
    /**
     * Definition of caret separator.
     */
    private static final String CARET = "^";

    /**
     * Definition of at separator.
     */
    private static final String AT = "@";

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code SEPARATORS}) or "separator string" (maximal length string of
     * characters in {@code SEPARATORS}) in the given {@code text} starting at
     * the given {@code position}.
     * 
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires <pre>
     * {@code 0 <= position < |text|}
     * </pre>
     * @ensures <pre>
     * {@code nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection entries(SEPARATORS) = {}
     * then
     *   entries(nextWordOrSeparator) intersection entries(SEPARATORS) = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection entries(SEPARATORS) /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of entries(SEPARATORS)  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of entries(SEPARATORS))}
     * </pre>
     */

    private static String separator(String text, int position) {
        assert text != null : "Violation of: text is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        int i = position;

        boolean testSep = SEPARATORS.contains(String.valueOf(text.charAt(i)));

        while (i < text.length()) {
            boolean test = SEPARATORS.contains(String.valueOf(text.charAt(i)));
            if (test == testSep) {
                i++;
            } else {
                return text.substring(position, i);
            }

        }
        return text.substring(position);
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code SEPARATORS}) or "separator string" (maximal length string of
     * characters in {@code SEPARATORS}) in the given {@code text} starting at
     * the given {@code position}.
     * 
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires <pre>
     * {@code 0 <= position < |text|}
     * </pre>
     * @ensures <pre>
     * {@code nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection entries(SEPARATORS) = {}
     * then
     *   entries(nextWordOrSeparator) intersection entries(SEPARATORS) = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection entries(SEPARATORS) /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of entries(SEPARATORS)  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of entries(SEPARATORS))}
     * </pre>
     */
    @SuppressWarnings("unused")
    private static String atSeparator(String text, int position) {
        assert text != null : "Violation of: text is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        int i = position;

        boolean testSep = AT.contains(String.valueOf(text.charAt(i)));

        while (i < text.length()) {
            boolean test = AT.contains(String.valueOf(text.charAt(i)));
            if (test == testSep) {
                i++;
            } else {
                return text.substring(position, i);
            }

        }
        return text.substring(position);
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code SEPARATORS}) or "separator string" (maximal length string of
     * characters in {@code SEPARATORS}) in the given {@code text} starting at
     * the given {@code position}.
     * 
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires <pre>
     * {@code 0 <= position < |text|}
     * </pre>
     * @ensures <pre>
     * {@code nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection entries(SEPARATORS) = {}
     * then
     *   entries(nextWordOrSeparator) intersection entries(SEPARATORS) = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection entries(SEPARATORS) /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of entries(SEPARATORS)  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of entries(SEPARATORS))}
     * </pre>
     */
    @SuppressWarnings("unused")
    private static String caretSeparator(String text, int position) {
        assert text != null : "Violation of: text is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        int i = position;

        boolean testSep = CARET.contains(String.valueOf(text.charAt(i)));

        while (i < text.length()) {
            boolean test = CARET.contains(String.valueOf(text.charAt(i)));
            if (test == testSep) {
                i++;
            } else {
                return text.substring(position, i);
            }

        }
        return text.substring(position);
    }

    /**
     * Returns a list of List<String>'s which has all separated lists.
     * 
     * @param in
     *            the in stream.
     * @return the return value of the list.
     * @throws IOException
     *             IO exception.
     */
    private static List<List<String>> all(BufferedReader in) throws IOException {
        assert in != null : "Violation of: in is not null";
        assert in.ready() : "Violation of: in.is_open";

        List<List<String>> allLists = new ArrayList<List<String>>();

        String line = in.readLine();
        while (line != null) {
            allLists.add(oneListOfFields1(line));
            line = in.readLine();
        }
        return allLists;
    }

    /**
     * Returns a list of Strings that has all the fields separated.
     * 
     * @param line
     *            line from a field.
     * @return the return value of the list.
     */
    private static List<String> oneListOfFields1(String line) {
        List<String> l = new ArrayList<String>();

        int i = 0;
        while (i < line.length()) {
            String field = separator(line, i);
            if (!CARET.contains(String.valueOf(field.charAt(0)))) {
                if (!AT.contains(String.valueOf(field.charAt(0)))) {
                    l.add(field);
                }
            }
            i = i + field.length();
        }
        return l;
    }

    /**
     * Generates the text file.
     * 
     * @param out
     *            the output stream.
     * @param lof
     *            the list of lists to be outputted.
     */
    private static void generateTextFile(PrintWriter out, List<List<String>> lof) {

        while (lof.size() > 0) {
            List<String> l = lof.remove(0);
            String oclc = l.remove(0).toString();
            out.println("OCLC # = " + oclc + ".");
            String call = l.remove(0).toString();
            out.println("CALL # = " + call + ".");
            while (l.size() > 0) {
                String field = l.remove(0).toString();
                out.println(field);
                //English fields
//                if (field.contains("880-01")) {
//                    field = field.replaceFirst("880-01", "AUTHOR = ");
//                    out.println(field);
//                } else if (field.contains("880-02")) {
//                    field = field.replaceFirst("880-02", "TITLE = ");
//                    out.println(field);
//                } else if (field.contains("880-03")) {
//                    field = field.replaceFirst("880-03", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("880-04")) {
//                    field = field.replaceFirst("880-04", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("880-05")) {
//                    field = field.replaceFirst("880-05", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("880-06")) {
//                    field = field.replaceFirst("880-06", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("880-07")) {
//                    field = field.replaceFirst("880-07", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("880-08")) {
//                    field = field.replaceFirst("880-08", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("880-09")) {
//                    field = field.replaceFirst("880-09", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("880-10")) {
//                    field = field.replaceFirst("880-10", "SUBJECT = ");
//                    out.println(field);
//                    //Arabic fields
//                } else if (field.contains("100-01")) {
//                    field = field.replaceFirst("100-01", "AUTHOR = ");
//                    out.println(field);
//                } else if (field.contains("245-01")) {
//                    field = field.replaceFirst("245-01", "TITLE = ");
//                    out.println(field);
//                } else if (field.contains("245-02")) {
//                    field = field.replaceFirst("245-02", "TITLE = ");
//                    out.println(field);
//                } else if (field.contains("250-01")) {
//                    field = field.replaceFirst("250-01", "EDITION = ");
//                    out.println(field);
//                } else if (field.contains("250-02")) {
//                    field = field.replaceFirst("250-02", "EDITION = ");
//                    out.println(field);
//                } else if (field.contains("250-03")) {
//                    field = field.replaceFirst("250-03", "EDITION = ");
//                    out.println(field);
//                } else if (field.contains("250-04")) {
//                    field = field.replaceFirst("250-04", "EDITION = ");
//                    out.println(field);
//                } else if (field.contains("260-02")) {
//                    field = field.replaceFirst("260-02", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("260-03")) {
//                    field = field.replaceFirst("260-03", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("260-04")) {
//                    field = field.replaceFirst("260-04", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("260-05")) {
//                    field = field.replaceFirst("260-05", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("264-02")) {
//                    field = field.replaceFirst("264-02", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("264-03")) {
//                    field = field.replaceFirst("264-03", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("264-04")) {
//                    field = field.replaceFirst("264-04", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("264-05")) {
//                    field = field.replaceFirst("264-05", "IMPRINT = ");
//                    out.println(field);
//                } else if (field.contains("600-03")) {
//                    field = field.replaceFirst("600-03", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("600-04")) {
//                    field = field.replaceFirst("600-04", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("600-05")) {
//                    field = field.replaceFirst("600-05", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("600-06")) {
//                    field = field.replaceFirst("600-06", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("600-07")) {
//                    field = field.replaceFirst("600-07", "SUBJECT = ");
//                    out.println(field);
//                } else if (field.contains("v.")) {
//                    field = field.replaceFirst("v.", "VOLUME = v.");
//                    out.println(field);
//                } else {
//                    out.println("SUBJECT = " + field);
//                }
            }
            out.println();

        }
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
         * Asks the user for the name of the input file and for the name of the
         * output file to be saved.
         */
        System.out.println("Enter the name of the input file "
                + "\"ex: data/NameOfFile.txt\": ");
        String inFileName = in.nextLine();
        System.out.println("Enter the name of the output file "
                + "\"ex: data/NameOfFile.txt\": ");
        String outFileName = in.nextLine();
        List<List<String>> lof;
        BufferedReader inFile;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));
            lof = all(inFile);
            System.out.println(lof.size());
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
            generateTextFile(outFile, lof);

            outFile.close();
        } catch (IOException e) {
            System.err.println("Error writing to file");
            return;
        }
    }
}
