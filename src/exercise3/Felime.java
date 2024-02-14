package exercise3;

public abstract class Felime extends Mammal{

    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) { //pojesce hranu bez provere da li je Meat ili Vegetable (sto je default ponasanje za macku, za Tigra ce biti drugacije definisano kod njega u klasi)
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }


}
