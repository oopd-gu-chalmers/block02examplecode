# package python.inheritance

from abc import ABC, abstractmethod


# A subclass introduces a sub*type*!
def inheritance_types_program():
    dog: Dog = Dog("Lassie", 4)
    cat: Cat = Cat("Misse", 5, False)

    pet: Pet = dog   # Use super/sub established by "extends"
    pet = cat

    speaks: CanSpeak = pet    # Yes, super/sub by implements
    print(speaks.say())
    speaks = dog        # Yes, subtype relation transitive
    print(speaks.say())
    speaks = cat        # Yes, subtype relation transitive
    print(speaks.say())

    dog = pet      # No, no super/sub, we get warnings
    dog = speaks
    cat = pet


# CanSpeak is a pure interface (though in Python we only work with abstract classes).
# It is abstract (inherits from Abstract Base Class (ABC), no instances can be created),
# and has no non-abstract methods.
class CanSpeak(ABC):
    @abstractmethod
    def say(self):
        raise NotImplementedError("CanSpeak.say not implemented")


# Pet is an abstract class (inherits from ABC = Abstract Base Class), which means
# no instances can be created, except for subtypes that python.override and implement
# all abstract methods. It is not a pure interface, since it declares non-abstract
# methods.
class Pet(CanSpeak, ABC):
    # Pet is abstract so we cannot call this constructor - except from the constructors
    # defined in subclasses.
    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age


class Dog(Pet):
    def __init__(self, name: str, age: int):
        super().__init__(name, age)

    def say(self):   # This is subtype to Pet and CanSpeak, must implement method!
        return f"{self.name} says Arf"


class Cat(Pet):
    def __init__(self, name: str, age: int, is_evil: bool):
        super().__init__(name, age)
        self.is_evil = is_evil

    def is_evil(self):
        return self.is_evil

    def say(self):
        return f"{self.name} says Meow"


if __name__ == "__main__":
    inheritance_types_program()
