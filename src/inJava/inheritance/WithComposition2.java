package inJava.inheritance;

import static java.lang.System.out;

// Using composition and interfaces to recoup both
// code reuse *and* polymorphism.
class WithComposition2 {
    static void compositionProgram(){
        Pet pet = new Pet("any",0);
        Dog dog = new Dog("Lassie",4);
        Cat cat = new Cat("Misse",5,false);
        // Still can't do this:
        // pet = dog;
        // But we can now do this:
        CanSpeak aSpeakingPet = dog;

        // Use delegated methods
        out.println(dog.say());
        out.println(aSpeakingPet.say());
        out.println(cat.say());
    }

    static interface CanSpeak {
        String say();
    }

    static interface IsPet {
        String getName();

        int getAge();
    }


    static class Pet implements IsPet {
        private final String name;
        private final int age;

        protected Pet(String name, int age) {
            // ... and initialize their values inside constructor.
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    static class Dog implements CanSpeak, IsPet {
        // Dog is still an extension of Pet - not a subclass, we extend it manually
        // by *composing* it with an object of Pet, the methods of which we
        // can then use.
        private final Pet superPet;
        public Dog(String name, int age){
            this.superPet = new Pet(name, age);
        }

        // get_name() and get_age() implemented through *delegation*,
        // i.e. passing the call on to the helper class.
        public String getName() {
            return superPet.getName();
        }

        public int getAge() {
            return superPet.getAge();
        }

        @Override
        public String say() {
            return getName() + " says Arf";
        }
    }

    static class Cat implements CanSpeak, IsPet {
        private final WithComposition1.Pet superPet;
        boolean isEvil;

        public Cat(String name, int age, boolean isEvil){
            this.superPet = new WithComposition1.Pet(name, age);
        }

        // get_name() and get_age() implemented through *delegation*,
        // i.e. passing the call on to the helper class.
        public String getName() {
            return superPet.getName();
        }

        public int getAge() {
            return superPet.getAge();
        }

        @Override
        public String say() {
            return getName() + " says Meow";
        }

        boolean isEvil(){ return this.isEvil; }

    }

    // The Java "invocation" to make a class executable
    public static void main(String[] args) {
        compositionProgram();
    }
}
