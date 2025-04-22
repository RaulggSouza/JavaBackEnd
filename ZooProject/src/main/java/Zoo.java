public class Zoo {
    public static void main(String[] args) {
        Animal[] cage = {new Owl(), new Wolf(), new Lion(), new Owl(), new Wolf(), new Lion(), new Owl(), new Wolf(),
                new Lion(), new Wolf()};
        for (Animal animal : cage) {
            animal.makeSound();
            if (animal instanceof RunningAnimal runningAnimal){
                runningAnimal.run();
            }
        }
    }
}
