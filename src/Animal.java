
abstract class Animal {
    private String species;
    private int weight;
    private boolean bidedal;
    private int weightOfFood;
    private int areaNeeded;

    public Animal(String species, int weight, boolean bidedal, int weightOfFood, int areaNeeded){
        this.species = species;
        this.weight = weight;
        this.bidedal = bidedal;
        this.weightOfFood = weightOfFood;
        this.areaNeeded = areaNeeded;
    }

    public final String getSpecies(){
        return species;
    }

    public final int weight(){
        return weight;
    }

    public final boolean bidedal(){
        return bidedal;
    }

    public final int weightOfFood(){
        return weightOfFood;
    }

    public final int areaNeeded(){
        return areaNeeded;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
