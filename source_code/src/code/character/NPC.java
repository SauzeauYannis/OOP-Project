package code.character;

public class NPC extends Character {

	/// Methods ///

	public NPC(String name) {
		super(name);
	}

	public void talk(String dialog) {
		System.out.println("[" +
				this.getName() +
				"] : " +
				dialog);
	}
}