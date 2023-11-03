package inJava.inheritance;

import static java.lang.System.out;

// Eliminating redundant code using an *abstract* common superclass,
// letting superclass define the common interface that all subclasses
// must then implement.
// Note: I use interface in the general sense here, as in, the methods
// and attributes associated with the type; and not in the sense of the
// Java interface mechanism/keyword.
class Inheritance3 {
    static void inheritanceProgram() {
        // Pet _pet = new Pet("any", 0); // No longer allowed, Pet is abstract
        Dog dog = new Dog("Lassie",4);
        Cat cat = new Cat("Misse",5,false);

        out.println(dog instanceof Pet);
        out.println(dog instanceof CanSpeak);
        out.println(dog instanceof Dog);
        out.println(dog.getClass());

        // Use duplicated methods
        out.println(dog.say());
        out.println(cat.say());
    }

    static interface CanSpeak {
        String say();
    }

    // Pet doesn't need to implement "say" since it's
    // marked abstract.
    static abstract class Pet implements CanSpeak {
        private String name;
        private int age;

        Pet(String name, int age){
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        // This isn't actually needed, the signature is inherited
        // from CanSpeak; I'm just putting it here to make it explicit
        // to you that there's an abstract method in the class.
        @Override
        public abstract String say();
    }

    static class Dog extends Pet {
        Dog(String name, int age) {
            super(name, age);
        }

        @Override
        public String say() {
            return this.getName() + " says Arf";
        }

        // getName() and getAge() inherited but invisible
    }

    static class Cat extends Pet {
        private boolean isEvil;

        Cat(String name, int age, boolean isEvil) {
            super(name, age);
            this.isEvil = isEvil;
        }

        boolean isEvil() {
            return this.isEvil;
        }

        // getName() and getAge() inherited but invisible

        @Override
        public String say() {
            return this.getName() + " says Meow";
        }
    }
    public static void main(String[] args) {
        inheritanceProgram();
    }
}
