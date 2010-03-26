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

query:  boolean_expr
     | 
     ;

boolean_expr:	or_expr (AND^ or_expr)* //	-> ^(AND or_expr+)
	;

or_expr :	atom (OR^ atom)* 	//-> ^(OR atom+)
	
	;
	
	
atom:     WORD
	| NOT^ atom 			//-> ^(NOT atom)			
	| '(' boolean_expr ')' 		-> boolean_expr 
	;

AND : 'and';
OR : 'or';
NOT : 'not'; 
WORD : ('a'..'z'|'A'..'Z'|'0'..'9')+ | ('"'('a'..'z'|'A'..'Z'|'0'..'9')+'"');
NEWLINE:'\r'? '\n' ;
WS  :   (' '|'\t')+ {skip();} ;
	
