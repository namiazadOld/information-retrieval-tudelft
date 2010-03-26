package query;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class Query {
	private CommonTree tree;
	private QueryGrammarLexer lexer;
	
	public Query(String query) throws RecognitionException {
        QueryGrammarLexer lexer = new QueryGrammarLexer(new ANTLRStringStream(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
        QueryGrammarParser parser = new QueryGrammarParser(tokens);
        QueryGrammarParser.query_return r = parser.query();
        tree = (CommonTree)r.getTree();
	}
	
	public Query(InputStream in) throws IOException, RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		QueryGrammarLexer lexer = new QueryGrammarLexer(new ANTLRInputStream(in));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
        QueryGrammarParser parser = new QueryGrammarParser(tokens);
        QueryGrammarParser.query_return r = parser.query();
        tree = (CommonTree)r.getTree();
	}
	
	public String getQueryStr() {
		return null;
		
	}
	
	public void printAST() {
		System.out.println(tree.toStringTree());
	}
	
	public static void main(String[] args) throws IOException, RecognitionException {
		// trim the input, insert and instead of spaces, lowercase
		Query q = new Query("peter and kamil and");
//		
//        CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		q.printAST();
        System.out.println(q.getQueryStr());
//        Eval walker = new Eval(nodes);
//        walker.prog();
	}
}
