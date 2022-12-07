
abstract class Animal implements Characteristics
{
    private String species;
    private int weight;
    private String imgPath;

    public Animal(String species, int weight, String imgPath){
        this.species = species;
        this.weight = weight;
        this.imgPath = imgPath;
    }

    public final String getSpecies(){
        return species;
    }

    public final int getWeight(){
        return weight;
    }

    public final String getImgPath(){
        return imgPath;
    }

}
