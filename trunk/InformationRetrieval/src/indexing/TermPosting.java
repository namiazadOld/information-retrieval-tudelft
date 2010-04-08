/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package indexing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author msenesi
 */
public class TermPosting implements Comparable, Serializable {
    public String term;
    public int termFrequencySum;
    public int documentFrequency;
    public TreeMap<Integer, Integer> postingList;

    public TermPosting(String term) {
        this.term = term;
        this.termFrequencySum = 0;
        this.documentFrequency = 0;
        this.postingList = new TreeMap<Integer, Integer>();
    }


    /**
     * Assuming sorted lists
     * @param l1
     * @param l2
     * @return
     */
    public static ArrayList<Integer> andLists(ArrayList<Integer> l1, ArrayList<Integer> l2 ) {

        if (l1 == null || l2 == null || l1.size() <= 0 || l2.size() <= 0 ) return null;

        ArrayList<Integer> l = new ArrayList<Integer>();

        int idx1, idx2;
        idx1 = 0;
        idx2 = 0;

        if (l1.get(0) > l2.get(0)) {
            ArrayList<Integer> tmp = l1;
            l1 = l2;
            l2 = l1;
        }

        while (idx1 < l1.size() && idx2 < l2.size()) {
            while (l1.get(idx1) < l2.get(idx2) && idx1 < l1.size()) idx1++;
            if (l1.get(idx1) == l2.get(idx2)) {
                l.add(l1.get(idx1));
                idx1++;
                idx2++;
            }
        }

        return l;
    }


    @Override
    public int compareTo(Object o) {
        return term.compareTo(((TermPosting)o).term);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    

}
