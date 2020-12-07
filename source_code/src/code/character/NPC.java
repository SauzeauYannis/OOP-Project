package code.character;

public class NPC extends Character {

	/***************
	 * Constructor *
	 ***************/

	// Constructor
	public NPC(String name) {
		super(name);
	}

	/**********
	 * Method *
	 **********/

	// To talk
	public void talk(String dialog) {
		System.out.println(this + dialog);
	}
}