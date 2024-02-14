package exercise2;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle { //u ovoj klasi, objedinjujemo zajenicke osobine i Car i Truck, ali ona sama za sebe ne sme da postoji i zato dodajemo abstract
    private double fuelQuantity; //kolicina goriva u rezervoaru
    private double fuelConsumption; //potrosnja goriva po kilometru
    private double tankCapacity; //kapacitet rezervoara tj. koliko litara moze da primi rezervoar


    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance) { //distance je broj kilometara koji pokusavamo da predjemo, ali moramo da proverimo da li imamo dovoljno goriva (uporodjujemo to sa potrosnjom po kilometru)
        double fuelNeeded = distance * this.fuelConsumption;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        String result = "needs refueling";

        if(this.fuelQuantity >= fuelNeeded){ //ima doboljno goriva da se predje zadati put
            result = String.format("travelled %s km", decimalFormat.format(distance)); //koliko kilometara je predjeno jer je to isto i za Car i za Truck
            this.fuelQuantity -= fuelNeeded; //oduzimamo iz rezervoara onoliko goriva koliko je potroseno za putovanje cija je duzina zadata
        }
        return result;
    }

    @Override
    public void refuel(double liters) { //dopunjavamo rezervoar sa onoliko litara koliko je zadato u parametru
        if(liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double newFuel = this.fuelQuantity + liters;
        if(newFuel > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
