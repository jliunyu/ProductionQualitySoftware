package edu.nyu.pqs.ps1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReaderWriter {

	AddressBook book=AddressBook.getInstance();


	/*
	 * This method writes all the entries present in the address book to an 
	 * XML file which is stored in the same directory by the name 
	 * AddressBook.xml
	 * @throws IOException 
	 * @throws ParserConfigurationException if the Parser is not configured 
	 * properly
	 * @throws TransformerException when Transformer encounters an error while 
	 * writing
	 * @throws IOException
	 */
	protected void XMLWrite (ArrayList<Entry> addressBook) 
			throws IOException, TransformerException, 
			ParserConfigurationException {

		DocumentBuilderFactory docFactory = 
				DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("AddressBook");
		doc.appendChild(rootElement);

		for (Entry entry : addressBook) {


			// Contact elements
			Element contact = doc.createElement("Contact");
			rootElement.appendChild(contact);

			// Name elements
			Element name = doc.createElement("Name");
			name.appendChild(doc.createTextNode(entry.getName()));
			contact.appendChild(name);

			// Address elements
			Element address = doc.createElement("Address");
			address.appendChild(doc.createTextNode(entry.getAddress()));
			contact.appendChild(address);

			// PhoneNo elements
			Element phoneNo = doc.createElement("PhoneNo");
			phoneNo.appendChild(doc.createTextNode(""+entry.getPhoneNo()));
			contact.appendChild(phoneNo);

			// Email elements
			Element email = doc.createElement("Email");
			email.appendChild(doc.createTextNode(entry.getEmail()));
			contact.appendChild(email);

			// Note elements
			Element note = doc.createElement("Note");
			note.appendChild(doc.createTextNode(entry.getNote()));
			contact.appendChild(note);

		}
		// write the content into xml file
		TransformerFactory transformerFactory = 
				TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File file = new File ("AddressBook.xml");
		file.delete();
		file.createNewFile();
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);

	}

	/*
	 * This method is used to read the entries from AddressBook.xml and 
	 * adds them back into the AddressBook
	 * @throws FileNotFoundException when the file to be loaded is not found
	 * @throws ParserConfigurationException if the Parser is not configured 
	 * properly
	 * @throws SAXExcecption if parse error occurs
	 * @throws IOException
	 */
	protected ArrayList<Entry> XMLRead() 
			throws IOException, SAXException, ParserConfigurationException,
			FileNotFoundException {

		File file = new File("AddressBook.xml");
		ArrayList<Entry> contactList = new ArrayList<Entry> ();

		// Reads the XML file and stores all the Contact elements in a NodeList
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);	
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("Contact");


		for (int i = 0; i < nodeList.getLength(); i++) {

			String name = "";
			String phoneNo = "";
			String address = "";
			String note = "";
			String email = "";

			// Picks each contact item from the NodeList which includes all the
			//details about the entry object
			Node entryNode = nodeList.item(i);

			for (int j = 0; j < entryNode.getChildNodes().getLength(); j++) {

				//Picks the child node from entryNode and check what is its 
				//node name. Then it stores the value in its corresponding variable

				Element childNode = (Element) entryNode.getChildNodes().
						item(j);

				if (childNode.getNodeName().equals("Name")) {
					name = childNode.getTextContent();
				} 
				else if (childNode.getNodeName().equals("Address")) {
					address = childNode.getTextContent();
				}
				else if (childNode.getNodeName().equals("PhoneNo")) {
					phoneNo = childNode.getTextContent();
				}
				else if (childNode.getNodeName().equals("Email")) {
					email = childNode.getTextContent();
				}
				else if (childNode.getNodeName().equals("Note")) {
					note = childNode.getTextContent();
				}

			}
			contactList.add(new Entry.EntryBuilder().name(name).
					address(address).phoneNo(Long.parseLong(phoneNo)).
					email(email).note(note).build());


		}

		return contactList;

	}

}
