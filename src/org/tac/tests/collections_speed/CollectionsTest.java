package org.tac.tests.collections_speed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CollectionsTest {
	public int iLimit = 50000;
	long timingStart = 0l;
	long timingStop = 0l;
	
	private class AAA {
		int aaa = 100;
		String value = null;
		
		public AAA (String valueToSet) {
			value = valueToSet;
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		CollectionsTest collectionsTest = new CollectionsTest();
		collectionsTest.testCPUHashMap();
		collectionsTest.testCPUArrayList();
		collectionsTest.testCPULinkedList();

		Thread.sleep(20000);

		ArrayList<AAA> arrayList = collectionsTest.testMemoryArrayList();
		LinkedList<AAA> linkedList = collectionsTest.testMemoryLinkedList();
		
		Thread.sleep(990000000);
	}

	private void testCPUHashMap() {
		HashMap<String, String> hashMap = new HashMap<String, String>();

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit; i++) {
			hashMap.put("aaaaaaaaaa" + i, "123456789012345678901234123456789012345678901234123456789012345678901234");
		}
		timingStop = System.currentTimeMillis() - timingStart;
		System.out.println("Debug HasmMap.put: " + timingStop);

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit; i++) {
			hashMap.remove("aaaaaaaaaa" + i);
		}
		timingStop = System.currentTimeMillis() - timingStart;
		System.out.println("Debug HasmMap.remove: " + timingStop);
	}

	private void testCPUArrayList() {
		ArrayList<String> arrayList = new ArrayList<String>();

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit; i++) {
			arrayList.add("123456789012345678901234123456789012345678901234123456789012345678901234");
		}
		timingStop = System.currentTimeMillis() - timingStart;
		System.out.println("Debug arrayList.add: " + timingStop);

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit; i++) {
			arrayList.remove(0);
		}
		timingStop = System.currentTimeMillis() - timingStart;
		System.out.println("Debug arrayList.remove: " + timingStop);
	}

	private void testCPULinkedList() {
		LinkedList<String> linkedList = new LinkedList<String>();

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit; i++) {
			linkedList.add("123456789012345678901234123456789012345678901234123456789012345678901234");
		}
		timingStop = System.currentTimeMillis() - timingStart;
		System.out.println("Debug linkedList.add: " + timingStop);

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit; i++) {
			linkedList.remove(0);
		}
		timingStop = System.currentTimeMillis() - timingStart;
		System.out.println("Debug linkedList.remove: " + timingStop);
	}

	private ArrayList<AAA> testMemoryArrayList() {
		ArrayList<AAA> arrayList = new ArrayList<AAA>();

		for (int i = 0; i < iLimit * 10; i++) {
			AAA aaa = new AAA("123456789012345678901234123456789012345678901234123456789012345678901234" + i);
			arrayList.add(aaa);
		}

		System.out.println("Debug arrayList filled");

		return arrayList;
	}

	private LinkedList<AAA> testMemoryLinkedList() {
		LinkedList<AAA> linkedList = new LinkedList<AAA>();

		timingStart = System.currentTimeMillis();
		for (int i = 0; i < iLimit * 10; i++) {
			AAA aaa = new AAA("123456789012345678901234123456789012345678901234123456789012345678901234" + i);
			linkedList.add(aaa);
		}

		System.out.println("Debug linkedList filled");

		return linkedList;
	}
}
