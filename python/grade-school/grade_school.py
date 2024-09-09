class School:
    def __init__(self):
        self._roster = {}
        self._added = []

    def add_student(self, name, grade):

        if name not in self.roster():
            self._roster[grade] = self._roster.get(grade, []) + [name]
            self._added.append(True)
        else:
            self._added.append(False)

    def roster(self):
        return [student
                for grade in sorted(self._roster.keys())
                for student in sorted(self._roster[grade])]

    def grade(self, grade_number):
        return sorted(self._roster.get(grade_number, []))

    def added(self):
        return self._added
