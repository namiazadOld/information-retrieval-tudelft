// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g 2010-03-26 13:22:48

package query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class QueryGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "AND", "OR", "WORD", "NOT", "WS", "'('", "')'"
    };
    public static final int WORD=7;
    public static final int WS=9;
    public static final int NEWLINE=4;
    public static final int T__11=11;
    public static final int OR=6;
    public static final int T__10=10;
    public static final int NOT=8;
    public static final int AND=5;
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
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:1: query : boolean_expr ( NEWLINE )? ;
    public final QueryGrammarParser.query_return query() throws RecognitionException {
        QueryGrammarParser.query_return retval = new QueryGrammarParser.query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NEWLINE2=null;
        QueryGrammarParser.boolean_expr_return boolean_expr1 = null;


        CommonTree NEWLINE2_tree=null;

        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:6: ( boolean_expr ( NEWLINE )? )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:9: boolean_expr ( NEWLINE )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_boolean_expr_in_query49);
            boolean_expr1=boolean_expr();

            state._fsp--;

            adaptor.addChild(root_0, boolean_expr1.getTree());
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:22: ( NEWLINE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==NEWLINE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:16:22: NEWLINE
                    {
                    NEWLINE2=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_query51); 
                    NEWLINE2_tree = (CommonTree)adaptor.create(NEWLINE2);
                    adaptor.addChild(root_0, NEWLINE2_tree);


                    }
                    break;

            }

            System.out.println((boolean_expr1!=null?((CommonTree)boolean_expr1.tree):null).toStringTree());

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
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:19:1: boolean_expr : or_expr ( AND or_expr )* ;
    public final QueryGrammarParser.boolean_expr_return boolean_expr() throws RecognitionException {
        QueryGrammarParser.boolean_expr_return retval = new QueryGrammarParser.boolean_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND4=null;
        QueryGrammarParser.or_expr_return or_expr3 = null;

        QueryGrammarParser.or_expr_return or_expr5 = null;


        CommonTree AND4_tree=null;

        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:19:13: ( or_expr ( AND or_expr )* )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:19:15: or_expr ( AND or_expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_or_expr_in_boolean_expr68);
            or_expr3=or_expr();

            state._fsp--;

            adaptor.addChild(root_0, or_expr3.getTree());
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:19:23: ( AND or_expr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:19:24: AND or_expr
            	    {
            	    AND4=(Token)match(input,AND,FOLLOW_AND_in_boolean_expr71); 
            	    AND4_tree = (CommonTree)adaptor.create(AND4);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND4_tree, root_0);

            	    pushFollow(FOLLOW_or_expr_in_boolean_expr74);
            	    or_expr5=or_expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, or_expr5.getTree());

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
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:22:1: or_expr : atom ( OR atom )* ;
    public final QueryGrammarParser.or_expr_return or_expr() throws RecognitionException {
        QueryGrammarParser.or_expr_return retval = new QueryGrammarParser.or_expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR7=null;
        QueryGrammarParser.atom_return atom6 = null;

        QueryGrammarParser.atom_return atom8 = null;


        CommonTree OR7_tree=null;

        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:22:9: ( atom ( OR atom )* )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:22:11: atom ( OR atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_or_expr86);
            atom6=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom6.getTree());
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:22:16: ( OR atom )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==OR) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:22:17: OR atom
            	    {
            	    OR7=(Token)match(input,OR,FOLLOW_OR_in_or_expr89); 
            	    OR7_tree = (CommonTree)adaptor.create(OR7);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR7_tree, root_0);

            	    pushFollow(FOLLOW_atom_in_or_expr92);
            	    atom8=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom8.getTree());

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
    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:26:1: atom : ( WORD | NOT atom | '(' boolean_expr ')' -> boolean_expr );
    public final QueryGrammarParser.atom_return atom() throws RecognitionException {
        QueryGrammarParser.atom_return retval = new QueryGrammarParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WORD9=null;
        Token NOT10=null;
        Token char_literal12=null;
        Token char_literal14=null;
        QueryGrammarParser.atom_return atom11 = null;

        QueryGrammarParser.boolean_expr_return boolean_expr13 = null;


        CommonTree WORD9_tree=null;
        CommonTree NOT10_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree char_literal14_tree=null;
        RewriteRuleTokenStream stream_10=new RewriteRuleTokenStream(adaptor,"token 10");
        RewriteRuleTokenStream stream_11=new RewriteRuleTokenStream(adaptor,"token 11");
        RewriteRuleSubtreeStream stream_boolean_expr=new RewriteRuleSubtreeStream(adaptor,"rule boolean_expr");
        try {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:26:5: ( WORD | NOT atom | '(' boolean_expr ')' -> boolean_expr )
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
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:26:11: WORD
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    WORD9=(Token)match(input,WORD,FOLLOW_WORD_in_atom110); 
                    WORD9_tree = (CommonTree)adaptor.create(WORD9);
                    adaptor.addChild(root_0, WORD9_tree);


                    }
                    break;
                case 2 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:27:4: NOT atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NOT10=(Token)match(input,NOT,FOLLOW_NOT_in_atom116); 
                    NOT10_tree = (CommonTree)adaptor.create(NOT10);
                    root_0 = (CommonTree)adaptor.becomeRoot(NOT10_tree, root_0);

                    pushFollow(FOLLOW_atom_in_atom119);
                    atom11=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom11.getTree());

                    }
                    break;
                case 3 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:28:4: '(' boolean_expr ')'
                    {
                    char_literal12=(Token)match(input,10,FOLLOW_10_in_atom127);  
                    stream_10.add(char_literal12);

                    pushFollow(FOLLOW_boolean_expr_in_atom129);
                    boolean_expr13=boolean_expr();

                    state._fsp--;

                    stream_boolean_expr.add(boolean_expr13.getTree());
                    char_literal14=(Token)match(input,11,FOLLOW_11_in_atom131);  
                    stream_11.add(char_literal14);



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
                    // 28:25: -> boolean_expr
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


 

    public static final BitSet FOLLOW_boolean_expr_in_query49 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NEWLINE_in_query51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_expr_in_boolean_expr68 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_boolean_expr71 = new BitSet(new long[]{0x0000000000000580L});
    public static final BitSet FOLLOW_or_expr_in_boolean_expr74 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_atom_in_or_expr86 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_OR_in_or_expr89 = new BitSet(new long[]{0x0000000000000580L});
    public static final BitSet FOLLOW_atom_in_or_expr92 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_WORD_in_atom110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_atom116 = new BitSet(new long[]{0x0000000000000580L});
    public static final BitSet FOLLOW_atom_in_atom119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_atom127 = new BitSet(new long[]{0x0000000000000580L});
    public static final BitSet FOLLOW_boolean_expr_in_atom129 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_atom131 = new BitSet(new long[]{0x0000000000000002L});

}