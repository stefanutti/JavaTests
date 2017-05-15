package org.tac.tests.xslt;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

public class XSLTTest {
    // Global value so it can be ref'd by the tree-adapter
    static Document document;

    public static void main(String[] argv) throws Exception {

        // Utils
        //
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        // XSL + creazione del Template XSL (compilazione)
        //
        File inputXSLFilePath = new File("./src/org/tac/tests/xslt/XSL-in.xsl");
        StreamSource xslStreamSource = new StreamSource(inputXSLFilePath);

        // Crea un Transformer
        //
        // Transformer transformer = transformerFactory.newTransformer(xslStreamSource);
        Templates templates = transformerFactory.newTemplates(xslStreamSource);
        Transformer transformer = templates.newTransformer();
        
        int counter = 0;
        while (true) {

            // do timing of standard approach
            long currtime = System.currentTimeMillis();

            for (int i = 0; i < 10; i++) {

                // In e out files
                //
                File inputXMLFilePath = new File("./src/org/tac/tests/xslt/XML-in.xml-" + i);
                File outFilePath = new File("./src/org/tac/tests/xslt/XML-out.xml-" + i);

                // DOM per l'input XML
                //
                document = builder.parse(inputXMLFilePath);
                DOMSource source = new DOMSource(document);

                // Lego uno stream al file di uscita
                //
                StreamResult result = new StreamResult(outFilePath);

                transformer.transform(source, result);
                transformer.clearParameters();
            }

            long elapsed = System.currentTimeMillis() - currtime;
            System.out.println("Debug: test number = " + counter + "time: " + elapsed);
            counter++;
        }
    }
}