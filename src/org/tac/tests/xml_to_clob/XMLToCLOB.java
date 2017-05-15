package org.tac.tests.xml_to_clob;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Normalizer;

public class XMLToCLOB {

    final static String driverClass = "oracle.jdbc.driver.OracleDriver";
    final static String connectionURL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    final static String userID = "system";
    final static String userPassword = "oracle";
    final static String fileName = "./src/org/tac/tests/xml_to_clob/XMLToCLOB.xml";
    final static String outFileName = "./src/org/tac/tests/xml_to_clob/XMLToCLOB.xml.out";
    Connection connection = null;

    public XMLToCLOB() throws FileNotFoundException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName(driverClass).newInstance();
        connection = DriverManager.getConnection(connectionURL, userID, userPassword);
    }

    public void performWriteCLOBWorkarountForAsciiBrutto() throws SQLException, IOException {
        byte[] buffer = new byte[(int) new File(fileName).length()];
        BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(fileName));
        inputFile.read(buffer);
        String xmlString = new String(buffer,"ASCII");
        String result = Normalizer.normalize(xmlString, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        ByteArrayInputStream xmlStringStream = new ByteArrayInputStream(result.getBytes());
        
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AAA(ID,NOME,COGNOME,VALORE,CCLOB) VALUES(?,?,?,?,?)");
        preparedStatement.setInt(1, 10);
        preparedStatement.setString(2, "Test");
        preparedStatement.setString(3, "Test");
        preparedStatement.setInt(4, result.length());
        preparedStatement.setAsciiStream(5, xmlStringStream);
        preparedStatement.execute();
        connection.close();
        
    }

    public void performWriteBLOB() throws SQLException, IOException {
        BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream(fileName));

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AAA(ID,NOME,COGNOME,VALORE,BBLOB) VALUES(?,?,?,?,?)");
        preparedStatement.setInt(1, 10);
        preparedStatement.setString(2, "Test1");
        preparedStatement.setString(3, "Test1");
        preparedStatement.setInt(4, 40);
        preparedStatement.setBinaryStream(5, inputFile);
        preparedStatement.execute();
        connection.close();
    }

    public void performRead() throws FileNotFoundException, SQLException {   
    }

    public static void main(String[] args) throws java.lang.InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        XMLToCLOB xmlToCLOB = new XMLToCLOB();
        xmlToCLOB.performWriteCLOBWorkarountForAsciiBrutto();
        // xmlToCLOB.performWriteBLOB();
        xmlToCLOB.performRead();
    }
}