/**
 *
 */
package locations;

import java.util.ArrayList;

/**
 * @author Oskar
 */
public class Building extends Location {

    private ArrayList<Floor> floors;


    /**
     * @param id   - Unikalny identyfikator lokacji
     * @param name - Opcjonalna nazwa lokacji
     */
    public Building(int id, String name) {
        super(id, name);
        floors = new ArrayList<>();


    }

    /**
     * @param id - Unikalny identyfikator lokacji
     */
    public Building(int id) {
        super(id);
        floors = new ArrayList<>();
    }

    /**
     * Przypisuje poziom do danego budynku
     *
     * @param p - przypisywany poziom
     */
    public void addFloor(Floor p) {
        floors.add(p);
    }

    /**
     * Usuwa przypisanie poziomu do budynku
     *
     * @param p - poziom usuwany z budynku
     */
    public void deleteFloor(Floor p) {
        floors.remove(p);
    }

    /**
     * Wyliczane jako średnia moc na poziomach
     */
    @Override
    public double countLightningPower() {
        double lightningPower = 0;
        for (Floor p : floors)
            lightningPower += p.countLightningPower();
        return lightningPower / floors.size();
    }

    /**
     * Obliczanie całkowitej powierzchni budynku poprzez sumowanie całkowitej powierzchni poziomów.
     * @return - zwraca sumaryczną powierzchnię budynku.
     */
    @Override
    public double countTotalArea() {
        int sum_area=0;
        for(Floor poz: floors){
            sum_area+=poz.countTotalArea();
        }
        return sum_area;
    }



    /**
     * @return Kubaturę budynku wyliczaną jako suma kubatury poziomów
     */
    @Override
    public double countTotalCubage() {
        double kubaturaBudynku = 0;
        for (Floor p : floors) {
            kubaturaBudynku += p.countTotalCubage();
        }
        return kubaturaBudynku;
    }

    /**
     *
     * @return Zużycie energii na ogrzewanie budynku w przeliczeniu na jednostkę objętości.
     */
    @Override
    public double countEnergyConsumption() {
        double buildingEnergyConsumption = 0;
        double meanBuildingEnergyConsumption;
        for (Floor floor : floors) {
            buildingEnergyConsumption += floor.countEnergyConsumption();
        }
        meanBuildingEnergyConsumption = buildingEnergyConsumption / floors.size();
        return meanBuildingEnergyConsumption;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

}
