package org.tac.tests.test_jmx;

import java.util.Hashtable;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.MalformedObjectNameException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;

import javax.management.NotificationFilterSupport;

public class TestJMX {
    private static MBeanServerConnection connection;
    private static JMXConnector connector;
    private static final ObjectName service;

    // Initialize the object name for RuntimeServiceMBean
    // so it can be used throughout the class.
    static {
        try {
            service = new ObjectName("com.bea:Name=RuntimeService,Type=weblogic.management.mbeanservers.runtime.RuntimeServiceMBean");
        } catch (MalformedObjectNameException e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /*
     * Initialize connection to the Runtime MBean Server. This MBean is the root of the runtime MBean hierarchy, and each server in the domain hosts its own instance.
     */
    public static void initConnection(String hostname, String portString, String username, String password) throws IOException, MalformedURLException {
        String protocol = "t3";
        Integer portInteger = Integer.valueOf(portString);
        int port = portInteger.intValue();
        String jndiroot = "/jndi/";
        String mserver = "weblogic.management.mbeanservers.runtime";
        JMXServiceURL serviceURL = new JMXServiceURL(protocol, hostname, port, jndiroot + mserver);

        Hashtable h = new Hashtable();
        h.put(Context.SECURITY_PRINCIPAL, username);
        h.put(Context.SECURITY_CREDENTIALS, password);
        h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote");
        connector = JMXConnectorFactory.connect(serviceURL, h);
        connection = connector.getMBeanServerConnection();
    }

    public static void main(String[] args) throws Exception {
        String hostname = args[0];
        String portString = args[1];
        String username = args[2];
        String password = args[3];

        try {
            /*
             * Invokes a custom method that establishes a connection to the Runtime MBean Server and uses an instance of MBeanServerConnection to represents the connection. The custom method assigns the MBeanServerConnection to a class-wide, static variable named "connection".
             */
            initConnection(hostname, portString, username, password);

            // Creates and registers the timer MBean.
            ObjectName timerON = new ObjectName("mycompany:Name=myDailyTimer,Type=weblogicTimer");
            String classname = "weblogic.management.timer.Timer";
            connection.createMBean(classname, timerON);
            System.out.println("===> created timer mbean " + timerON);

            // Configures the timer MBean to emit a morning notification.
            // Assigns the return value of addNotification to a variable so that
            // it will be possible to invoke other operations for this specific
            // notification.
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(java.util.Calendar.HOUR_OF_DAY, 9);
            java.util.Date morning = cal.getTime();
            String myData = "Timer notification";
            Integer morningTimerID = (Integer) connection.invoke(timerON, "addNotification", new Object[] { "mycompany.timer.notification.after9am", "After 9am!", myData, morning, new Long(300000) }, new String[] { "java.lang.String", "java.lang.String", "java.lang.Object", "java.util.Date", "long" });

            // Instantiates your listener class and configures a filter to
            // forward only timer messages.
            MyListener listener = new MyListener();
            NotificationFilterSupport filter = new NotificationFilterSupport();
            filter.enableType("mycompany.timer");

            // Uses the MBean server's addNotificationListener method to
            // register the listener and filter with the timer MBean.
            System.out.println("===> ADD NOTIFICATION LISTENER TO " + timerON);
            connection.addNotificationListener(timerON, listener, filter, null);
            System.out.println("\n[myListener]: Listener registered ...");

            // Starts the timer.
            connection.invoke(timerON, "start", new Object[] {}, new String[] {});

            // Keeps the remote client active.
            System.out.println("Pausing. Press Return to end...........");
            System.in.read();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
    }
}