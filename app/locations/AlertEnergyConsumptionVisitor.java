package locations;

import java.util.ArrayList;

public class AlertEnergyConsumptionVisitor implements Visitor {
    private double borderValueEnergyConsumption;
    private ArrayList<Room> roomsExceedingEnergyConsumption = new ArrayList<>();

    /**
     *
     * @param borderValueEnergyConsumption Wartość graniczna poziomu zużycia energii cieplnej na jednostkę objętości.
     */
    public AlertEnergyConsumptionVisitor(double borderValueEnergyConsumption) {
        this.borderValueEnergyConsumption = borderValueEnergyConsumption;
    }

    /**
     *
     * @param room Pomieszczenie, dla którego będzie sprawdzane czy zużycie przez niego energii cieplnej przekroczyło wartość graniczną.
     */
    @Override
    public void visitRoom(Room room) {
        if (room.countEnergyConsumption() > borderValueEnergyConsumption) {
            roomsExceedingEnergyConsumption.add(room);
        }
    }

    /**
     *
     * @return Listę pomieszczeń przekraczających wartość graniczną poziomu zużycia energii cieplnej na jednostkę objętości.
     */
    public ArrayList<Room> getRoomsExceedingEnergyConsumption() {
        return roomsExceedingEnergyConsumption;
    }
}
