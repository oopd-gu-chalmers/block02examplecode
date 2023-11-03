package inJava.inheritance;

import static java.lang.System.out;

// Eliminating redundant code using a common superclass
//
// To be continued: See Inheritance3
class Inheritance2 {
    static void inheritanceProgram() {
        Pet _pet = new Pet("any", 0); // Passes type checker, but senseless
        Dog dog = new Dog("Lassie",4);
        Cat cat = new Cat("Misse",5,false);

        // Use duplicated methods
        out.println(dog.getName() + ":" + dog.getAge());
        out.println(cat.getName() + ":" + cat.getAge());
    }

    static class Pet {
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
    }

    static class Dog extends Pet {
        Dog(String name, int age) {
            super(name, age);
        }

        // getName() and getAge() inherited but invisible
    }

    static class Cat extends Pet {
        private boolean isEvil;

        Cat(String name, int age, boolean isEvil) {
            super(name, age);
            this.isEvil = isEvil;
        }

        // getName() and getAge() inherited but invisible

        boolean isEvil() {
            return this.isEvil;
        }

    }
    public static void main(String[] args) {
        inheritanceProgram();
    }
}
