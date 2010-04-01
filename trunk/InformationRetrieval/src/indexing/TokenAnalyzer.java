/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author msenesi
 */
public class TokenAnalyzer {

    private Scanner scanner;    
    /** An array containing some common English words that are not usually useful
    for searching. */
    public static final String[] STOP_WORDS = {
        "a", "and", "are", "as", "at", "be", "but", "by",
        "for", "if", "in", "into", "is", "it",
        "no", "not", "of", "on", "or", "s", "such",
        "t", "that", "the", "their", "then", "there", "these",
        "they", "this", "to", "was", "will", "with"
    };

    private static HashSet stopTable;

    public TokenAnalyzer(File txtFile) throws FileNotFoundException {
        // Token analyzer is simple scanner using several characters as delimitter
        scanner = new Scanner(txtFile);
        scanner.useDelimiter("[ |\\\"-_,\n\t?!;:<>{}\\[\\]=+/%$*&()']");
        if (stopTable == null) {
            stopTable = new HashSet();
            for (String stopWord : STOP_WORDS) {
                stopTable.add(stopWord);
            }
        }
    }

    public String getNextToken() {
        String term = null;
        boolean quit = false;
        while (!quit && scanner.hasNext()) {
            term = scanner.next().toLowerCase();
            term = term.replaceAll("[.]", "");

            if (!stopTable.contains(term)) {
                quit = true;
            }
        }

        return term;
    }
}
