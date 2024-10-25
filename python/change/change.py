cache = {}


def find_fewest_coins(coins, target):

    if target < 0:
        raise ValueError("target can't be negative")

    for i in range(target + 1):
        cache[i] = []

    for t in range(target + 1):
        cache[t] = calc_change(coins, t)

    if target != 0 and len(cache[target]) == 0:
        raise ValueError("can't make target with given coins")

    return cache[target]


def calc_change(coins, target):

    if target in coins:
        return [target]

    if target == 0:
        return []

    if len(cache[target]) != 0:
        return cache[target]

    best_solution = []

    for coin in coins:
        if coin <= target:
            sol = [coin] + calc_change(coins, target - coin)
            sol_sum = sum(sol)

            if (sol_sum == target and
                    (len(best_solution) == 0 or len(sol) < len(best_solution))):
                best_solution = []
                best_solution.extend(sol)

    return best_solution
