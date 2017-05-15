package org.tac.tests.string_encoding;

import java.text.Normalizer;

public class StringEncoding {

	public static void main(String[] args) throws Exception
	{
        // ***
        //
	    String original = "prova אטלעש";
	    dumpString(original);
	    System.out.println("******************************************");

	    // ***
	    //
	    String asciiUsingStringConstructor = new String(original.getBytes("US-ASCII"));
        dumpString(asciiUsingStringConstructor);
        System.out.println("******************************************");

        // ***
        //
        StringBuffer asciiUsingCharByCharCheck = new StringBuffer();
        char[] theCharArrayOfTheString = original.toCharArray();
        for (int i = 0; i < theCharArrayOfTheString.length; i++) {
            if (theCharArrayOfTheString[i] > 128) {
                asciiUsingCharByCharCheck.append('?');
            }
            else {
                asciiUsingCharByCharCheck.append(theCharArrayOfTheString[i]);
            }
        }
        dumpString(asciiUsingCharByCharCheck.toString());
        System.out.println("******************************************");

        // ***
        //
        String asciiUsingNormalizer = Normalizer.normalize(original, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        dumpString(asciiUsingNormalizer);
        System.out.println("******************************************");

	}

    private static void dumpString(String stringToDump) {
        for (int i = 0; i < stringToDump.length(); i++) {
            System.out.println("valore di: " + stringToDump.charAt(i) + " is: " + (int)stringToDump.charAt(i));            
        }
    }
}
