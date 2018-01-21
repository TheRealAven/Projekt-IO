/**
 * 
 */
package locations;

/**
 * @author Oskar
 *
 */
public abstract class Location {

	private int id;
	private String name;
	
	/**
	 * @param id - Unikalny identyfikator lokacji
	 * @param name - Opcjonalna nazwa lokacji
	 */
	public Location(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	/**
	 * @param id - Unikalny identyfikator lokacji
	 */
	public Location(int id) {
		this.id=id;
	}
	
	public Location(){}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	public abstract double countLightningPower();

	public abstract double countTotalArea();

	public abstract double countTotalCubage();

	public abstract double countEnergyConsumption();
}
