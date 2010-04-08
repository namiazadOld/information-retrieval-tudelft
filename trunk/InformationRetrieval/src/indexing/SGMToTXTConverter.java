package indexing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SGMToTXTConverter {

    public static void main(String[] args) {
        String name = "reut2-%03d.xml";
        int docid = 0;
        for (int i = 0; i < 21; i++) {
            File sgmFile = new File("reutersSGM/" + String.format(name, i));

            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(sgmFile);
                doc.getDocumentElement().normalize();
                //System.out.println("Root element " + doc.getDocumentElement().getNodeName());
                NodeList nodeLst = doc.getElementsByTagName("REUTERS");
                //System.out.println("Information of all reuters");                

                for (int s = 0; s < nodeLst.getLength(); s++) {
                    docid++;
                    File txtFile = new File("reutersTXT/" + docid + ".txt");
                   
                    BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile));


                    Node fstNode = nodeLst.item(s);

                    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element fstElmnt = (Element) fstNode;
                        NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("TITLE");
                        Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                        NodeList fstNm = fstNmElmnt.getChildNodes();
                        //System.out.println("Title : " + ((Node) fstNm.item(0)).getNodeValue());
                        bw.write(((Node) fstNm.item(0)).getNodeValue());
                        bw.newLine();

                        try {
                        NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("BODY");
                        Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
                        NodeList lstNm = lstNmElmnt.getChildNodes();
                        //System.out.println("Body : " + ((Node) lstNm.item(0)).getNodeValue());

                        bw.write(((Node) lstNm.item(0)).getNodeValue());
                        } catch (Exception ex) {
                            //ex.printStackTrace();
                        }
                    }
                    bw.flush();
                    bw.close();

                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}


