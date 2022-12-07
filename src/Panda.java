public class Panda extends Animal
{
    public Panda(String species, int weight, String imgpath)
    {
        super(species, weight, imgpath);
    }

    @Override
    public String animalSound()
    {
        // TODO Auto-generated method stub
        return "honk";
    }
}