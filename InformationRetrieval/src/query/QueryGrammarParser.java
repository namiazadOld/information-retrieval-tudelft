// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g 2010-03-26 15:56:25

package query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class QueryGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "WORD", "NOT", "NEWLINE", "WS", "'('", "')'"
    };
    public static final int WORD=6;
    public static final int WS=9;
    public static final int NEWLINE=8;
    public static final int T__11=11;
    public static final int T__10=10;
    public static final int OR=5;
    public static final int NOT=7;
    public static final int AND=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public QueryGrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public QueryGrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return QueryGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g"; }


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:1: query : ( boolean_expr | );
    public final QueryGrammarParser.query_return query() throws RecognitionException {
        QueryGrammarParser.query_return retval = new QueryGrammarParser.query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        QueryGrammarParser.boolean_expr_return boolean_expr1 = null;



        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:6: ( boolean_expr | )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=WORD && LA1_0<=NOT)||LA1_0==10) ) {
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
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:9: boolean_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_boolean_expr_in_query49);
                    boolean_expr1=boolean_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, boolean_expr1.getTree());

                    }
                    break;
                case 2 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:18:6: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "query"

    public static class boolean_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "boolean_expr"
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:20:1: boolean_expr : or_expr ( AND or_expr )* ;
    public final QueryGrammarParser.boolean_expr_return boolean_expr() throws RecognitionException {
        QueryGrammarParser.boolean_expr_return retval = new QueryGrammarParser.boolean_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND3=null;
        QueryGrammarParser.or_expr_return or_expr2 = null;

        QueryGrammarParser.or_expr_return or_expr4 = null;


        CommonTree AND3_tree=null;

        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:20:13: ( or_expr ( AND or_expr )* )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:20:15: or_expr ( AND or_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_or_expr_in_boolean_expr70);
            or_expr2=or_expr();

            state._fsp--;

            adaptor.addChild(root_0, or_expr2.getTree());
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:20:23: ( AND or_expr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:20:24: AND or_expr
            	    {
            	    AND3=(Token)match(input,AND,FOLLOW_AND_in_boolean_expr73); 
            	    AND3_tree = (CommonTree)adaptor.create(AND3);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND3_tree, root_0);

            	    pushFollow(FOLLOW_or_expr_in_boolean_expr76);
            	    or_expr4=or_expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, or_expr4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "boolean_expr"

    public static class or_expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "or_expr"
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:23:1: or_expr : atom ( OR atom )* ;
    public final QueryGrammarParser.or_expr_return or_expr() throws RecognitionException {
        QueryGrammarParser.or_expr_return retval = new QueryGrammarParser.or_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR6=null;
        QueryGrammarParser.atom_return atom5 = null;

        QueryGrammarParser.atom_return atom7 = null;


        CommonTree OR6_tree=null;

        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:23:9: ( atom ( OR atom )* )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:23:11: atom ( OR atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_or_expr89);
            atom5=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom5.getTree());
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:23:16: ( OR atom )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==OR) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:23:17: OR atom
            	    {
            	    OR6=(Token)match(input,OR,FOLLOW_OR_in_or_expr92); 
            	    OR6_tree = (CommonTree)adaptor.create(OR6);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR6_tree, root_0);

            	    pushFollow(FOLLOW_atom_in_or_expr95);
            	    atom7=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom7.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "or_expr"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:28:1: atom : ( WORD | NOT atom | '(' boolean_expr ')' -> boolean_expr );
    public final QueryGrammarParser.atom_return atom() throws RecognitionException {
        QueryGrammarParser.atom_return retval = new QueryGrammarParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WORD8=null;
        Token NOT9=null;
        Token char_literal11=null;
        Token char_literal13=null;
        QueryGrammarParser.atom_return atom10 = null;

        QueryGrammarParser.boolean_expr_return boolean_expr12 = null;


        CommonTree WORD8_tree=null;
        CommonTree NOT9_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        RewriteRuleTokenStream stream_10=new RewriteRuleTokenStream(adaptor,"token 10");
        RewriteRuleTokenStream stream_11=new RewriteRuleTokenStream(adaptor,"token 11");
        RewriteRuleSubtreeStream stream_boolean_expr=new RewriteRuleSubtreeStream(adaptor,"rule boolean_expr");
        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:28:5: ( WORD | NOT atom | '(' boolean_expr ')' -> boolean_expr )
            int alt4=3;
            switch ( input.LA(1) ) {
            case WORD:
                {
                alt4=1;
                }
                break;
            case NOT:
                {
                alt4=2;
                }
                break;
            case 10:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:28:11: WORD
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    WORD8=(Token)match(input,WORD,FOLLOW_WORD_in_atom117); 
                    WORD8_tree = (CommonTree)adaptor.create(WORD8);
                    adaptor.addChild(root_0, WORD8_tree);


                    }
                    break;
                case 2 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:29:4: NOT atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NOT9=(Token)match(input,NOT,FOLLOW_NOT_in_atom122); 
                    NOT9_tree = (CommonTree)adaptor.create(NOT9);
                    root_0 = (CommonTree)adaptor.becomeRoot(NOT9_tree, root_0);

                    pushFollow(FOLLOW_atom_in_atom125);
                    atom10=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom10.getTree());

                    }
                    break;
                case 3 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:30:4: '(' boolean_expr ')'
                    {
                    char_literal11=(Token)match(input,10,FOLLOW_10_in_atom134);  
                    stream_10.add(char_literal11);

                    pushFollow(FOLLOW_boolean_expr_in_atom136);
                    boolean_expr12=boolean_expr();

                    state._fsp--;

                    stream_boolean_expr.add(boolean_expr12.getTree());
                    char_literal13=(Token)match(input,11,FOLLOW_11_in_atom138);  
                    stream_11.add(char_literal13);



                    // AST REWRITE
                    // elements: boolean_expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 30:27: -> boolean_expr
                    {
                        adaptor.addChild(root_0, stream_boolean_expr.nextTree());

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_boolean_expr_in_query49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_expr_in_boolean_expr70 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_boolean_expr73 = new BitSet(new long[]{0x00000000000004C0L});
    public static final BitSet FOLLOW_or_expr_in_boolean_expr76 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_atom_in_or_expr89 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_OR_in_or_expr92 = new BitSet(new long[]{0x00000000000004C0L});
    public static final BitSet FOLLOW_atom_in_or_expr95 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_WORD_in_atom117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_atom122 = new BitSet(new long[]{0x00000000000004C0L});
    public static final BitSet FOLLOW_atom_in_atom125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_atom134 = new BitSet(new long[]{0x00000000000004C0L});
    public static final BitSet FOLLOW_boolean_expr_in_atom136 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_atom138 = new BitSet(new long[]{0x0000000000000002L});

}