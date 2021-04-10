package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneExample {


}

class Airplane{
    double fuelCapacity;
    double currentFuelLevel;
    int numPassengers;
    Propeller propeller;
    Wing wing;
    Cockpit cockpit;
    PlaneBody planeBody;

    public Airplane(double fuelCapacity, double currentFuelLevel, int numPassengers, Propeller propeller, Wing wing, Cockpit cockpit, PlaneBody planeBody) {
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.numPassengers = numPassengers;
        this.propeller = propeller;
        this.wing = wing;
        this.cockpit = cockpit;
        this.planeBody = planeBody;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                ", numPassengers=" + numPassengers +
                ", propeller=" + propeller +
                ", wing=" + wing +
                ", cockpit=" + cockpit +
                ", planeBody=" + planeBody +
                '}';
    }
}

class Propeller{

    String kindOfPropeller;
    int numPropellers;
    double horsePower;

    public Propeller(String kindOfPropeller, int numPropellers, double horsePower) {
        this.kindOfPropeller = kindOfPropeller;
        this.numPropellers = numPropellers;
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Propeller{" +
                "kindOfPropeller='" + kindOfPropeller + '\'' +
                ", numPropellers=" + numPropellers +
                ", horsePower=" + horsePower +
                '}';
    }
}

class Wing{

    double wingLength;
    double wingWidth;

    public Wing(double wingLength, double wingWidth) {
        this.wingLength = wingLength;
        this.wingWidth = wingWidth;
    }

    @Override
    public String toString() {
        return "Wing{" +
                "wingLength=" + wingLength +
                ", wingWidth=" + wingWidth +
                '}';
    }
}

class Cockpit{

    int numPilots;
    String controlSystem;

    public Cockpit(int numPilots, String controlSystem) {
        this.numPilots = numPilots;
        this.controlSystem = controlSystem;
    }

    @Override
    public String toString() {
        return "Cockpit{" +
                "numPilots=" + numPilots +
                ", controlSystem='" + controlSystem + '\'' +
                '}';
    }
}

class PlaneBody{

    String bodyColor;
    double bodyLength;
    double bodyRadius;

    public PlaneBody(String bodyColor, double bodyLength, double bodyRadius) {
        this.bodyColor = bodyColor;
        this.bodyLength = bodyLength;
        this.bodyRadius = bodyRadius;
    }

    @Override
    public String toString() {
        return "PlaneBody{" +
                "bodyColor='" + bodyColor + '\'' +
                ", bodyLength=" + bodyLength +
                ", bodyRadius=" + bodyRadius +
                '}';
    }
}
