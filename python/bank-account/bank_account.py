class BankAccount:
    def __init__(self):
        self.balance = 0
        self.account_open = False

    def get_balance(self):
        if not self.account_open:
            raise ValueError("account not open")

        return self.balance

    def open(self):
        if self.account_open:
            raise ValueError("account already open")

        self.account_open = True

    def deposit(self, amount):
        if not self.account_open:
            raise ValueError("account not open")

        if amount <= 0:
            raise ValueError("amount must be greater than 0")

        self.balance += amount

    def withdraw(self, amount):
        if not self.account_open:
            raise ValueError("account not open")

        if amount > self.balance:
            raise ValueError("amount must be less than balance")

        if amount <= 0:
            raise ValueError("amount must be greater than 0")

        self.balance -= amount

    def close(self):
        if not self.account_open:
            raise ValueError("account not open")

        self.balance = 0
        self.account_open = False
