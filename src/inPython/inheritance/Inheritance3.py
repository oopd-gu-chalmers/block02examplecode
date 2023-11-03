# package python.inheritance

# Eliminating redundant code using an abstract base class
# and letting base class implement interface (i.e. all sub classes
# must implement)
from abc import ABC, abstractmethod


def inheritance_program():
    # pet = Pet("any", 0)     # No longer allowed, Pet is abstract

    dog = Dog("Lassie", 4)
    cat = Cat("Misse", 5, False)

    print(isinstance(dog, Pet))
    print(isinstance(dog, CanSpeak))
    print(isinstance(dog, Dog))
    print(type(dog))

    # Use overridden methods
    print(dog.say())
    print(cat.say())


class CanSpeak(ABC):
    @abstractmethod
    def say(self):
        raise NotImplementedError


# Pet doesn't need to implement "say" since it's marked abstract (inherits from ABC)
class Pet(CanSpeak, ABC):
    def __init__(self, name: str, age: int):
        self.name = name  # Everything common for Cat and Dog here
        self.age = age

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age


class Dog(Pet):
    # def __init__(self, name: str, age: int):
    #     super().__init__(name, age)

    # Must implement say() since Dog is a non-abstract class
    def say(self):
        return f"{self.name} says Arf"

    # getName() and getAge() inherited but invisible


class Cat(Pet):
    def __init__(self, name: str, age: int, is_evil: bool):
        super().__init__(name, age)
        self.is_evil = is_evil

    # Must implement say() since Cat is a non-abstract class
    def say(self):
        return f"{self.name} says Meow"

    # get_name() and get_age() inherited but invisible

    def is_evil(self):
        return self.is_evil


if __name__ == "__main__":
    inheritance_program()
