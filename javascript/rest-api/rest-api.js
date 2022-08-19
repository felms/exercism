export class RestAPI {

  #db;
  constructor(caloteiros) {
    this.#db = { users: [] };
    caloteiros.users.forEach(user => this.#db.users.push(user));
  }

  get(url) {
    let request = url.split('?');

    if (request.length === 1) {
      return this.#db;
    }

    let searchedUser = request[1].split('=')[1];
    let filteredUsers = [
      ...
      this.#db.users.filter(user => user.name === searchedUser)
    ];

    return { users: filteredUsers };
  }

  post(url, payload) {

    switch(url) {
      case '/add':
        return this.addUser(payload);
      case '/iou':
        return this.iou(payload);
    }
  }

  addUser(userToAdd) {
    let u = {
      name: userToAdd.user,
      owes: {},
      owed_by: {},
      balance: 0,
    };

    this.#db.users.push(u);

    return u;
  }

  iou(lendersBorrowers) {
    let { lender, borrower, amount } = lendersBorrowers;

    let l = this.#db.users.find(user => user.name === lender);
    let b = this.#db.users.find(user => user.name === borrower);

    if (l.owed_by[borrower]) {
      l.owed_by[borrower] = l.owed_by[borrower] + amount;
      b.owes[lender] = b.owes[lender] + amount;
    } else if (l.owes[borrower]) {
      let debt = l.owes[borrower] - amount;
      if (debt > 0) {
        l.owes[borrower] = debt;
        b.owed_by[lender] = debt;
      } else {
        delete l.owes[borrower];
        delete b.owed_by[lender];

        if (debt < 0) {
          l.owed_by[borrower] = Math.abs(debt);
          b.owes[lender] = Math.abs(debt);
        }
      }
    } else {
      l.owed_by[borrower] = amount;
      b.owes[lender] = amount;
    }
    l.balance = l.balance + amount;
    b.balance = b.balance - amount;


    // Tem que ordernar essa merda senão o teste não 
    // passa mesmo com os objetos contendo os dados corretos.
    // Tomanocú viu...
    let u = [l, b];
    u.sort((a, c) => (a.name > c.name) ? 1 : ((c.name > a.name) ? -1 : 0));
    let ret = { users: u };

    return ret;
  }
}
