package fr.umlv.calc;

import fr.umlv.calc.Operator;
import fr.umlv.calc.BinOperator;
import fr.umlv.calc.Value;

import java.util.Scanner;
import java.util.Iterator;
import java.util.Arrays;

abstract public class Expr {

	public int eval() {
		return 0;
	}

	public
	static
	Scanner
	reversePolishScanner(String s) {
		return new Scanner(s).useDelimiter(" ");
	}

	public
	static
	Expr
	parse(String s) { return parse(reversePolishScanner(s)); }


	public
	static
	Expr
	parse(String... args) { return parse(Arrays.asList(args).iterator()); }

	public
	static
	Expr
	parse(Iterator<String> it) {
		if(!it.hasNext()) {
			throw new IllegalArgumentException("One does not simply whatever.");
		}
		return parse_REC(0, it);
	}

	public
	static
	Expr
	parse_REC(int count, Iterator<String> it) {
		if(!it.hasNext()) {
			return null;
		}
		String symbol = it.next();
		if(count == 0)
		{
			if(Value.isValue(symbol) && it.hasNext()) {
				throw new IllegalArgumentException("Whatever you do, I won't do it for you.");
			}
		}
		++count;
		if(Value.isValue(symbol)) {
			return  Value.fromSymbol(symbol);
		} else if(BinOperator.isOperator(symbol)) {
			var parsedLeft  = parse_REC(count, it);
			var parsedRight = parse_REC(count, it);
			if(parsedLeft == null || parsedRight == null) {
				throw new IllegalArgumentException("Shot through the heart, but whatever.");
			}
			return BinOperator.fromSymbol(symbol, parsedLeft, parsedRight);
		}
		throw new IllegalArgumentException("As I walk through the valley of the shadow of Death, I take a look at my life and realise: whatever.");

	}	

	abstract public String symbol();

	abstract public String toString();

	}
