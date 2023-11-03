# package python.inheritance

# Using composition and pure interfaces to recoup both
# code reuse and polymorphism.
from abc import ABC, abstractmethod


def inheritance_program():
    # pet = Pet("any", 0)     # Can't do this any more, Pet is abstract

    dog = Dog("Lassie", 4)
    cat = Cat("Misse", 5, False)
    # Still can't do this without a warning:
    pet : Pet = dog
    # But we can now do this:
    a_speaking_pet: CanSpeak = dog

    # Use overridden methods
    print(dog.say())
    print(a_speaking_pet.say())
    print(cat.say())


class CanSpeak(ABC):
    @abstractmethod
    def say(self):
        raise NotImplementedError


class IsPet(ABC):
    @abstractmethod
    def get_name(self):
        raise NotImplementedError

    def get_age(self):
        raise NotImplementedError


class Pet(IsPet, ABC):
    def __init__(self, name: str, age: int):
        self.name = name  # Everything common for Cat and Dog here
        self.age = age

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age


class Dog(CanSpeak, IsPet):
    def __init__(self, name: str, age: int):
        self.__pet = Pet(name, age)

    # Must implement say() since Dog is a non-abstract class
    def say(self):
        return f"{self.get_name()} says Arf"

    def get_name(self):
        return self.__pet.get_name()

    def get_age(self):
        return self.__pet.get_age()


class Cat(CanSpeak, IsPet):
    def __init__(self, name: str, age: int, is_evil: bool):
        self.__pet = Pet(name, age)
        self.is_evil = is_evil

    # Must implement say() since Cat is a non-abstract class
    def say(self):
        return f"{self.get_name()} says Meow"

    def get_name(self):
        return self.__pet.get_name()

    def get_age(self):
        return self.__pet.get_age()

    # get_name() and get_age() inherited but invisible

    def is_evil(self):
        return self.is_evil


if __name__ == "__main__":
    inheritance_program()
