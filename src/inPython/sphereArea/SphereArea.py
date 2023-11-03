# package exercises

from math import pi


# Program to calculate the surface area of a sphere
# See https://en.wikipedia.org/wiki/Sphere#Surface_area
#
# Formula is: area = 4 * pi * radius² (m²)
@staticmethod
def input_radius() -> float:
    return float(input("Give me a radius please > "))


# @staticmethod
def print_area_result(the_area: float):
    print(f"This is the area: {the_area}")


# @staticmethod
def calculate_area_of_sphere(the_radius):
    the_area: float = 4 * pi * the_radius ** 2
    return the_area


# @staticmethod
def calculate_sphere_area_program():
    the_radius: int = input_radius()
    the_area = calculate_area_of_sphere(the_radius)
    print_area_result(the_area)


# Recommended way to make module executable
if __name__ == "__main__":
    calculate_sphere_area_program()
