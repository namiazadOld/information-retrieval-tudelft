tree grammar QueryExecuter;

options {
tokenVocab=QueryGrammar;
ASTLabelType=CommonTree;
}

@header {
package query;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import indexing.DocumentIndex;
import indexing.TermPosting;
}

@members{
public static DocumentIndex index = DocumentIndex.instance();
}

query returns [List<Integer> result]
     :  a=boolean_expr 	{ $result = a;}
     | 			{ $result = Collections.emptyList();}
     ;

boolean_expr returns [List<Integer> result]
        : ^(AND a=boolean_expr b=boolean_expr) 	{ $result = TermPosting.andLists(a, b); }                
	| ^(OR a=boolean_expr b=boolean_expr)	{ $result = TermPosting.orLists(a, b); }
	| ^(NOT a=boolean_expr) 		{ $result = TermPosting.notList(a); }
	| WORD 					{ $result = index.getTermPostingList($WORD.text); }
	;



