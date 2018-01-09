package locations;

import java.util.HashSet;
import java.util.Set;

public class BuildingDatabase {

    public static Set<Building> buildingSet = new HashSet<Building>();

    public BuildingDatabase() {
        Floor p0 = new Floor(0, "parter");
        Floor p1 = new Floor(0, "pierwsze");
        Floor p2 = new Floor(0, "drugie");

        Room pom1 = new Room(1,"balkon",154,23,10,123);
        Room pom2 = new Room(1,"kuchnia",12,2,111,12);
        Room pom3 = new Room(1,"salon",1,2,1,1);

        p0.addRoom(pom1);
        p0.addRoom(pom3);
        p0.addRoom(pom2);
        p1.addRoom(pom3);
        p2.addRoom(pom2);

        Building b1 = new Building(1, "wieżowiec");
        b1.addFloor(p0);
        b1.addFloor(p1);
        b1.addFloor(p2);
        Building b2 = new Building(2, "sky tower");
        b2.addFloor(p0);
        b2.addFloor(p1);

        Building b3 = new Building(3, "stary browar");
        b3.addFloor(p0);

        this.buildingSet.add(b1);
        this.buildingSet.add(b2);
        this.buildingSet.add(b3);
    }

    public static Set<Building> getBuildingSet() {
        return buildingSet;
    }

    public static void setBuildingSet(Set<Building> buildingSet) {
        BuildingDatabase.buildingSet = buildingSet;
    }
}
