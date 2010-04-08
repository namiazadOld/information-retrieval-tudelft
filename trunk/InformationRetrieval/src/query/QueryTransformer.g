tree grammar QueryTransformer;

options {
tokenVocab=QueryGrammar;
ASTLabelType=CommonTree;
}

@header {
package query;
}

query returns [String query]
     :  a=boolean_expr 	{$query = a;}
     | 			{$query = "";}
     ;

boolean_expr returns [String query]
        : ^(AND a=boolean_expr b=boolean_expr) 	{ $query = a + " AND " + b; }
	| ^(OR a=boolean_expr b=boolean_expr)	{ $query = a + " OR " + b; }
	| ^(NOT a=boolean_expr) 		{ $query = "( NOT " + a + " )"; }
	| WORD 					{ $query = Query.translateToPostfixWildcard($WORD.text); }
	;

