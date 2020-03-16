package fr.umlv.td2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Exo3 {

	public static void main(String[] args)	{
		/*
		String num = Exo3.number(args);
		System.out.println(num);
		*/
		char ipOctets[] = Exo3.ipv4(args[0]);
		if (ipOctets == null)
		{
			System.out.println("Adresse IPv4 non valide, wesh.");
			return;
		}
		for(var octet: ipOctets) System.out.println(Integer.valueOf(octet));
	}
	public static String number(String[] args)
	{
		// La Classe Pattern offre une interface pour l'interprétation et la compilation d'expressions régulières.
		// Matcher permet de faire correspondre une expression avec un patron de Pattern.
		// String numbers  = "((\\d)+)((\\.)?)((\\d)+)";
		String whatever  = "((\\D)*)";
		Pattern whatPat  = Pattern.compile(whatever);
		var numOut = new StringBuilder();
		for(var arg: args) {
			String numSplit[] = whatPat.split(arg);
			for(var num: numSplit) numOut.append(num);
		}
		return numOut.toString();
	}

	public static char[] ipv4(String input)
	{
		String octet = "(\\d)+";
		Pattern sepPat = Pattern.compile("\\.");
		Pattern octetPat = Pattern.compile(octet);
		String octetChecks[] = sepPat.split(input);
		Matcher octetMat;
		// checking number of octets
		if (octetChecks.length != 4) return null;
		//building list
		char ipOctets[] = new char[4];
		// going through each octet
		int i=0;
		for(var check: octetChecks) {
			octetMat = octetPat.matcher(check);
			// first check
			if (!octetMat.matches()) return null;
			int val = Integer.valueOf(check);
			// second pass
			if (val < 0 || val >= 256) return null;
			// all clear, adding to list
			ipOctets[i++] = (char)val;
		}
		return ipOctets;
	}
}
