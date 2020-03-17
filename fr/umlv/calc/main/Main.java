package fr.umlv.calc.main;

import fr.umlv.calc.OpOrValue;

import fr.umlv.calc.Expr;

public class Main {
      	public static void main(String[] args) {
		OpOrValue expression = new OpOrValue(OpOrValue.OP_ADD,
		new OpOrValue(2),
		new OpOrValue(3)
		);
    		System.out.println(expression.eval());
		/* */
		/*
		 * :: - + 1 4 + 2 3
		 * :: 2 + 3 - (1 + 4)
		 */
		String s1 = "- + 2 3 4";
		String s2 = "- + 1 4 + 2 3";
		var expr1 = OpOrValue.parse(s1);
		var expr2 = OpOrValue.parse(s2);
		var expr3 = OpOrValue.parse("+", "1","1");
		System.out.println(expr1.toString() + " =  " + expr1.eval());
		System.out.println(expr2.toString() + " = " + expr2.eval());
		System.out.println(expr3.toString() + " = " + expr3.eval());
		/* */
		var expr4 = Expr.parse(s1);
		var expr5 = Expr.parse(s2);
		var expr6 = Expr.parse("+", "1","1");
		System.out.println(expr4.toString() + " =  " + expr4.eval());
		System.out.println(expr5.toString() + " = " + expr5.eval());
		System.out.println(expr6.toString() + " = " + expr6.eval());
	}
}
