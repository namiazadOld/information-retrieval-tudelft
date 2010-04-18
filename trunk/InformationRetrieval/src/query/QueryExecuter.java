// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g 2010-04-01 21:17:46

package query;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import indexing.DocumentIndex;
import indexing.TermPosting;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QueryExecuter extends TreeParser {
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


        public QueryExecuter(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public QueryExecuter(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return QueryExecuter.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g"; }


  //  public static DocumentIndex index;



    // $ANTLR start "query"
    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:22:1: query returns [List<Integer> result] : (a= boolean_expr | );
    public final List<Integer> query() throws RecognitionException {
        List<Integer> result = null;

        List<Integer> a = null;


        try {
            // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:23:6: (a= boolean_expr | )
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
                    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:23:9: a= boolean_expr
                    {
                    pushFollow(FOLLOW_boolean_expr_in_query50);
                    a=boolean_expr();

                    state._fsp--;

                     result = a;

                    }
                    break;
                case 2 :
                    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:24:11: 
                    {
                     result = Collections.emptyList();

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
        return result;
    }
    // $ANTLR end "query"


    // $ANTLR start "boolean_expr"
    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:27:1: boolean_expr returns [List<Integer> result] : ( ^( AND a= boolean_expr b= boolean_expr ) | ^( OR a= boolean_expr b= boolean_expr ) | ^( NOT a= boolean_expr ) | WORD );
    public final List<Integer> boolean_expr() throws RecognitionException {
        List<Integer> result = null;

        CommonTree WORD1=null;
        List<Integer> a = null;

        List<Integer> b = null;


        try {
            // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:28:9: ( ^( AND a= boolean_expr b= boolean_expr ) | ^( OR a= boolean_expr b= boolean_expr ) | ^( NOT a= boolean_expr ) | WORD )
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
                    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:28:11: ^( AND a= boolean_expr b= boolean_expr )
                    {
                    match(input,AND,FOLLOW_AND_in_boolean_expr92); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr96);
                    a=boolean_expr();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr100);
                    b=boolean_expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     result = TermPosting.andLists(a, b); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:29:4: ^( OR a= boolean_expr b= boolean_expr )
                    {
                    match(input,OR,FOLLOW_OR_in_boolean_expr126); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr130);
                    a=boolean_expr();

                    state._fsp--;

                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr134);
                    b=boolean_expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
                     result = TermPosting.orLists(a, b); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:30:4: ^( NOT a= boolean_expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_boolean_expr143); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_boolean_expr_in_boolean_expr147);
                    a=boolean_expr();

                    state._fsp--;


                    match(input, Token.UP, null); 
// siamak (no changes applied) --------------------------------------------------------------------------------------
                    result = TermPosting.notList(a);
                    //result = TermPosting.notList(a, index);
//--------------------------------------------------------------------------
                    }
                    break;
                case 4 :
                    // C:\\Users\\msenesi\\Documents\\NetBeansProjects\\InformationRetrieval\\src\\query\\QueryExecuter.g:31:4: WORD
                    {
                    WORD1=(CommonTree)match(input,WORD,FOLLOW_WORD_in_boolean_expr157); 
                     result = DocumentIndex.instance().getTermPostingList((WORD1!=null?WORD1.getText():null)); 

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
        return result;
    }
    // $ANTLR end "boolean_expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_boolean_expr_in_query50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_boolean_expr92 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr96 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr100 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_boolean_expr126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr130 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr134 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_boolean_expr143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolean_expr_in_boolean_expr147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WORD_in_boolean_expr157 = new BitSet(new long[]{0x0000000000000002L});

}