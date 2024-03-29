package Wild_Farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int counter = 0;
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("End")) {
            String [] lines = input.split("\\s+");
            if (counter % 2 == 0) {
                String animalType = lines[0];
                String animalName = lines[1];
                Double animalWeight = Double.parseDouble(lines[2]);
                String animalLivingRegion = lines[3];
                if (animalType.equals("Cat")) {
                    String breed = lines[4];
                    animal = new Cat(animalName,animalType,animalWeight,animalLivingRegion,breed);

                }else if (animalType.equals("Tiger")) {
                    animal = new Tiger(animalName,animalType,animalWeight,animalLivingRegion);

                }else if (animalType.equals("Zebra")) {

                    animal = new Zebra(animalName,animalType,animalWeight,animalLivingRegion);

                }else if (animalType.equals("Mouse")) {
                    animal = new Mouse(animalName,animalType,animalWeight,animalLivingRegion);

                }
                animals.add(animal);

            } else {
                String foodType = lines[0];
                int foodQuantity = Integer.parseInt(lines[1]);
                Food food = null;
                if (foodType.equals("Meat")) {
                    food = new Meat(foodQuantity);
                } else {
                    food = new Vegetable(foodQuantity);
                }
                animals.get(animals.size() - 1).makeSound();
                animals.get(animals.size() - 1).eat(food);

            }


            counter++;
            input = br.readLine();
        }
        animals.forEach(System.out::println);


    }
}
