package Wild_Farm;

import java.text.DecimalFormat;

public class Mammal extends Animal{

    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        } else {
            String animalType = "Zebras";
            if (this.getClass().getSimpleName().equals("Mouse")) {
                animalType = "Mice";
            }
            System.out.println(animalType + " are not eating that type of food!");
        }

    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s]",this.getAnimalType(),
                this.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten()
                );
    }
}
