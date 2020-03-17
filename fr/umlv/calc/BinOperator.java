package fr.umlv.calc;

import fr.umlv.calc.Operator;

import java.util.Objects;

abstract class  BinOperator extends Operator {
	
	public final static int NB_OPERANDS_BIN = 2;
	
	protected
	BinOperator(String symbol, Expr first, Expr second) {
		super(NB_OPERANDS_BIN, symbol);
		_operands[0] = Objects.requireNonNull(first);
		_operands[1]  = Objects.requireNonNull(second);
	}

	public Expr left() { return _operands[0]; }
	public Expr right() { return _operands[1]; }

	@Override
	public
	String
	toString() {
		return toString_REC(new StringBuilder()).toString();
	}

	private
	StringBuilder
	toString_REC(StringBuilder acc) {
		acc.append(left().toString());
		acc.append(symbol());
		acc.append(right().toString());
		return acc;
	}

	public
	static
	boolean
	isOperator(String symbol) {
		return Add.isSymbol(symbol) || Sub.isSymbol(symbol);
	}
	
	public
	static
	BinOperator
	fromSymbol(String symbol, Expr first, Expr second) {
		if(Add.isSymbol(symbol)) return new Add(first, second);
		if(Sub.isSymbol(symbol)) return new Sub(first, second);
		throw new IllegalArgumentException("Nobody knows, whatever I've seen.");	
	} 
}


