package inJava.inheritance;

import static java.lang.System.out;

// Problem! These classes have the same instance variables and methods.
// Plenty of duplicated code! How can we fix?
//
// To be continued: See Inheritance2
class Inheritance1 {
    static void inheritanceProgram() {
        Dog dog = new Dog("Lassie",4);
        Cat cat = new Cat("Misse",5,false);

        // Use duplicated methods
        out.println(dog.getName() + ":" + dog.getAge());
        out.println(cat.getName() + ":" + cat.getAge());
    }

    static class Dog {
        private String name;
        private int age;
        Dog(String name, int age){
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

    static class Cat {
        private String name;
        private int age;
        private boolean isEvil;

        public Cat(String name, int age, boolean isEvil){
            this.name = name;
            this.age = age;
            this.isEvil = isEvil;
        }

        // get_name() and get_age() implemented through *delegation*,
        // i.e. passing the call on to the helper class.
        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        boolean isEvil() {
            return isEvil;
        }
    }
    public static void main(String[] args) {
        inheritanceProgram();
    }
}
