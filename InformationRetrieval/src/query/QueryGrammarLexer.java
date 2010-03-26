// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g 2010-03-26 13:22:48

package query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QueryGrammarLexer extends Lexer {
    public static final int WORD=7;
    public static final int WS=9;
    public static final int NEWLINE=4;
    public static final int T__11=11;
    public static final int T__10=10;
    public static final int OR=6;
    public static final int NOT=8;
    public static final int AND=5;
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
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:31:5: ( 'and' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:31:7: 'and'
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
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:32:4: ( 'or' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:32:6: 'or'
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
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:33:5: ( 'not' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:33:7: 'not'
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
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:6: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ | ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '\"' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='\"') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
                    {
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
                    break;
                case 2 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:40: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '\"' )
                    {
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:40: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '\"' )
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:41: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ '\"'
                    {
                    match('\"'); 
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:34:44: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    match('\"'); 

                    }


                    }
                    break;

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
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:35:8: ( ( '\\r' )? '\\n' )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:35:9: ( '\\r' )? '\\n'
            {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:35:9: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:35:9: '\\r'
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
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:36:5: ( ( ' ' | '\\t' )+ )
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:36:9: ( ' ' | '\\t' )+
            {
            // D:\\eclipse\\workspace\\InformationRetrieval\\src\\query\\QueryGrammar.g:36:9: ( ' ' | '\\t' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
        int alt6=8;
        alt6 = dfa6.predict(input);
        switch (alt6) {
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


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\3\uffff\3\6\3\uffff\1\6\1\15\1\6\1\17\1\uffff\1\20\2\uffff";
    static final String DFA6_eofS =
        "\21\uffff";
    static final String DFA6_minS =
        "\1\11\2\uffff\1\156\1\162\1\157\3\uffff\1\144\1\60\1\164\1\60\1"+
        "\uffff\1\60\2\uffff";
    static final String DFA6_maxS =
        "\1\172\2\uffff\1\156\1\162\1\157\3\uffff\1\144\1\172\1\164\1\172"+
        "\1\uffff\1\172\2\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\6\1\7\1\10\4\uffff\1\4\1\uffff\1\3\1"+
        "\5";
    static final String DFA6_specialS =
        "\21\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\10\1\7\2\uffff\1\7\22\uffff\1\10\1\uffff\1\6\5\uffff\1\1"+
            "\1\2\6\uffff\12\6\7\uffff\32\6\6\uffff\1\3\14\6\1\5\1\4\13\6",
            "",
            "",
            "\1\11",
            "\1\12",
            "\1\13",
            "",
            "",
            "",
            "\1\14",
            "\12\6\7\uffff\32\6\6\uffff\32\6",
            "\1\16",
            "\12\6\7\uffff\32\6\6\uffff\32\6",
            "",
            "\12\6\7\uffff\32\6\6\uffff\32\6",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | AND | OR | NOT | WORD | NEWLINE | WS );";
        }
    }
 

}