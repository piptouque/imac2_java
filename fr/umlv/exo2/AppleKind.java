
package fr.umlv.exo2;

public enum AppleKind {
	Golden, PinkLady, GrannySmith, Whatever;

	@Override
	public
	String toString() {
		switch(this) {
			case Golden:
				return new String("Golden");
			case PinkLady:
				return new String("Pink Lady");
			case GrannySmith:
				return new String("Granny Smith");
			case Whatever:
				return new String("Whatever");
		}
		return new String("Who wants to eat apples forever?");
	}
}
