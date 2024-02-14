package exercise1;

public class Truck extends VehicleImpl{
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6); //zbog klime se povecava potrosnja za 1.6 kod Truck
    }

    @Override
    public String drive(double distance) {
        return "Truck " + super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95); //zbog rupe u rezervoaru, 5% goriva ce iscureti
    }
}
