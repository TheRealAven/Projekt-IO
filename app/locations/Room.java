/**
 * 
 */
package locations;

/**
 * @author Oskar
 *
 */
public class Room extends Location {

	private int area;
	private int cube;
	private float heating;
	private int light;
	
	/**
	 * @param id - Unikalny identyfikator
	 * @param name - Opcjonalna nazwa
	 * @param area - Powierzchnia w m^2
	 * @param cube - kubatura pomieszczenia w m^3
	 * @param heating - poziom zużycia energii ogrzewania
	 * @param light - łączna moc oświetlenia
	 */
	public Room(int id, String name, int area, int cube, float heating,
				int light) {
		super(id, name);
		this.area=area;
		this.cube=cube;
		this.heating=heating;
		this.light=light;
	}

	/**
	 * @param id - Unikalny identyfikator
	 * @param area - Powierzchnia w m^2
	 * @param cube - kubatura pomieszczenia w m^3
	 * @param heating - poziom zużycia energii ogrzewania
	 * @param light - łączna moc oświetlenia
	 */
	public Room(int id, int area, int cube, float heating, int light) {
		super(id);
		this.area=area;
		this.cube=cube;
		this.heating=heating;
		this.light=light;
	}
	
	public Room(){}

	
	/**
	 * @return Łączną moc oświetlenia w danym pomieszczeniu.
	 */
	@Override
	public double countLightningPower() {
		return light;
	}

	/**
	 * @return - zwraca powierzchnie pomieszczenia
	 */
	@Override
	public double countTotalArea() {
		return area;
	}

	/**
	 * @return Kubaturę pomieszczenia.
	 */
	@Override
	public double countTotalCubage() { return cube; }

}
