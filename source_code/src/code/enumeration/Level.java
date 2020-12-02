package code.enumeration;

public enum Level {

	COPPER,
	GOLD,
	PLATINUM;

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}