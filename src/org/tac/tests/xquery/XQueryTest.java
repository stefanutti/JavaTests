package org.tac.tests.xquery;

import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.xquery.XQException;

import net.sf.saxon.Configuration;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.trans.XPathException;

public class XQueryTest {

    public static void main(String[] argv) throws Exception {
        TestA();
        TestB();
    }

    private static void TestA() throws XPathException {
        Configuration config = new Configuration();
        StaticQueryContext sqc = new StaticQueryContext(config);
        XQueryExpression exp = sqc.compileQuery("avg(for $i in 1 to 10 return $i*$i)");

        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);
        BigDecimal result = (BigDecimal)exp.evaluateSingle(dynamicContext);
        System.out.println(result);
    }

    private static void TestB() throws XPathException, XQException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Doe");

        PhoneNumber workPhone = new PhoneNumber();
        workPhone.setType("work");
        workPhone.setNumber("555-1111");
        customer.getPhoneNumbers().add(workPhone);

        PhoneNumber workPhone2 = new PhoneNumber();
        workPhone2.setType("casa");
        workPhone2.setNumber("555-2222");
        customer.getPhoneNumbers().add(workPhone2);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Customer> rootElement = new JAXBElement<Customer>(new QName("customer"), Customer.class, customer);
        marshaller.marshal(rootElement, System.out);
    }
}