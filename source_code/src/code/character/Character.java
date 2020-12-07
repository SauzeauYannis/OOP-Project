package code.character;

public abstract class Character{

	/******************************
	 * Attributes and constructor *
	 ******************************/

	/// Attributes ///
	private final String name;


	/// Constructor ///
	public Character(String name){
		this.name = name;
	}


	/*************
	 * Accessors *
	 *************/

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "[" + this.name + "] : ";
	}
}