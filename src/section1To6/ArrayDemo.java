package section1To6;

import java.util.ArrayList;

public class ArrayDemo {
	protected void testProtected() {
		System.out.println("test protected");
//		testClass();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		stringDemo n = new stringDemo();

		ArrayList a = new ArrayList();
//		Object obj = new Object();
//		ObjTesting ab = new ObjTesting();
//		Object obj = ab; // obj sẽ chỉ thẳng đến vị trí nhớ lưu giá trị của ab

//		 ab.name = "Khai";
//		 ab.property = "prop1";
//		 nên khi thay name và prop của ab thì giá trị của obj cũng thay đổi theo

		a.add("Khai 1");
		a.add("Khai 2");
		a.add("Khai 3");
		a.add("Khai 4");
		a.add("Khai 5");
		n.testClass();
		for (var val : a) {
			System.out.println(val);
		}
	}

}
