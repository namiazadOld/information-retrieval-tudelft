package soundex;
import indexing.DocumentIndex;
import indexing.TokenAnalyzer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Soundex { 
public static final char[] mapping ={
    //A  B   C   D   E   F   G   H   I   J   K   L   M
    '0','1','2','3','0','1','2','0','0','2','2','4','5',
    //N  O   P   W   R   S   T   U   V   W   X   Y   Z
    '5','0','1','2','6','2','3','0','1','0','2','0','2'
    };
    // Convert method replace strings with its soundex code
    public static String soundex(String s){
    //Change to upper case
    String u = s.toUpperCase();
    
    StringBuffer res = new StringBuffer();
    char c, prev ='?';
    for (int i=0 ; i< u.length() && res.length()<4 && ( c = u.charAt(i))!=',';i++ ){
    if(c>'A' && c< 'Z' && c != prev)
    {
    prev =c;
    // add first character to buffer
    if(i==0)
    	res.append(c);
    else
    {
    	 char m = mapping[c -'A'];
    	 if (m!='0')
         res.append(m);
    }
    }
    }
    if (res.length()== 0) 
    	return null;
    for (int i= res.length(); i<4 ; i++){
    	res.append(0);
    	return res.length.tostring();
    }
    public static void main(String[] args)
    {
    String[] name ={"Darwin, Ian",
      "Davidson, Greg",
      "Darwent, William",
      "Derwin, Daemon"};
      for (int i=0 ; i< names.length; i++)
      {
      System.out.println(Soundex.soundex (name[i])+ ' '+ name[i])
      }
    }
    }


}
