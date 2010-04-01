
public class SGMToTXTConverter {
	
	public static void main(String[] args) {
		String name = "reut2-%03d.sgm";
		for (int i = 0; i < 21; i++) {
			File sgmFile = new File("reutersSGM/" + String.format(name, i));
			
			try {				  
				  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				  DocumentBuilder db = dbf.newDocumentBuilder();
				  Document doc = db.parse(sgmFile);
				  doc.getDocumentElement().normalize();
				  System.out.println("Root element " + doc.getDocumentElement().getNodeName());
				  NodeList nodeLst = doc.getElementsByTagName("REUTERS");
				  System.out.println("Information of all reuters");

				  for (int s = 0; s < nodeLst.getLength(); s++) {

				    Node fstNode = nodeLst.item(s);
				    
				    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
				  
				           Element fstElmnt = (Element) fstNode;
				      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("TITLE");
				      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
				      NodeList fstNm = fstNmElmnt.getChildNodes();
				      System.out.println("First Name : "  + ((Node) fstNm.item(0)).getNodeValue());
				      NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("BODY");
				      Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
				      NodeList lstNm = lstNmElmnt.getChildNodes();
				      System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());
				    }

				  }
				  } catch (Exception e) {
				    e.printStackTrace();
				  }
				 }
		}
	}

}
