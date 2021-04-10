package labs_examples.objects_classes_methods.labs.objects;

public class AirplaneExample {

    public static void main(String[] args) {

        Cockpit myCockpit = new Cockpit(2,"Lockheed Martin");
        PlaneBody myPlaneBody = new PlaneBody("Silver",253.5, 10.6);
        Propeller myPropeller = new Propeller("Jet", 4,110000);
        Wing myWing = new Wing(52.3, 13.2);
        Airplane myAirplane = new Airplane(450, 440, 196, myPropeller, myWing, myCockpit, myPlaneBody);

        System.out.println(myAirplane.toString());

        System.out.println("My current fuel level is: " + myAirplane.getCurrentFuelLevel());
        myAirplane.setCurrentFuelLevel(231.45);
        System.out.println("After flying for some time, my new few level is: " + myAirplane.getCurrentFuelLevel());
        myCockpit.setNumPilots(1);
        System.out.println("Oh no! A pilot seems to have had a heart attack! Now we only have: " + myCockpit.getNumPilots() + " pilot.");
    }

}

class Airplane{
    private double fuelCapacity;
    private double currentFuelLevel;
    private int numPassengers;
    private Propeller propeller;
    private Wing wing;
    private Cockpit cockpit;
    private PlaneBody planeBody;

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
                ", \ncurrentFuelLevel=" + currentFuelLevel +
                ", \nnumPassengers=" + numPassengers +
                ", \npropeller=" + propeller +
                ", \nwing=" + wing +
                ", \ncockpit=" + cockpit +
                ", \nplaneBody=" + planeBody +
                '}';
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public Propeller getPropeller() {
        return propeller;
    }

    public void setPropeller(Propeller propeller) {
        this.propeller = propeller;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    public Cockpit getCockpit() {
        return cockpit;
    }

    public void setCockpit(Cockpit cockpit) {
        this.cockpit = cockpit;
    }

    public PlaneBody getPlaneBody() {
        return planeBody;
    }

    public void setPlaneBody(PlaneBody planeBody) {
        this.planeBody = planeBody;
    }
}

class Propeller{

    private String kindOfPropeller;
    private int numPropellers;
    private double horsePower;

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

    public String getKindOfPropeller() {
        return kindOfPropeller;
    }

    public void setKindOfPropeller(String kindOfPropeller) {
        this.kindOfPropeller = kindOfPropeller;
    }

    public int getNumPropellers() {
        return numPropellers;
    }

    public void setNumPropellers(int numPropellers) {
        this.numPropellers = numPropellers;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }
}

class Wing{

    private double wingLength;
    private double wingWidth;

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

    public double getWingLength() {
        return wingLength;
    }

    public void setWingLength(double wingLength) {
        this.wingLength = wingLength;
    }

    public double getWingWidth() {
        return wingWidth;
    }

    public void setWingWidth(double wingWidth) {
        this.wingWidth = wingWidth;
    }
}

class Cockpit{

    private int numPilots;
    private String controlSystem;

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

    public int getNumPilots() {
        return numPilots;
    }

    public void setNumPilots(int numPilots) {
        this.numPilots = numPilots;
    }

    public String getControlSystem() {
        return controlSystem;
    }

    public void setControlSystem(String controlSystem) {
        this.controlSystem = controlSystem;
    }
}

class PlaneBody{

    private String bodyColor;
    private double bodyLength;
    private double bodyRadius;

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

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public double getBodyRadius() {
        return bodyRadius;
    }

    public void setBodyRadius(double bodyRadius) {
        this.bodyRadius = bodyRadius;
    }
}
