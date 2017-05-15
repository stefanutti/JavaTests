package org.tac.tests.test_jmx;

import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.AttributeChangeNotification;

public class MyListener implements NotificationListener {

    public  void handleNotification(Notification notification, Object obj) {

        if(notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification attributeChange =
                     (AttributeChangeNotification) notification;
            System.out.println("This notification is an AttributeChangeNotification");
            System.out.println("Observed Attribute: " + attributeChange.getAttributeName() );
            System.out.println("Old Value: " + attributeChange.getOldValue() );
            System.out.println("New Value: " + attributeChange.getNewValue() );
        }
    }
}