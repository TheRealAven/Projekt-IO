package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import locations.BuildingDatabase;
import locations.Building;
import locations.Floor;
import locations.Room;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.createBuilding;
import views.html.infoView;
import views.html.buildings;
import views.html.floors;
import views.html.rooms;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

public class BuildingController extends Controller {

    @Inject
    FormFactory formFactory;

    public static BuildingDatabase buildingDatabase = new BuildingDatabase();

    public Building findBuildingById(int id) {
        //BuildingDatabase buildingDatabase = new BuildingDatabase();
        for (Building building : buildingDatabase.getBuildingSet()) {
            if (building.getId() == id) {
                return building;
            }
        }
        return null;
    }

    public Floor findFloorById(List<Floor> floors, int id) {
        for (Floor floor : floors) {
            if (floor.getId() == id) {
                return floor;
            }
        }
        return null;
    }

    public Room findRoomById(List<Room> rooms, int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    public Result countLightningPower(int idBudynku) {
        double lightingPower = 0;
        Building building = findBuildingById(idBudynku);

        if (building == null) {
            return ok("nie ma takiego budynku");
        } else {
            lightingPower = building.countLightningPower();
            return ok(infoView.render("Moc oświetlenia", lightingPower));
        }
    }

    public Result countTotalArea(int idBudynku) {
        double area = 0;
        Building building = findBuildingById(idBudynku);

        if (building == null) {
            return ok("nie ma takiego budynku");
        } else {
            area = building.countTotalArea();
            return ok(infoView.render("Powierzchnia budynku", area));
        }
    }

    public Result countTotalCubage(int idBudynku) {
        Building building = findBuildingById(idBudynku);
        if (building == null) {
            return ok("nie ma takiego budynku");
        } else {
            double kubatura = building.countTotalCubage();
            return ok(infoView.render("Kubatura budynku", kubatura));
        }
    }

    public Result countEnergyConsumption(int idBudynku) {
        Building building = findBuildingById(idBudynku);
        if (building == null) {
            return ok("nie ma takiego budynku");
        } else {
            double zużycie = building.countEnergyConsumption();
            return ok(infoView.render("Średnie zużycie energii w budynku", zużycie));
        }
    }

    public Result countLightningPowerFloor(int idBudynku, int idF) {
        double lightingPower = 0;
        Building building = findBuildingById(idBudynku);

        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        lightingPower = floor.countLightningPower();
        return ok(infoView.render("Moc piętra", lightingPower));
    }

    public Result countTotalAreaFloor(int idBudynku, int idF) {
        double area = 0;
        Building building = findBuildingById(idBudynku);

        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        area = floor.countTotalArea();
        return ok(infoView.render("Powierzchnia piętra", area));
    }

    public Result countTotalCubageFloor(int idBudynku, int idF) {
        Building building = findBuildingById(idBudynku);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        double kubatura = floor.countTotalCubage();
        return ok(infoView.render("Kubatura piętra", kubatura));
    }

    public Result countEnergyConsumptionFloor(int idBudynku, int idF) {
        Building building = findBuildingById(idBudynku);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        double zużycie = floor.countEnergyConsumption();
        return ok(infoView.render("Średnie zużycie energii na piętrze", zużycie));
    }

    public Result countLightningPowerRoom(int idBudynku, int idF, int idR) {
        double lightingPower = 0;
        Building building = findBuildingById(idBudynku);

        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        Room room = findRoomById(floor.getRooms(), idR);
        if(room == null)
            return ok("nie ma takiego pomieszczenia");
        lightingPower = room.countLightningPower();
        return ok(infoView.render("Moc pomieszczenia", lightingPower));
    }

    public Result countTotalAreaRoom(int idBudynku, int idF, int idR) {
        double area = 0;
        Building building = findBuildingById(idBudynku);

        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        Room room = findRoomById(floor.getRooms(), idR);
        if(room == null)
            return ok("nie ma takiego pomieszczenia");
        area = room.countTotalArea();
        return ok(infoView.render("Powierzchnia pomieszczenia", area));
    }

    public Result countTotalCubageRoom(int idBudynku, int idF, int idR) {
        Building building = findBuildingById(idBudynku);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        Room room = findRoomById(floor.getRooms(), idR);
        if(room == null)
            return ok("nie ma takiego pomieszczenia");
        double kubatura = room.countTotalCubage();
        return ok(infoView.render("Kubatura pomieszczenia", kubatura));
    }

    public Result countEnergyConsumptionRoom(int idBudynku, int idF, int idR) {
        Building building = findBuildingById(idBudynku);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        Room room = findRoomById(floor.getRooms(), idR);
        if(room == null)
            return ok("nie ma takiego pomieszczenia");
        double zużycie = room.countEnergyConsumption();
        return ok(infoView.render("Zużycie energii w pomieszczeniu", zużycie));
    }

    public Result index(){
        Set<Building> buildingSet = BuildingDatabase.getBuildingSet();
        return ok(buildings.render(buildingSet));
    }


    public Result create() {
        Form<Building> buildingForm = formFactory.form(Building.class);
        return ok(createBuilding.render(buildingForm));
    }

    public Result createFloor(int id) {
        Form<Floor> floorForm = formFactory.form(Floor.class).bindFromRequest();
        Floor floor = floorForm.get();
        Building building = findBuildingById(id);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        System.out.println(floor.getId()+" "+floor.getName());
        building.addFloor(floor);
        return redirect(routes.BuildingController.writeInfoAboutBuilding(id));
    }

    public Result createRoom(int idB, int idF) {
        Form<Room> roomForm = formFactory.form(Room.class).bindFromRequest();
        Room room = roomForm.get();
        Building building = findBuildingById(idB);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        floor.addRoom(room);
        return redirect(routes.BuildingController.writeInfoAboutFloor(idB,idF));
    }

    public Result writeInfoAboutBuilding(int id){
        Form<Floor> floorForm = formFactory.form(Floor.class);
        Building building = findBuildingById(id);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        List<Floor> floorList = building.getFloors();
        return ok(floors.render(floorList, building.getId(), floorForm));
    }

    public Result writeInfoAboutFloor(int idB, int idF){
        Form<Room> roomForm = formFactory.form(Room.class);
        Building building = findBuildingById(idB);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        Floor floor = findFloorById(building.getFloors(), idF);
        if (floor == null) {
            return ok("nie ma takiego piętra");
        }
        List<Room> roomList = floor.getRooms();
        return ok(rooms.render(roomList, idB, idF, roomForm));
    }

    public Result writeJSONAbout(int id) {
        Building building = findBuildingById(id);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        return ok(Json.toJson(building));
    }

    public Result writeInfoAboutAllBuildings() {
        //BuildingDatabase buildingDatabase = new BuildingDatabase();
        return ok(Json.toJson(buildingDatabase.getBuildingSet()));
    }

    public Building getFromJson() {
        JsonNode json = Json.parse("{\"name\":\"Food\", \"age\":13}");
        Building building = Json.fromJson(json, Building.class);
        return building;
    }

}
