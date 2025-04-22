public class Lion extends Animal implements RunningAnimal{
    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }
    public void run(){
        System.out.println("Lion is running!");
    }
}
