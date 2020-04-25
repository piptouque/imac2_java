
package fr.umlv.exo1;

class A {
	int x = 1;

	public int getX() { return x; }
	int m(A a) { return 1; }

	static void printX(A a) {
		System.out.println("In A.printX");
		System.out.println("x " + a.x);
		System.out.println("getX() " + a.getX());
	}

}

class B extends A {
	int x = 2;

	public int getX() { return x; }
	int m(B b) { return 2; }

	static void printX(B b) {
		System.out.println("in B.printX");
		System.out.println("x " + b.x);
		System.out.println("getX() " + b.getX());
	}
}

public class Overriding {
	public static void main(String args[]) {
		A.printX(new A()); 	// calls B.printX(), then x in A (= 1) and x() in A (= 2)
		B.printX(new B());   // calls B.printX(), then x in B (= 2) and x() in B (= 2)
		A.printX(new B());   // calls A.printX(),  then x in A (= 1) and x() in B (= 2)
		A a = new B();
		a.m(a); 		// calls m() in B and retuns 2
	}
}
