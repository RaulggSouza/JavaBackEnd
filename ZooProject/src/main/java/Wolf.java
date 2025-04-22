public class Wolf extends Animal implements RunningAnimal{
    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }
    public void run(){
        System.out.println("Wolf is running!");
    }
}
