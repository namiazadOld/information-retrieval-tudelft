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

@members {
protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
   throw new MismatchedTokenException(ttype, input);
}

public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
   throw e;
}
}

@rulecatch {
catch (RecognitionException e) {
   throw e;
}
}

query:  boolean_expr
     | 
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
	
