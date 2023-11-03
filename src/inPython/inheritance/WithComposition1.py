# package python.inheritance

# Eliminating redundant code using a helper class and composition
# Note: this is how we could/would/should do it when *not* using inheritance.
#
# To be continued: See Composition2
def inheritance_program():
    _pet: Pet = Pet("any", 0)  # Ok, but senseless
    dog: Dog = Dog("Lassie", 4)
    cat: Cat = Cat("Misse", 5, False)
    _pet = dog  # Note the type mismatch warning here; Dog is *not* of *type* Pet.

    # Use delegated methods
    print(f"{dog.get_name()}:{dog.get_age()}")
    print(f"{cat.get_name()}:{cat.get_age()}")


class Pet:
    # Everything common for Cat and Dog here
    def __init__(self, name: str, age: int):
        # We initialize instance attributes inside constructor.
        self.__name = name
        self.__age = age

    def get_name(self):
        return self.__name

    def get_age(self):
        return self.__age


# Dog is an extension of Pet - not a subclass, we extend it manually
# by *composing* it with an object of Pet, the methods of which we
# can then use.
class Dog:
    def __init__(self, name: str, age: int):
        self.__pet = Pet(name, age)

    # get_name() and get_age() implemented through delegation,
    # i.e. passing the call on to the helper class.
    def get_name(self):
        return self.__pet.get_name()

    def get_age(self):
        return self.__pet.get_age()


# Cat is also based on Pet, but adds more functionality
class Cat:
    def __init__(self, name: str, age: int, is_evil: bool):
        self.__pet = Pet(name, age)
        self.__is_evil = is_evil

    # get_name() and get_age() implemented through delegation,
    # i.e. passing the call on to the helper class.
    def get_name(self):
        return self.__pet.get_name()

    def get_age(self):
        return self.__pet.get_age()

    def is_evil(self):
        return self.__is_evil


# The Python "invocation" to make a file executable (well, kind of).
if __name__ == "__main__":
    inheritance_program()
