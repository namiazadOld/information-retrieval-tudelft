grammar QueryGrammar;

options {
output=AST;
ASTLabelType=CommonTree; // type of $stat.tree ref etc...
}

@header {
package query;
}

@lexer::header {
package query;
}

@parser::members {

  @Override
  protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype, input);
  }

  @Override
  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
    throw e;
  }

}

@rulecatch {
    catch (RecognitionException e) {
        throw e;
    }
}

@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new IllegalArgumentException(e);
  }
}
  


query:  boolean_expr EOF
     | EOF
     ;

boolean_expr:	or_expr (AND^ or_expr)* //	-> ^(AND or_expr+)
	;

or_expr :	atom (OR^ atom)* 	//-> ^(OR atom+)
	;
	
	
atom:    WORD	
	| NOT^ atom 			//-> ^(NOT atom)			
	| '(' boolean_expr ')' 		-> boolean_expr 
	;
	


AND 	: 'and';
OR 	: 'or';
NOT 	: 'not'; 
WORD 	: ('*'|'a'..'z'|'A'..'Z'|'0'..'9')+;
NEWLINE	: '\r'? '\n' ;
WS  	: (' '|'\t')+ {skip();} ;
	
