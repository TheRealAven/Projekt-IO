package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import locations.BuildingDatabase;
import locations.Building;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.createBuilding;
import views.html.infoView;

import javax.inject.Inject;

public class BuildingController extends Controller {

    @Inject
    FormFactory formFactory;


    public Building findBuildingById(int id) {
        BuildingDatabase buildingDatabase = new BuildingDatabase();
        for (Building building : buildingDatabase.getBuildingSet()) {
            if (building.getId() == id) {
                return building;
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


    public Result create() {
        Form<Building> buildingForm = formFactory.form(Building.class);
        return ok(createBuilding.render(buildingForm));
    }

    public Result writeInfoAbout(int id) {
        Building building = findBuildingById(id);
        if (building == null) {
            return ok("nie ma takiego budynku");
        }
        return ok(Json.toJson(building));
    }

    public Result writeInfoAboutAllBuildings() {
        BuildingDatabase buildingDatabase = new BuildingDatabase();
        return ok(Json.toJson(buildingDatabase.getBuildingSet()));
    }

    public Building getFromJson() {
        JsonNode json = Json.parse("{\"name\":\"Food\", \"age\":13}");
        Building building = Json.fromJson(json, Building.class);
        return building;
    }

}
