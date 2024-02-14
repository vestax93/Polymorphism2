package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//OVAJ ZADATAK NA JUDGE-U SE NALAZI U OKVIRU LAB DELA 4. WILD FARM
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int counter = 0;
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();

        while(!input.equals("End")){
            String[] lines = input.split("\\s+");
            if(counter % 2 == 0){ //provera da li je paran unos ili ne (paran unos - Animal, neparan unos - Food)
                String animalType = lines[0];
                String animalName = lines[1];
                double animalWeight = Double.parseDouble(lines[2]);
                String animalLivigRegion = lines[3];
                if(animalType.equals("Cat")){
                    String breed = lines[4]; //Cat ima jedno polje vise, a to je breed osnosno rasa
                    animal = new Cat(animalName,animalType,animalWeight,animalLivigRegion,breed);
                } else if(animalType.equals("Tiger")){
                    animal = new Tiger(animalName,animalType,animalWeight,animalLivigRegion);
                } else if(animalType.equals("Zebra")){
                    animal = new Zebra(animalName,animalType,animalWeight,animalLivigRegion);
                } else if(animalType.equals("Mouse")){
                    animal = new Mouse(animalName,animalType,animalWeight,animalLivigRegion);
                }
                    animals.add(animal); //dodajemo u listu svih zivotinja
            } else {
                String foodType = lines[0];
                int foodQuantity = Integer.parseInt(lines[1]);
                Food food = null;
                if(foodType.equals("Meat")){
                    food = new Meat(foodQuantity);
                } else {
                    food = new Vegetable(foodQuantity);
                }
                animals.get(animals.size() - 1).makeSound(); //uzimamo poslednju zivotinju
                animals.get(animals.size() - 1).eat(food); //uzimamo poslednju zivotinju i dajemo joj unetu hranu
            }
            counter++;
            input = br.readLine();
        }
        animals.forEach(System.out::println);
    }
}
