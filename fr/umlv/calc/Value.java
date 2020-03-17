package fr.umlv.calc;

import fr.umlv.calc.Expr;

public class Value extends Expr {
	private final int _value;

	public
	Value(int value) {
		_value = value;
	}
	
	public
	Value(Value other) { this(other._value); }


	@Override
	public
	int
	eval() {
		return _value;
	}

	@Override
	public
	String
	toString() {
		return symbol();
	}

	@Override
	public
	String
	symbol() {
		return String.valueOf(_value);
	}

	public
	static
	boolean
	isValue(String symbol) {
		try {
			var value = Integer.parseInt(symbol);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public
	static
	Value
	fromSymbol(String symbol) {
		if(!isValue(symbol)) {
			throw new IllegalArgumentException("WHATEVER AHHHH");
		}
		return new Value(Integer.parseInt(symbol));
	}

}
