package inJava.inheritance;

import static java.lang.System.out;

// Eliminating redundant code using a helper class and composition.
// Note: this is how we could/would/should do it when *not* using inheritance.
//
// To be continued: See Composition2

class WithComposition1 {
    static void compositionProgram() {
        Pet pet = new Pet("any",0);  // Passes type checker, but senseless
        Dog dog = new Dog("Lassie",4);
        Cat cat = new Cat("Misse",5,false);
        // Static type error below; Dog is *not* a subtype of Pet in this scheme.
        // This means no (subtype) polymorphism.
        // pet = dog;

        // Use delegated methods
        out.println(dog.getName() + ":" + dog.getAge());
        out.println(cat.getName() + ":" + cat.getAge());
    }

    static class Pet {
        // Everything common for Cat and Dog here.
        // We must declare instance attributes outside constructor.
        private final String name;
        private final int age;
        Pet(String name, int age) {
            // ... and initialize their values inside constructor.
            this.name = name;
            this.age = age;
        }

        String getName(){
            return this.name;
        }

        int getAge() {
            return this.age;
        }
    }

    // Dog is an extension of Pet - not a subclass, we extend it manually
    // by *composing* it with an object of Pet, the methods of which we
    // can then use.
    static class Dog {
        private final Pet superPet;
        Dog(String name, int age){
            this.superPet = new Pet(name, age);
        }

        // get_name() and get_age() implemented through *delegation*,
        // i.e. passing the call on to the helper class.
        String getName() {
            return superPet.getName();
        }

        int getAge() {
            return superPet.getAge();
        }
    }

    // Cat is also based on Pet, but adds more functionality
    static class Cat {
        private final Pet superPet;
        boolean isEvil;

        Cat(String name, int age, boolean isEvil){
            this.superPet = new Pet(name, age);
        }

        // get_name() and get_age() implemented through *delegation*,
        // i.e. passing the call on to the helper class.
        String getName() {
            return superPet.getName();
        }

        int getAge() {
            return superPet.getAge();
        }

        boolean isEvil(){ return this.isEvil; }
    }

    // The Java "invocation" to make a class executable
    public static void main(String[] args) {
        compositionProgram();
    }
}
