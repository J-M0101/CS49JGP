public class Chicken extends Animal {
    public Chicken(String species, int weight, String imgpath) {
        super(species, weight, imgpath);
    }

    @Override
    public String animalSound()
    {
        // TODO Auto-generated method stub
        return "cluck";
    }
}
