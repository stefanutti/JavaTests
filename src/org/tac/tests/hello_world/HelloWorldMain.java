package org.tac.tests.hello_world;

public class HelloWorldMain {
	public static void main(String[] args) {

		HelloWorld helloWorld = new HelloWorld("Hi there");

		System.out.println("Debug: " + helloWorld.getMessage());
	}
}
