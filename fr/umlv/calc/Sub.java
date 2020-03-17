package fr.umlv.calc;

import fr.umlv.calc.BinOperator;

public class Sub extends BinOperator {
	public final static String STR_SUB = "-";

	public
	Sub(Expr left, Expr right) {
		super(STR_SUB, left, right);
	}

	@Override
	public
	int
	eval() {
		return left().eval() - right().eval(); 
	}
	
	@Override
	public
	String
	symbol() {
		return STR_SUB;
       	}
	
	public
	static
	boolean
	isSymbol(String symbol) {
		return symbol.equals(STR_SUB);
	}

}
