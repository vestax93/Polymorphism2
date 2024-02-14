package exercise2;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9); //potrosnja goriva za Car je veca za 0.9 od one koja je zadata zbog potrosnje goriva na klimu
    }

    @Override
    public String drive(double distance) {
        return "Car " + super.drive(distance); //stavljamo naziv klase na pocetak
    }

}
