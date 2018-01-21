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


    /**
     *
     * @return Moc oświetlenia lokacji w przeliczeniu na jednostkę powierzchni.
     */
	public abstract double countLightningPower();

    /**
     *
     * @return Powierzchnię lokacji.
     */
	public abstract double countTotalArea();

    /**
     *
     * @return Kubaturę lokacji.
     */
	public abstract double countTotalCubage();

    /**
     *
     * @return Zużycie energii przez lokację na ogrzewanie w przeliczeniu na jednostkę objętości.
     */
	public abstract double countEnergyConsumption();
}
