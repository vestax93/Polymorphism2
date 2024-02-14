package exercise2;

public class Bus extends VehicleImpl{
    private static final boolean DEFAULT_IS_EMPTY = true; //podrazumevano je da je autobous prazan
    private boolean isEmpty;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.setIsEmpty(DEFAULT_IS_EMPTY);
    }

    public void setIsEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if(!this.isEmpty){ //kad Bus nije prazan, povecava se potrosnja za 1.4
            super.setFuelConsumption(fuelConsumption + 1.4);
        }
    }

    @Override
    public String drive(double distance) {
        return "Bus " + super.drive(distance);
    }
}
