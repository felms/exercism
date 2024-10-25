def find_fewest_coins(coins, target):

    if target < 0:
        raise ValueError("target can't be negative")

    res = calc_change(coins, target)

    if target != 0 and len(res) == 0:
        raise ValueError("can't make target with given coins")

    return res


def calc_change(coins, target):

    if target in coins:
        return [target]

    if target == 0:
        return []

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
