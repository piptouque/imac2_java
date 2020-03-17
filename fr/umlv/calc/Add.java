package fr.umlv.calc;

import fr.umlv.calc.BinOperator;

public class Add extends BinOperator {
	public final static String STR_ADD = "+";

	public
	Add(Expr left, Expr right) {
		super(STR_ADD, left, right);
	}

	@Override
	public
	int
	eval() {
		return left().eval() + right().eval(); 
	}
	
	@Override
	public
	String
	symbol() {
		return STR_ADD;
	}
	
	public
	static	
	boolean
	isSymbol(String symbol) {
		return symbol.equals(STR_ADD);
	}
}
