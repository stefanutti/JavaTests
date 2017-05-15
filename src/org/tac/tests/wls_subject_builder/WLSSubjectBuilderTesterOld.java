package org.tac.tests.wls_subject_builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.rmi.RemoteException;
import java.security.PrivilegedAction;
import java.util.Enumeration;

import javax.naming.Context;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import weblogic.jndi.Environment;
import weblogic.security.Security;
import weblogic.security.auth.Authenticate;

public class WLSSubjectBuilderTesterOld {

    public WLSSubjectBuilderTesterOld(String[] args) throws Exception {
        String username = null;
        int numberOfRunAs = 0;
        String password = null;
        String url = null;

        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "START");

        if (args.length < 1) {
            System.out.println("Usage: WLSSubjectBuilder [url] numberOfRunAs [username(optional)] [password(optional)]");
            System.out.println("Example: WLSSubjectBuilder t3://localhost:7001 numberOfRunAs system weblogic");
            System.exit(0);
        }

        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "Get parameters");
        switch (args.length) {
        case 4:
            password = args[3];
        case 3:
            username = args[2];
        case 2:
            url = args[0];
            numberOfRunAs = new Integer(args[1]).intValue();
            break;
        }

        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "Create subject!");
        Subject subject = new Subject();

        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "set Environment");
        Environment env = new Environment();
        env.setProviderUrl(url);
        env.setSecurityPrincipal(username);
        env.setSecurityCredentials(password);
        env.setProperty(Context.SECURITY_AUTHENTICATION, "Simple");

        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "BEFORE Authenticate.authenticate");
        Authenticate.authenticate(env, subject);
        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "AFTER Authenticate.authenticate");
        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "Time to check for open sockets");
        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "Press enter to continue");
        new BufferedReader(new InputStreamReader(System.in)).read();

        System.out.println("Debug: " + System.currentTimeMillis() + " - " + "PrivilegedAction");
        PrivilegedAction simpleAction = new DummyAction();

        for (int i = 0; i < numberOfRunAs; i++) {
            System.out.println("Debug: " + System.currentTimeMillis() + " - " + i + " - BEFORE Security.runAs");
            Security.runAs(subject, simpleAction);
            System.out.println("Debug: " + System.currentTimeMillis() + " - " + "AFTER Security.runAs");
            System.out.println("Debug: " + System.currentTimeMillis() + " - " + "Time to check for open sockets");
            System.out.println("Debug: " + System.currentTimeMillis() + " - " + "Press enter to continue");
            new BufferedReader(new InputStreamReader(System.in)).read();
        }

        System.out.println("Debug: END!" + " - " + System.currentTimeMillis());
        System.exit(0);
    }

    public class DummyAction implements PrivilegedAction {
        public Object run() {
            System.out.println("Debug: run!" + " - " + System.currentTimeMillis());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        WLSSubjectBuilderTesterOld wlsSubjectBuilder = new WLSSubjectBuilderTesterOld(args);
    }
}
