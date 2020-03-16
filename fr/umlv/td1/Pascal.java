package fr.umlv.td1;

public class Pascal {
	public static void main(String args[])
	{
		System.out.println(" Cn, p = " + Integer.toString(Pascal.pascal(30000, 250)));
	}
	
	public static int pascal(int nBut, int pBut) {
		int[] tab = new int[nBut+1];
		tab[0] = 1;
		for(int n=1; n<nBut; ++n)
		{
			tab[n] = 1;
			for(int i=n-1; i>0; i--) tab[i] = tab[i-1] + tab[i];
		}
		return tab[pBut];
	}
}
