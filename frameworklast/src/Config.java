package xml;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Config{

    public static void writeXML() {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

        // élément de racine
            Document doc = docBuilder.newDocument();
            Element racine = doc.createElement("repertoire");
            doc.appendChild(racine);

        // l'élément contact
            Element contact = doc.createElement("contact");
            racine.appendChild(contact);

        // attributs de l'élément contact
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            contact.setAttributeNode(attr);

        // le nom
            Element nom = doc.createElement("nom");
            nom.appendChild(doc.createTextNode("codeur"));
            contact.appendChild(nom);

        // le prénom
            Element prenom = doc.createElement("prenom");
            prenom.appendChild(doc.createTextNode("java"));
            contact.appendChild(prenom);

        // le mobile
            Element mobile = doc.createElement("mobile");
            mobile.appendChild(doc.createTextNode("098745126"));
            contact.appendChild(mobile);

        // l'email
            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode("codeurjava8@gmail.com"));
            contact.appendChild(email);

        // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(new File("monFichier.xml"));

            transformer.transform(source, resultat);
            System.out.println("Fichier sauvegardé avec succès!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public static void readXML(String path, String nom1, String prenom1,String mobile1,String email1)throws Exception{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();

        File f = new File(path);
        Document doc = docBuilder.parse(f);
        NodeList nom = doc.getElementsByTagName("nom");
        nom.item(0).setTextContent(nom1);
        NodeList prenom = doc.getElementsByTagName("prenom");
        prenom.item(0).setTextContent(prenom1);
        NodeList mobile = doc.getElementsByTagName("mobile");
        mobile.item(0).setTextContent(mobile1);
        NodeList email = doc.getElementsByTagName("email");
        email.item(0).setTextContent(email1);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(f);

        transformer.transform(source, resultat);
        System.out.println(nom.item(0).getTextContent());
        // System.out.println(nom.item(0).getChildNodes().item(3).getTextContent());
        
    }
}

