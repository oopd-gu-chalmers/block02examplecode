# package python.inheritance

# Problem! These classes have the same instance variables and methods.
# Plenty of duplicated code! How can we fix?
# 
# To be continued: See Inheritance2
def inheritance_program():
    dog = Dog("Lassie", 4)
    cat = Cat("Misse", 5, False)

    print(f"{dog.get_name()}:{dog.get_age()}")
    print(f"{cat.get_name()}:{cat.get_age()}")


class Dog:
    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

    def get_name(self):  # <-------- Duplicate
        return self.name

    def get_age(self):  # <-------- Duplicate
        return self.age


class Cat:
    def __init__(self, name: str, age: int, is_evil: bool):
        self.name = name
        self.age = age
        self.is_evil = is_evil

    def get_name(self):  # <-------- Duplicate
        return self.name

    def get_age(self):  # <-------- Duplicate
        return self.age

    def is_evil(self):
        return self.is_evil


# The Python "invocation" to make a file executable (well, kind of).
if __name__ == "__main__":
    inheritance_program()
