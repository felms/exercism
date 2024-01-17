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
  def generate(_coins, 0), do: {:ok, []}

  def generate(coins, target) do
    map =
      (0..target)
      |> Enum.reduce(%{}, fn current_target, combinations ->
        smallest_combination(combinations, coins |> Enum.sort(:desc), current_target)
      end)

    case map[target] do
      nil -> {:error, "cannot change"}
      _ -> {:ok, map[target]}
    end
  end

  defp smallest_combination(combinations, [], _), do: combinations
  defp smallest_combination(combinations, [target | _], target), do: Map.put(combinations, target, [target])

  defp smallest_combination(combinations, [coin | coins], target)
       when coin > target,
       do: smallest_combination(combinations, coins, target)

  defp smallest_combination(combinations, [coin | coins] = coins_list, target) do
    map = smallest_combination(combinations, coins_list, target - coin)

    if map[target - coin] == nil do
      smallest_combination(combinations, coins, target)
    else
      Map.put(map, target, map[target - coin] ++ [coin])
    end
  end
end
