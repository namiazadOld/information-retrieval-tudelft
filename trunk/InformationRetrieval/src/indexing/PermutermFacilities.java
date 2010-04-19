package indexing;

import java.util.ArrayList;
import java.util.List;

public final class PermutermFacilities {
	
	public static final char PERMUTERM_SYMBOL = '$';
	public static final char WILDCARD_SYMBOL = '*';
	public static List<String> producePermutermList(String term){

		List<String> result = new ArrayList<String>();
		term = PERMUTERM_SYMBOL + term;
		result.add(term);
		while (!term.endsWith(String.valueOf(PERMUTERM_SYMBOL))){
			result.add(term = term.substring(term.length() - 1) + term.substring(0, term.length() - 1));
		}
		return result;
	}
	
	public static String shiftWildCardToEnd(String input){
		
		if (input.lastIndexOf(WILDCARD_SYMBOL) != input.indexOf(WILDCARD_SYMBOL))
			throw new RuntimeException("more than one '*'");
		int wildCardIndex= input.indexOf(WILDCARD_SYMBOL) + 1;
		return  input.substring(wildCardIndex ) + PERMUTERM_SYMBOL + input.substring(0, wildCardIndex);
	}
	
	public static void main(String[] args)
	{
		String str = "Hello";
		
		System.out.println(producePermutermList(str));
		System.out.println(shiftWildCardToEnd("*las*edfgo"));
	}
}
