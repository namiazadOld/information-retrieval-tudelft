/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package indexing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author msenesi
 */
public class DocumentIndex implements Serializable {

    public static final char ENDING_CHAR = '$';
    private TreeMap<String, TermPosting> termPostings = new TreeMap<String, TermPosting>();
    

    //private ArrayList<Document> documents = new ArrayList<Document>();

// siamak --------------------------------------------------------------------------
    //public static TreeSet<Integer> documentIds = new TreeSet<Integer>();
    public static TreeMap<Integer, Integer> document_IDs_And_Lenghts = new TreeMap<Integer, Integer>();
// --------------------------------------------------------------------------

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
        }

        return result;

    }

    // returns all document in which term appears
    public List<Integer> getTermPostingList(String term) {
        if (term == null) return Collections.emptyList();
        TermPosting tp = termPostings.get(term);
        if (tp == null) return Collections.emptyList();

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(tp.postingList.keySet());

        return result;
    }


    public void add(File txtFile, int docid) {
// siamak --------------------------------------------------------------------------
        int numberOfTokens = 0;
//--------------------------------------------------------------------------
        try {
            // Get terms frequencies within document
            TokenAnalyzer ta = new TokenAnalyzer(txtFile);

            String term = null;
            HashMap<String, Integer> terms = new HashMap<String, Integer>();

            while ((term = ta.getNextToken()) != null) {
                Integer tf = terms.get(term);
                if (tf == null) {
                    tf = new Integer(0);
                }

                tf++;
                terms.put(term, tf);
                
                numberOfTokens ++;
            }

// siamak --------------------------------------------------------------------------
            //documentIds.add(docid);
            document_IDs_And_Lenghts.put(docid, numberOfTokens);
//--------------------------------------------------------------------------


            // Store information in index
            Iterator it = terms.keySet().iterator();
            //Document doc = new Document(docid);
            while (it.hasNext()) {
                term = (String) it.next();
                Integer termFrequency = terms.get(term);

                TermPosting tp = termPostings.get(term);
                if (tp == null) {
                    tp = new TermPosting(term);
                }
                

                tp.postingList.put(docid, termFrequency);
                tp.termFrequencySum += termFrequency;
                tp.documentFrequency++;
                termPostings.put(term, tp);
            }

// siamak --------------------------------------------------------------------------
            this.updateWeights();
// --------------------------------------------------------------------------            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
// siamak ------------------------------------------------------------------------
    public void updateWeights(){
    	
    	if(this.termPostings.isEmpty()){
    		System.out.println("Term postiong Empty");
    		return;
    	}
    	
    	for (TermPosting tp: termPostings.values()){
    		
    		for (Integer i: tp.postingListOfWeights.keySet()){
    			//tf-idf weights
        		tp.postingListOfWeights.put(i, ( 1 + Math.log10(tp.postingListOfWeights.get(i)) )
        				* Math.log10(tp.termFrequencySum/tp.postingListOfWeights.size()) );
    			
    		}
    	}
    		
    } 
//--------------------------------------------------
    


    public static DocumentIndex createIndex(String dirWithTxtArticles) {
        // Build index over reutersTXT articles collection
        File reutersDir = new File(dirWithTxtArticles);
        File[] docs = reutersDir.listFiles();

        DocumentIndex index = new DocumentIndex();

        for (File f : docs) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                String name = f.getName().substring(0, f.getName().indexOf('.'));
                Integer docid = Integer.parseInt(name);
                index.add(f, docid);
            }
        }
        
        

        return index;
    }

    public static DocumentIndex load(String fname) throws Exception {
        FileInputStream fin = null;
        ObjectInputStream in = null;
        fin = new FileInputStream(fname);
        in = new ObjectInputStream(fin);
        DocumentIndex index = (DocumentIndex) in.readObject();
        in.close();
        return index;
    }

    public void save(String fname) throws Exception {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        fos = new FileOutputStream(fname);
        out = new ObjectOutputStream(fos);
        out.writeObject(this);
        out.close();
    }

//    public static void main(String[] args) throws Exception {
//
//        //getPermutations("test");
//
//        File db = new File("reuters.db");
//        DocumentIndex index = null;
//        if (!db.exists()) {
//            System.out.print("Creating index...");
//            index = DocumentIndex.createIndex("reutersTXT/");
//            index.save("reuters.db");
//            System.out.println("Done.");
//        } else {
//            System.out.print("Loading index...");
//            index = DocumentIndex.load("reuters.db");
//            System.out.println("Done.");
//        }
//
//    }
}