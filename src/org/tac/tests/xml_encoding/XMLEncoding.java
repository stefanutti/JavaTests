package org.tac.tests.xml_encoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;


public class XMLEncoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		DocumentBuilderFactory  docBuilderFartory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFartory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		Element rootElement = doc.createElement("root");
		doc.appendChild  (rootElement);

		Text text = doc.createTextNode("Pippo è pippa");
		rootElement.appendChild(text);

		// Node childNode = rootElement.cloneNode(true);
		// rootElement.appendChild(childNode);

		Source source = new DOMSource(doc);
		OutputStream os = new FileOutputStream("./src/org/tac/tests/xml_encoding/setAnagraficaPostazioni-UTF-8.xml");
		Result result = new StreamResult(os);

        InputStream inputXML = new FileInputStream("./src/org/tac/tests/xml_encoding/setAnagraficaPostazioni.xml");
        Source inputXMLSource = new StreamSource(inputXML);

        InputStream is = new FileInputStream("./src/org/tac/tests/xml_encoding/pippo.xsl");
		Source xslSource = new StreamSource(is);

		TransformerFactory transfFact = TransformerFactory.newInstance();
		// Transformer transformer = transfFact.newTransformer();
		Transformer transformer = transfFact.newTransformer(xslSource);

		// transformer.setOutputProperty("encoding", "UTF-8");
		// transformer.setOutputProperty("indent", "yes");

		transformer.transform(inputXMLSource, result);
		Properties outProps = transformer.getOutputProperties();

		Enumeration enumeration = outProps.keys();
		while (enumeration.hasMoreElements()) {
			Object key = enumeration.nextElement();
			System.out.println("" + key + "=" + outProps.get(key));
		}
	}

}
