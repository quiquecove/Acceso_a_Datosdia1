package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class node_to_array {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("PersonaSerie.xml");
			NodeList personList = doc.getElementsByTagName("persona");

			for (int i = 0; i < personList.getLength(); i++) {
				Node p = personList.item(i);
				if (p.getNodeType() == Node.ELEMENT_NODE) {
					Element persona = (Element) p;
					NodeList nameList = persona.getChildNodes();
					for (int j = 0; j < nameList.getLength(); j++) {
						Node n = nameList.item(j);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element nombre = (Element) n;
							if (nombre.getNodeName().equals("nombre")) {
								System.out.println("Persona: " + nombre.getTextContent());
							} else if (nombre.getNodeName().equals("serie_favorita")) {
								System.out.println("Serie Favorita: " + nombre.getTextContent());
							}
							System.out.println();
							System.out.println("Eso es todo");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
