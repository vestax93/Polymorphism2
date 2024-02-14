package exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3])); //znamo da je u prvom redu Car
        tokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3])); //znamo da je u drugom redu Truck
        tokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3])); //znamo da je u drugom redu Truck

        int n = Integer.parseInt(scanner.nextLine()); //u trecem redu je zadat broj unos tj. komandi
        while(n-- > 0){
            tokens = scanner.nextLine().split("\\s+");

            try {
                switch(tokens[0]){ //prvi deo naredbe je da li je u pitanju Drive ili Refuel
                    case "Drive":
                        if(tokens[1].equals("Car")){ //u slucaju da je Car
                            System.out.println(car.drive(Double.parseDouble(tokens[2])));
                        } else if (tokens[1].equals("Truck")){ //u slucaju da je Truck
                            System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                        } else { //Bus
                            bus.setIsEmpty(false); //Kada imamo naredbu Drive Bus x km, podrazumeva se da je pun
                            System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                        }
                        break;
                    case "DriveEmpty": //znaci da Bus vozi prazan
                        System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                        break;
                    case "Refuel": //punjenje rezervoara
                        if(tokens[1].equals("Car")){
                            car.refuel(Double.parseDouble(tokens[2])); //treci clan niza je broj litara
                        } else if (tokens[1].equals("Truck")){
                            truck.refuel(Double.parseDouble(tokens[2]));
                        } else { //Bus
                            bus.refuel(Double.parseDouble(tokens[2]));
                        }
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println(car.toString()); //na kraju stampamo Car i koliko je goriva preostalo
        System.out.println(truck.toString()); //na kraju stampamo Truck i koliko je goriva preostalo
        System.out.println(bus.toString()); //na kraju stampamo Bus i koliko je goriva preostalo

    }
}
