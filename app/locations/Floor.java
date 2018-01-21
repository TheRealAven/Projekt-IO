/**
 * 
 */
package locations;

import java.util.ArrayList;

/**
 * @author Oskar
 *
 */
public class Floor extends Location {

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	private ArrayList<Room> rooms;
	
	/**
	 * @param id - Unikalny identyfikator lokacji
	 * @param name - Opcjonalna nazwa lokacji
	 */
	public Floor(int id, String name) {
		super(id, name);
		rooms = new ArrayList<>();
	}

	/**
	 * @param id - Unikalny identyfikator lokacji
	 */
	public Floor(int id) {
		super(id);
		rooms = new ArrayList<>();
	}

	public Floor(){rooms = new ArrayList<>();}
	
	/**
	 * Przypisuje pomieszczenie do danego poziomu
	 * @param p - przypisywane pomieszczenie
	 */
	public void addRoom(Room p) {
		rooms.add(p);
	}
	
	/**
	 * Usuwa przypisanie rooms do poziomu
	 * @param p - usuwane pomieszczenie
	 */
	public void deleteRoom(Room p) {
		rooms.remove(p);
	}
	
	/**
	 * @return Wyliczane jako średnia moc na m^2 na poziomie
	 */
	@Override
	public double countLightningPower() {
		double power =0;
		double area =0;
		for(Room p : rooms) {
			power+=p.countLightningPower();
			area+=p.countTotalArea();
		}
		return power/area;
	}

	/**
	 * Wyliczanie powierzchni poziomu poprzez sumowanie powierzchni pomieszczen.
	 * @return - zwraca sumaryczna powierzchnie poziomu.
	 */
	@Override
	public double countTotalArea() {
		int sum_area=0;
		for(Room pom: rooms){
			sum_area+=pom.countTotalArea();
		}
		return sum_area;
	}

    /**
     * @return Kubaturę poziomu wyliczaną jako suma kubatury pomieszczeń na poziomie
     */
	@Override
	public double countTotalCubage() {
		double kubaturaPoziomu = 0;
		for (Room p : rooms) {
		    kubaturaPoziomu += p.countTotalCubage();
        }
		return kubaturaPoziomu;
	}

	/**
	 *
	 * @return Zużycie energii na ogrzewanie poziomu w przeliczeniu na jednostkę objętości
	 */
	@Override
	public double countEnergyConsumption() {
		double floorEnergyConsumption = 0;
        double meanFloorEnergyConsumption;
		for (Room room : rooms) {
		    floorEnergyConsumption += room.countEnergyConsumption();
        }
        meanFloorEnergyConsumption = floorEnergyConsumption / rooms.size();
        return  meanFloorEnergyConsumption;
	}

}
