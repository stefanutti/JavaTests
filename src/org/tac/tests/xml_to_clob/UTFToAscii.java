package org.tac.tests.xml_to_clob;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.PreparedStatement;

public class UTFToAscii {

    private void perform() throws IOException {
        String inputFilePath = "./src/org/tac/tests/xml_to_clob/UTFToAscii.xml";
        String outFilePath = "./src/org/tac/tests/xml_to_clob/UTFToAscii-out.xml";
        byte[] buffer = new byte[(int) new File(inputFilePath).length()];
        BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(inputFilePath));
        inputFile.read(buffer);
        String xmlString = new String(buffer);
        
        Writer out = new OutputStreamWriter(new FileOutputStream(outFilePath),"ascii");
        out.write(xmlString);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        UTFToAscii utfToAscii = new UTFToAscii();
        utfToAscii.perform();
    }
}