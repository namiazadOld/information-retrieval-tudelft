package indexing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.util.Version;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;


/**
 * LuceneIndexExample
 */
public class LuceneIndexExample
{
	@SuppressWarnings("deprecation")
	public static void indexFile (IndexWriter writer, File f){
		
		if (f.isHidden() || !f.exists() || !f.canRead()) 
			return;
		try{
			System.out.println("Indexing " + f.getCanonicalPath());
			Document doc = new Document();
			doc.add(new Field("contents", new FileReader(f)));
			doc.add(new Field("filename",f.getCanonicalPath(), Field.Store.YES, Field.Index.UN_TOKENIZED) );
			writer.addDocument(doc);
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void indexDirectory(IndexWriter writer, File dir){
    	File [] files = dir.listFiles();
    	for (int i = 0; i < files.length; i++) {
    		File f = files[i];
    		if (f.isDirectory()) {
    			indexDirectory(writer, f);
    		} else if (f.getName().endsWith(".txt")) {
    			indexFile(writer, f);
    		}
    	}
    }
	
	@SuppressWarnings("deprecation")
    public static int index ( File indexDir, File dataDir) {
    	
    	try{
        	IndexWriter writer = new IndexWriter(indexDir, new StandardAnalyzer(), true);
        	writer.setUseCompoundFile(false);
        	indexDirectory(writer, dataDir);
        	int numIndexed = writer.docCount();
        	writer.optimize();
        	writer.close();
        	return numIndexed;

    	}catch (IOException e){
    		e.printStackTrace();
    		return -1;
    	}
    }
    
	public static void main(String args[]) throws Exception
    {
        String text = "This is the text to index with Lucene:" +  " " 
        		+ "ot. The three pints all rodents swooping towards one of Betelgeuse trading scouts? Ford gave people of flying saucers, - came to end. As soon time quietness he as a shrug. - Keep the later and accompanied by a teaser. - said Majikthise, that had wanted axes. He said, what are Philosophers. - My name, - Charming man, and horror of looking so we known large friendly condescension, - said Arthur. - O Deep Thought, - Oh yes, a new voice, right? - No, the are people to the qualities" 
        		+ "Welcome to think about shadowy spherical shapes seemed to launch a moment, relax and the answer for sound of the Seventh uuuurgh splayed that that it says, - Nothing. - You mean was too at him. He twisted and has been great guys, - asked for the cabin, other direction a moment that most to the crab of blinding telling people didn't have speculated that lay a dog whistle. The reason finger on. - they turned her and been at something coms"
        		+ "figurehead - raged Ford. - Very deep, - And and thanks for a robot dead, and hurried back part of all the Betelgeuse trading scouts. Ford frowned. The mere a room their excitement. It is not her cabin. - You know, - protested Ford. - O Computer... - he noticed that any Earthman. - that related the floating soggily on down weather and then the old man before original version were reflected a system and horror he would just once faces down picture of a young Zaphod -"
        		+ "muscular expenditure of Pan Galactic Gargle Blasters; Ford hunted excitedly over nervously up if I'd dollars - Exactly where he intoned Deep Thought! - said the cabin. Ford's father, magnanimously waving his mind. There are very much, yes, - Come, - it's for a question which to get you to yellowness, consequences hypnotized second a large perspex block with Zaphod Beeblebrox? President? Many something, - warned Trillian. - said it and did without any monitor screens. met when she glanced be Computer full blast you"
        		+ "gang! - So? - It's And I stole it a passing out. God what inventing further after their know I decide to the punters' interest. Again came Betelgeuse and make any full title President of the fundamental fabric of any form I put in fact it rather single word yellow and the Question? - Yes, - he amazingly popular are something it later Ford carried round huge screen. Ford continued to I think it's few remaining differences in excess of the the hours to come"
        		;

        File indexDir = new File ("E:TU Delft/Information Retrival/Project/IR");
        File dataDir = new File ("E:/TU Delft/Information Retrival/Project/IR");
        
        int numIndexed = index(indexDir, dataDir);
        System.out.println("Indexing " + numIndexed + " files took "
        		 + " milliseconds");
        
//
//        String indexDir =
//            System.getProperty("java.io.tmpdir", "tmp") +
//            System.getProperty("file.separator") + "index-1";
//        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
//        boolean createFlag = true;
//        
//        File file = new File(indexDir);
//        Directory d = new SimpleFSDirectory(file);
//        
////        IndexWriter writer =
//  //          new IndexWriter( c indexDir, analyzer, createFlag);
//        IndexWriter writer = new IndexWriter(d, analyzer, createFlag, )
//        Document document  = new Document();
//        document.add(Field.Text("fieldname", text));
//        writer.addDocument(document);
//        writer.close();
    }
}