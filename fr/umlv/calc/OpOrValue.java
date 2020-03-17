package fr.umlv.calc;

import java.util.Scanner;
import java.util.Iterator;
import java.util.Arrays;

public class OpOrValue {
	public static final int OP_NONE = 0;
	public static final int OP_ADD = 1;
	public static final int OP_SUB = 2;
	

	public static final String STR_OP_ADD = "+";
       	public static final String STR_OP_SUB = "-";

	private final int operator;
	private final int value;

	private final OpOrValue left;
	private final OpOrValue right;
	/*
	 * This constructor requires some knowledge of the inner class,
	 * and is too general (need an OpOrValue to initialise another)
	 * so it is set to private. 
	 */ 
	private
	OpOrValue(int operator, int value, OpOrValue left, OpOrValue right) {
		if(operator < OP_NONE || operator > OP_SUB) {
	  	/* bad argument */
			throw new IllegalArgumentException("nuhuh. no -- way.");	  
	  	}
	  	this.operator = operator;
	  	this.value = value;
  	  	this.left = left;
	  	this.right = right;
	}
  	public
	OpOrValue(int value) {
    		this(OP_NONE, value, null, null);
  	}
  	public
	OpOrValue(int operator, OpOrValue left, OpOrValue right) {
		// a bug lies here
		/*
		* not exactly a bug, but a POTENTIAL one, sure.
		* we should perform a few checks
		*/
		this(operator, 0, left, right);	
	}
	  
	public 
	int 
	eval() {
		switch(operator) {
	    		case OP_ADD:
	      			return left.eval() + right.eval();
	    		case OP_SUB:
	      			return left.eval() - right.eval();
	    		default: // case OP_NONE:
	      		return value;
	    	}
	}

	@Override
	public
	String
	toString() {
		return toString_REC(new StringBuilder()).toString();
	}

	private
	StringBuilder
	toString_REC(StringBuilder acc) {
		if(isOperator()) {
			left.toString_REC(acc);
			acc.append(symbol());
			right.toString_REC(acc);
		} else {
			acc.append(symbol());
		}
		return acc;	

	}
	

	public
	boolean
	isOperator() {
		return operator != OP_NONE;
	}
	
	public
	static
	boolean
	isSymbolValue(String symbol) {
		/* hey! I shouldn't trigger an exception
		 * in order to know if it is an integer, that's
		 * just silly. Whatever.
		 */
		try {
			var value = Integer.parseInt(symbol);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}

	public
	String
	symbol() {
		return isOperator() ? symbolFromOperator(operator) : symbolFromValue(value);
	}	
	public
	static
	int
	valueFromSymbol(String symbol) {
		return Integer.parseInt(symbol);
	}

	public
	static
	String
	symbolFromValue(int value) {
		return String.valueOf(value);
	}

	public
	static
	boolean
	isSymbolOperator(String symbol) {
		return symbol.equals(STR_OP_ADD) || symbol.equals(STR_OP_SUB); }

	public
	static
	int	
	operatorFromSymbol(String symbol) {
		switch(symbol) {
			case STR_OP_ADD : return OP_ADD;
			case STR_OP_SUB : return OP_SUB;
			default:
				throw new IllegalArgumentException("Symbol is not an operator.");
		}
	}

	public
	static
	String
	symbolFromOperator(int op) {
		switch(op) {
			case OP_ADD : return STR_OP_ADD;
			case OP_SUB : return STR_OP_SUB;
			default:
				throw new IllegalArgumentException("AHH WHATEVER");
		}
	}

	public
	static
	Scanner
	reversePolishScanner(String s) {
		/*
		 * @brief: Converts a String to a suitable Scanner
		 */
		return new Scanner(s).useDelimiter(" ");
	}

	public
	static
	OpOrValue
	parse(String s) {
		/*
		 * In case of single String,
		 * we convert it to a Scanner
		 * and pass it throught parse()
		 */
		return parse(reversePolishScanner(s));
	}
	
	public
	static
	OpOrValue
	parse(String... args) {
		/*
		 * In case of parsed values and ops in String[] or String...
		 * we convert it to List and get an Iterator
		 * so that it implements hasNext() and next()
		 */
		return parse(Arrays.asList(args).iterator());
	}

	public	
	static
	OpOrValue
	parse(Iterator<String> it) {
		/*
		 * First we check that the iterator is not 'empty'
		 * that is, that it points towards at least one element.
		 *
		 */
		if(!it.hasNext()) {
			throw new IllegalArgumentException("WAHHH");	
		}
		return parse_REC(0, it);
	}

	public
	static
	OpOrValue	
	parse_REC(int count, Iterator<String> it) {
		/*
		 * Base case.
		 */
		if(!it.hasNext()) {
			return null; // default value
		}
		String symbol = it.next();
		if(count == 0) {
			/*
			 * input must either:
			 * * have an operator as a first element
			 * OR be a single value
			 * so that 1 + 1 does not make sense
			 * and must be refused un invert polish notation
			 */
			if(isSymbolValue(symbol) && it.hasNext()) {
				throw new IllegalArgumentException("Dost thou eventh 'Invert Polish', fellow?");
			}
		}
		++count;
		if(isSymbolValue(symbol)) {
			int value = valueFromSymbol(symbol);
			return new OpOrValue(value);
				
		} else if(isSymbolOperator(symbol)) {
			int op = operatorFromSymbol(symbol);
			var parsedLeft  = parse_REC(count, it);
			var parsedRight = parse_REC(count, it);
			if(parsedLeft == null || parsedRight == null) {
				throw new IllegalArgumentException("An operator must be followed by two numbers, ya thick.");
			}
			return new OpOrValue(
					op,
					parsedLeft,
					parsedRight
					);		
		}
		throw new IllegalArgumentException("Symbol not recognised, whatever.");
	}
}
