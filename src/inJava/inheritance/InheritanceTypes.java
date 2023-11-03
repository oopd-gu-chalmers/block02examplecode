package inJava.inheritance;

import static java.lang.System.out;

// A subclass introduces a sub*type*!
class InheritanceTypes {
    static void inheritanceTypesProgram(){
        Dog dog = new Dog("Lassie",4);
        Cat cat = new Cat("Misse",5,false);

        Pet pet = dog; // Use super/sub established by "extends"
        pet = cat;

        CanSpeak speaks = pet; // Yes, super/sub established by implements
        out.println(speaks.say());
        speaks = dog;  // Yes, subtype relation transitive
        out.println(speaks.say());
        speaks = cat;  // Yes, subtype relation transitive
        out.println(speaks.say());

        /*
         None of these work, no subtype relations
         dog = pet;
         dog = speaks;
         cat = pet;
        */


    }

    // CanSpeak is a pure interface, a specification of a type.
    // It is implicitly abstract (no instances can be created),
    // and has no non-abstract methods.
    static interface CanSpeak {
        String say();
    }

    // Pet is an abstract class, which means no instances can be
    // created, except for subtypes that override and implement
    // all abstract methods. It is not a pure interface, since it
    // declares non-abstract methods (and attributes).
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
        inheritanceTypesProgram();
    }
}
