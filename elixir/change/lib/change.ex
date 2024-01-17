defmodule Change do
  @doc """
    Determine the least number of coins to be given to the user such
    that the sum of the coins' value would equal the correct amount of change.
    It returns {:error, "cannot change"} if it is not possible to compute the
    right amount of coins. Otherwise returns the tuple {:ok, list_of_coins}

    ## Examples

      iex> Change.generate([5, 10, 15], 3)
      {:error, "cannot change"}

      iex> Change.generate([1, 5, 10], 18)
      {:ok, [1, 1, 1, 5, 10]}

  """

  @spec generate(list, integer) :: {:ok, list} | {:error, String.t()}
  def generate(_coins, target) when target < 0, do: {:error, "cannot change"}

  def generate(coins, target) do
    initial_list = List.duplicate(target + 1, target)

    combinations =
      0..target
      |> Enum.reduce(%{}, fn curr, acc ->
        Map.put(acc, curr, initial_list)
      end)

    map =
      0..target
      |> Enum.reduce(combinations, fn current_target, acc ->
        smallest_combination(acc, coins, current_target)
      end)

    list = map[target]

    cond do
      list == nil -> {:error, "cannot change"}
      list |> Enum.sum() > target -> {:error, "cannot change"}
      true -> {:ok, list}
    end
  end

  @spec smallest_combination(map(), list(), integer()) :: map()
  defp smallest_combination(combinations, [], _target), do: combinations

  defp smallest_combination(combinations, [target | _], target),
    do: Map.put(combinations, target, [target])

  defp smallest_combination(combinations, [coin | coins], target) when coin > target,
    do: smallest_combination(combinations, coins, target)

  defp smallest_combination(combinations, [coin | coins], target) do
    current_sol = combinations[target]
    new_sol = [coin | combinations[target - coin]]

    cond do
      current_sol == nil ->
        smallest_combination(Map.put(combinations, target, new_sol), coins, target)

      current_sol |> length() > new_sol |> length() ->
        smallest_combination(Map.put(combinations, target, new_sol), coins, target)

      true ->
        smallest_combination(combinations, coins, target)
    end
  end
end
