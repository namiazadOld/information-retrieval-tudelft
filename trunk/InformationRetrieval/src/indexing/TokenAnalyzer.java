/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package indexing;

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
        "they", "this", "to", "was", "will"
    };
    private static HashSet stopTable;
    public static final String DOCUMENT_DELIMITER = "[ |\\\"\\-_,\r\n\t?!;:<>{}\\[\\]=+/%&()'" + PermutermFacilities.PERMUTERM_SYMBOL + "]+";
    
    static {
        stopTable = new HashSet();
        for (String stopWord : STOP_WORDS) {
            stopTable.add(stopWord);
        }
    }

    public TokenAnalyzer(File txtFile) throws FileNotFoundException {
        // Token analyzer is simple scanner using several characters as delimitter
        scanner = new Scanner(txtFile);
        scanner.useDelimiter(DOCUMENT_DELIMITER);
    }

// siamak ---------------------------------------------------------------------
    public TokenAnalyzer(String text){
        // Token analyzer is simple scanner using several characters as delimitter
        scanner = new Scanner(text);
        scanner.useDelimiter(DOCUMENT_DELIMITER);
    }
// ----------------------------------------------------------------------------
    
    public String getNextToken() {
        String term = null;
        boolean quit = false;
        while (!quit && scanner.hasNext()) {
            // all tokens to lowercase
            term = scanner.next().toLowerCase();
            // remove ., leave them only if it is a valid number
            try {
                Double.valueOf(term);
            } catch (Exception ex) {
                term = term.replaceAll("[.]", "");
            }

            // check against stoptable
            if (!stopTable.contains(term)) {
                quit = true;
            }
        }

        if(stopTable.contains(term) || term == null || term.matches("[ ]*"))
        	return null;
        
// siamak ------------------------------------------------------        
//        return term.contains(String.valueOf(PermutermFacilities.WILDCARD_SYMBOL))
//        			? PermutermFacilities.shiftWildCardToEnd(term)
//        			: term;
// ---------------------------------------------------
        return term;
    }
    
    public static boolean isStopWord(String term) {
    	term = term.replaceAll("" + PermutermFacilities.PERMUTERM_SYMBOL, "");
    	return stopTable.contains(term);
    }
}