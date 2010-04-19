// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g 2010-04-19 12:49:23

package query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QueryGrammarLexer extends Lexer {
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

    public QueryGrammarLexer() {;} 
    public QueryGrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QueryGrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:7:7: ( '(' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:8:7: ( ')' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:8:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:50:6: ( 'and' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:50:8: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:51:5: ( 'or' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:51:7: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:52:6: ( 'not' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:52:8: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:53:7: ( ( '*' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:53:9: ( '*' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:53:9: ( '*' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:
            	    {
            	    if ( input.LA(1)=='*'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:54:9: ( ( '\\r' )? '\\n' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:54:11: ( '\\r' )? '\\n'
            {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:54:11: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:54:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:55:6: ( ( ' ' | '\\t' )+ )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:55:8: ( ' ' | '\\t' )+
            {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:55:8: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:8: ( T__10 | T__11 | AND | OR | NOT | WORD | NEWLINE | WS )
        int alt4=8;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:22: AND
                {
                mAND(); 

                }
                break;
            case 4 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:26: OR
                {
                mOR(); 

                }
                break;
            case 5 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:29: NOT
                {
                mNOT(); 

                }
                break;
            case 6 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:33: WORD
                {
                mWORD(); 

                }
                break;
            case 7 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:38: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 8 :
                // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:1:46: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\3\uffff\3\6\3\uffff\1\6\1\15\1\6\1\17\1\uffff\1\20\2\uffff";
    static final String DFA4_eofS =
        "\21\uffff";
    static final String DFA4_minS =
        "\1\11\2\uffff\1\156\1\162\1\157\3\uffff\1\144\1\52\1\164\1\52\1"+
        "\uffff\1\52\2\uffff";
    static final String DFA4_maxS =
        "\1\172\2\uffff\1\156\1\162\1\157\3\uffff\1\144\1\172\1\164\1\172"+
        "\1\uffff\1\172\2\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\6\1\7\1\10\4\uffff\1\4\1\uffff\1\3\1"+
        "\5";
    static final String DFA4_specialS =
        "\21\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\10\1\7\2\uffff\1\7\22\uffff\1\10\7\uffff\1\1\1\2\1\6\5\uffff"+
            "\12\6\7\uffff\32\6\6\uffff\1\3\14\6\1\5\1\4\13\6",
            "",
            "",
            "\1\11",
            "\1\12",
            "\1\13",
            "",
            "",
            "",
            "\1\14",
            "\1\6\5\uffff\12\6\7\uffff\32\6\6\uffff\32\6",
            "\1\16",
            "\1\6\5\uffff\12\6\7\uffff\32\6\6\uffff\32\6",
            "",
            "\1\6\5\uffff\12\6\7\uffff\32\6\6\uffff\32\6",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | AND | OR | NOT | WORD | NEWLINE | WS );";
        }
    }
 

}