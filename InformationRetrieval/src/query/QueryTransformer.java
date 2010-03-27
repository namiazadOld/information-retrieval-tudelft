// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g 2010-03-27 21:00:33

package query;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QueryTransformer extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "WORD", "NOT", "NEWLINE", "WS", "'('", "')'"
    };
    public static final int WORD=6;
    public static final int WS=9;
    public static final int NEWLINE=8;
    public static final int T__11=11;
    public static final int OR=5;
    public static final int T__10=10;
    public static final int NOT=7;
    public static final int AND=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public QueryTransformer(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public QueryTransformer(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return QueryTransformer.tokenNames; }
    public String getGrammarFileName() { return "D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g"; }



    // $ANTLR start "query"
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:12:1: query returns [String query] : (a= boolean_expr | );
    public final String query() throws RecognitionException {
        String query = null;

        String a = null;


        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:13:6: (a= boolean_expr | )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=AND && LA1_0<=NOT)) ) {
                alt1=1;
            }
            else if ( (LA1_0==EOF) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:13:9: a= boolean_expr
                    {
                    pushFollow(FOLLOW_boolean_expr_in_query45);
                    a=boolean_expr();

                    state._fsp--;

                    query = a;

                    }
                    break;
                case 2 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:14:11: 
                    {
                    query = "";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return query;
    }
    // $ANTLR end "query"


    // $ANTLR start "boolean_expr"
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:17:1: boolean_expr returns [String query] : ( ^( AND a= boolean_expr b= boolean_expr ) | ^( OR a= boolean_expr b= boolean_expr ) | ^( NOT a= boolean_expr ) | WORD );
    public final String boolean_expr() throws RecognitionException {
        String query = null;

        CommonTree WORD1=null;
        String a = null;

        String b = null;


        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:18:9: ( ^( AND a= boolean_expr b= boolean_expr ) | ^( OR a= boolean_expr b= boolean_expr ) | ^( NOT a= boolean_expr ) | WORD )
            int alt2=4;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt2=1;
                }
                break;
            case OR:
                {
                alt2=2;
                }
                break;
            case NOT:
                {
                alt2=3;
                }
                break;
            case WORD:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:18:11: ^( AND a= boolean_expr b= boolean_expr )
                    {
                    match(input,AND,FOLLOW_AND_in_boolean_expr87); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr91);
                    a=boolean_expr();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr95);
                    b=boolean_expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     query = a + " AND " + b; 

                    }
                    break;
                case 2 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:19:4: ^( OR a= boolean_expr b= boolean_expr )
                    {
                    match(input,OR,FOLLOW_OR_in_boolean_expr105); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr109);
                    a=boolean_expr();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr113);
                    b=boolean_expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     query = a + " OR " + b; 

                    }
                    break;
                case 3 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:20:4: ^( NOT a= boolean_expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_boolean_expr122); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr126);
                    a=boolean_expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     query = "( NOT " + a + " )"; 

                    }
                    break;
                case 4 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryTransformer.g:21:4: WORD
                    {
                    WORD1=(CommonTree)match(input,WORD,FOLLOW_WORD_in_boolean_expr136); 
                     query = Query.translateToPostfixWildcard((WORD1!=null?WORD1.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return query;
    }
    // $ANTLR end "boolean_expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_boolean_expr_in_query45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_boolean_expr87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr91 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr95 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_boolean_expr105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr109 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr113 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_boolean_expr122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr126 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WORD_in_boolean_expr136 = new BitSet(new long[]{0x0000000000000002L});

}