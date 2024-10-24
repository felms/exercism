ONE_HOUR = 60
ONE_DAY = 1440


class Clock:
    def __init__(self, hour, minute):
        m = hour * ONE_HOUR + minute
        self.minutes = m % ONE_DAY

    def __repr__(self):
        return f'Clock({self.minutes // ONE_HOUR}, {self.minutes % ONE_HOUR})'

    def __str__(self):
        return '{:02d}'.format(self.minutes // ONE_HOUR) \
                + ':' + '{:02d}'.format(self.minutes % ONE_HOUR)

    def __eq__(self, other):
        return str(self) == str(other)

    def __add__(self, minutes):
        return Clock(0, self.minutes + minutes)

    def __sub__(self, minutes):
        return Clock(0, self.minutes - minutes)
