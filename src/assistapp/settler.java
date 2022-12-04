package assistapp;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class settler {
	public static void SetToXml(Person person) {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	try {
	//
	String filepath = "main.xml";
	builder = factory.newDocumentBuilder();
	Document doc = builder.parse(filepath);
	//Document doc = builder.newDocument();
	//root
	//Element rootElement = doc.createElementNS("personaldata", "Persons");
	Node rootElement = doc.getFirstChild();
	//doc.appendChild(rootElement);
	rootElement.appendChild(getPerson(doc, person));
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	DOMSource source = new DOMSource(doc);
	StreamResult console = new StreamResult(System.out);
	StreamResult file = new StreamResult(new File("main.xml"));
	transformer.transform(source, console);
	transformer.transform(source, file);
	System.out.println("Action with XML completed");
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	private static Node getPerson(Document doc, Person person) {
	Element pers = doc.createElement("Person");
	pers.setAttribute("id", Integer.toString(person.id));
	pers.appendChild(getPersonElement(doc, pers, "name", person.name));
	pers.appendChild(getPersonElement(doc, pers, "sname", person.sname)); 
	pers.appendChild(getPersonElement(doc, pers, "lang", person.lang)); 
	pers.appendChild(getPersonElement(doc, pers, "gender", person.gender)); 
	pers.appendChild(getPersonElement(doc, pers, "birthday", Integer.toString(person.birthday)));
	pers.appendChild(getPersonElement(doc, pers, "birthmonth", Integer.toString(person.birthmonth)));
	pers.appendChild(getPersonElement(doc, pers, "birthyear", Integer.toString(person.birthyear))); 
	pers.appendChild(getPersonElement(doc, pers, "createdate", person.createdate.toString())); 
	return pers;
	}

	private static Node getPersonElement(Document doc, Element element, String name, String value) {
	Element node = doc.createElement(name);
	node.appendChild(doc.createTextNode(value));
	return node;
	}
}

