public class Cat extends Animal
{
    public Cat(String species, int weight, String imgpath)
    {
        super(species, weight, imgpath);
    }

    @Override
    public String animalSound()
    {
        // TODO Auto-generated method stub
        return "meow";
    }

}