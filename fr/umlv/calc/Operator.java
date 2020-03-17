package fr.umlv.calc;

import fr.umlv.calc.Expr;

import java.util.Arrays;

abstract class Operator extends Expr {
	/* 
	 * Why bother with only binary operator?
	 * Because I've got other things to do.
	 * Well, whatever, nevermind.
	 */
	protected final Expr _operands[];
	private final String _symbol;

	public
	Operator(int nbOperands, String symbol) {
		_operands = new Expr[nbOperands];
		_symbol = symbol;
	}
}
