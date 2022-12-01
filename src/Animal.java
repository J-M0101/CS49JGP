
abstract class Animal {
    private String species;
    private int weight;
    private String imgpath;

    public Animal(String species, int weight, String imgpath){
        this.species = species;
        this.weight = weight;
        this.imgpath = imgpath;
    }

    public final String getSpecies(){
        return species;
    }

    public final int weight(){
        return weight;
    }

    public final String imgpath(){
        return imgpath;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
