public class Cat extends Animal
{
    public Cat(String species, int weight, String imgpath)
    {
        super(species, weight, imgpath);
    }

    @Override
    public void animalSound() {
        // TODO Auto-generated method stub
        System.out.println("meow");
    }
}