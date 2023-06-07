class SpaceAge:

    EARTH_YEAR_IN_SECONDS = 31557600
    MERCURY_ORBITAL_PERIOD = 0.2408467
    VENUS_ORBITAL_PERIOD = 0.61519726
    MARS_ORBITAL_PERIOD = 1.8808158
    JUPITER_ORBITAL_PERIOD = 11.862615
    SATURN_ORBITAL_PERIOD = 29.447498
    URANUS_ORBITAL_PERIOD = 84.016846
    NEPTUNE_ORBITAL_PERIOD = 164.79132

    def __init__(self, seconds):
        self.age = seconds / SpaceAge.EARTH_YEAR_IN_SECONDS

    def on_earth(self):
        return round(self.age, 2)

    def on_mercury(self):
        return round(self.age / SpaceAge.MERCURY_ORBITAL_PERIOD, 2)

    def on_venus(self):
        return round(self.age / SpaceAge.VENUS_ORBITAL_PERIOD, 2)

    def on_mars(self):
        return round(self.age / SpaceAge.MARS_ORBITAL_PERIOD, 2)

    def on_jupiter(self):
        return round(self.age / SpaceAge.JUPITER_ORBITAL_PERIOD, 2)

    def on_saturn(self):
        return round(self.age / SpaceAge.SATURN_ORBITAL_PERIOD, 2)

    def on_uranus(self):
        return round(self.age / SpaceAge.URANUS_ORBITAL_PERIOD, 2)

    def on_neptune(self):
        return round(self.age / SpaceAge.NEPTUNE_ORBITAL_PERIOD, 2)
