package assistapp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class reader {
	public static ArrayList<Person> GetFromXml() {
		String filepath = "main.xml";
		File xmlFile = new File(filepath);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try 
{
builder = factory.newDocumentBuilder();
Document doc = builder.parse(xmlFile);
doc.getDocumentElement().normalize();
System.out.println("root: " + doc.getDocumentElement().getNodeName());
NodeList nodeList = doc.getElementsByTagName("Person");
System.out.println(nodeList.getLength());
ArrayList<Person> persList = new ArrayList<Person>();
for (int i = 0; i < nodeList.getLength(); i++) {
persList.add(getPersona(nodeList.item(i)));}
for (Person person : persList) {
System.out.println(person.toString());}
ArrayList<Person> reverse = manager.reverseList(persList);
return reverse;
}
catch (Exception exc) {
exc.printStackTrace();
return null;}
}
private static Person getPersona(Node node) {
Person person = new Person();
if (node.getNodeType() == Node.ELEMENT_NODE) {
Element element = (Element) node;
person.name=getTagValue("name", element);
person.sname=getTagValue("sname", element);
person.gender=getTagValue("gender", element);
person.lang=getTagValue("lang", element);
person.id=Integer.parseInt(element.getAttribute("id"));
person.birthday=Integer.parseInt(getTagValue("birthday", element));
person.birthmonth=Integer.parseInt(getTagValue("birthmonth", element));
person.birthyear=Integer.parseInt(getTagValue("birthyear", element));
}
return person;}
	
private static String getTagValue(String tag, Element element) {
NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
Node node = (Node) nodeList.item(0);
return node.getNodeValue();}
}

