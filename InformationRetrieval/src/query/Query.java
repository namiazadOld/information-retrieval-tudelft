package query;

import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class Query {
	private CommonTree tree;	
	
	public static final boolean DEBUG = true;
	public static final char SPECIAL_CHAR = '$';

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
		
		text += SPECIAL_CHAR;
		
		if (count == 1) {
			String X = text.substring(0, pos + 1);
			String Y = text.substring(pos + 1, text.length());
			text = Y + X;
			assert(text.charAt(text.length() - 1) == '*');
		} 		
		
		return text;
	}

	public Query(String query) throws RecognitionException {
		query = query.trim();
		// query = query.replaceAll("[ ]+", " and ");

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

	public void printAST() {
		System.out.println(tree.toStringTree());
	}

	public static void main(String[] args) throws IOException,
			RecognitionException {
		// trim the input, insert and instead of spaces, lowercase
		Query q = new Query("pet* or ot*to and not *picus and hannah");

		q.printAST();
		System.out.println(q.getQueryStr());		
	}
}
