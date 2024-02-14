package exercise1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2])); //znamo da je u prvom redu Car
        tokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2])); //znamo da je u drugom redu Truck
        int n = Integer.parseInt(scanner.nextLine()); //u trecem redu je zadat broj unos tj. komandi
        while(n-- > 0){
            tokens = scanner.nextLine().split("\\s+");

            switch(tokens[0]){ //prvi deo naredbe je da li je u pitanju Drive ili Refuel
                case "Drive":
                    if(tokens[1].equals("Car")){ //u slucaju da je Car
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    } else { //u slucaju da je Truck
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "Refuel": //punjenje rezervoara
                    if(tokens[1].equals("Car")){
                        car.refuel(Double.parseDouble(tokens[2])); //treci clan niza je broj litara
                    } else {
                        truck.refuel(Double.parseDouble(tokens[2]));
                    }
                    break;
            }
        }
        System.out.println(car.toString()); //na kraju stampamo Car i koliko je goriva preostalo
        System.out.println(truck.toString()); //na kraju stampamo Truck i koliko je goriva preostalo
    }
}
