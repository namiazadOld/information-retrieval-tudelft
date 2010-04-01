/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author msenesi
 */
public class DocumentIndex implements Serializable {

    public static final char ENDING_CHAR = '$';
    private TreeMap<String, TermPosting> termPostings = new TreeMap<String, TermPosting>();
    //private ArrayList<Document> documents = new ArrayList<Document>();

    public static List<String> getPermutations(String token) {
        if (token == null) {
            return null;
        }

        token += ENDING_CHAR;

        List<String> result = new ArrayList<String>();
        result.add(token);
        for (int i = 1; i < token.length(); i++) {
            token = token.substring(1, token.length()) + token.charAt(0);
            result.add(token);
            System.out.println(token);
        }

        return result;

    }

    public void addToIndex(File txtFile, int docid) {
        try {
            // Token analyzer is simple scanner using several characters as delimitter
            TokenAnalyzer ta = new TokenAnalyzer(txtFile);
            String term = null;
            HashMap<String, Integer> terms = new HashMap<String, Integer>();

            while ((term = ta.getNextToken()) != null) {
                Integer tf = terms.get(term);
                if (tf == null) {
                    tf = new Integer(0);
                    terms.put(term, tf);
                }

                tf++;
            }            

            Iterator it = terms.keySet().iterator();
            //Document doc = new Document(docid);

            while (it.hasNext()) {
                term = (String) it.next();
                Integer termFrequency = terms.get(term);

                TermPosting tp = termPostings.get(term);
                if (tp == null) {
                    tp = new TermPosting(term);
                    termPostings.put(term, tp);
                }

                tp.postingList.put(docid, termFrequency);
                tp.termFrequencySum += termFrequency;
                tp.documentFrequency++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
