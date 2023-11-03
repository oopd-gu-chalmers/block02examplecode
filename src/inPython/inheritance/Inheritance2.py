# package python.inheritance

# Eliminating redundant code using a common superclass
# 
# To be continued: See Inheritance3
def inheritance_program():
    _pet = Pet("any", 0)  # Ok, but senseless
    dog = Dog("Lassie", 4)
    cat = Cat("Misse", 5, False)

    # Use inherited methods
    print(f"{dog.get_name()}:{dog.get_age()}")
    print(f"{cat.get_name()}:{cat.get_age()}")


class Pet:
    def __init__(self, name: str, age: int):
        self.name = name  # Everything common for Cat and Dog here
        self.age = age

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age


# Dog is subclass to Pet, will inherit all from super type
class Dog(Pet):
    def __init__(self, name: str, age: int):
        super().__init__(name, age)

    # get_name() and get_age() inherited but invisible


class Cat(Pet):
    def __init__(self, name: str, age: int, is_evil: bool):
        super().__init__(name, age)
        self.is_evil = is_evil

    # get_name() and get_age() inherited but invisible

    def is_evil(self):
        return self.is_evil


if __name__ == "__main__":
    inheritance_program()
