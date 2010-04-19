package query;

import indexing.DocumentIndex;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import ranking.CosineRanker;

import antlr.TokenStream;

public class Query {

    private CommonTree tree;
    public static final boolean DEBUG = true;

//    public DocumentIndex index;
    private List<Integer> results;

    public static String translateToPostfixWildcard(String text) {
        int pos = -1;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '*') {
                pos = i;
                count++;
            }
        }

        if (count > 1) {
            if (DEBUG) {
                System.out.println(String.format("More than 1 wildcard char found in token '%s', removing all of them.", text));
            }
            count = 0;
            pos = -1;
            text = text.replaceAll("[*]", "");
        }

        text += DocumentIndex.ENDING_CHAR;

        if (count == 1) {
            String X = text.substring(0, pos + 1);
            String Y = text.substring(pos + 1, text.length());
            text = Y + X;
            assert (text.charAt(text.length() - 1) == '*');
        }

        return text;
    }
    
    public List<Integer> rankResult ()
    {
    	try {
    		if (results == null)
				getResult();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
	
//		for (Integer i: )
		return null;
    	
    }

    public Query(String query) throws RecognitionException {
//        this.index = index;
        query = query.trim().toLowerCase();
        query = query.replaceAll("[^a-zA-Z0-9() .\t]", "");

        QueryGrammarLexer lexer = new QueryGrammarLexer(new ANTLRStringStream(
                query));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QueryGrammarParser parser = new QueryGrammarParser(tokens);
        QueryGrammarParser.query_return r = parser.query();
        tree = (CommonTree) r.getTree();
    }

    // public Query(InputStream in) throws IOException, RecognitionException {
    // ANTLRInputStream input = new ANTLRInputStream(System.in);
    // QueryGrammarLexer lexer = new QueryGrammarLexer(new
    // ANTLRInputStream(in));
    // CommonTokenStream tokens = new CommonTokenStream(lexer);
    // QueryGrammarParser parser = new QueryGrammarParser(tokens);
    // QueryGrammarParser.query_return r = parser.query();
    // tree = (CommonTree)r.getTree();
    // }
    public String getQueryStr() throws RecognitionException {
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        QueryTransformer walker = new QueryTransformer(nodes);
        return walker.query();
    }

    // returns document ids
    public List<Integer> getResult() throws RecognitionException {
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        tree.getText();
        
        QueryExecuter walker = new QueryExecuter(nodes);
        org.antlr.runtime.TokenStream ts = nodes.getTokenStream();
//        QueryExecuter.index = index;
       
        results = walker.query();
        return results;

    }

    public void printAST() {
        System.out.println(tree.toStringTree());
    }

    public static void main(String[] args) throws Exception {
        // trim the input, insert and instead of spaces, lowercase

        File db = new File("reuters.db");
//        DocumentIndex index = null;
        
        if (!db.exists()) {
            System.out.print("Creating index...");
            DocumentIndex.instance().createIndex("reutersTXT/");
            DocumentIndex.instance().save("reuters.db");
            System.out.println("Done.");
        } else {
            System.out.print("Loading index...");
            DocumentIndex.instance().load("reuters.db");
            System.out.println("Done.");
        }

        String input = "not agriculture";
        Query q = new Query(input);

        
        //q.printAST();
        //System.out.println(q.getQueryStr());

// siamak ---------------------------------------------------------------------------------
        List<Integer> r = q.getResult();
        System.out.println(r);
        int k_top = 5;
        if(r.size() != 0){
        	System.out.println(CosineRanker.rankingResults(input, k_top, false));
            System.out.println(CosineRanker.rankingResults(input, k_top, true));
        }
        
        //System.out.println(q.rankResult());
// ---------------------------------------------------------------------------------
    }
}
