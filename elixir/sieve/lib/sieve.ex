defmodule Sieve do
  @doc """
  Generates a list of primes up to a given limit.
  """
  @spec primes_to(non_neg_integer) :: [non_neg_integer]
  def primes_to(1), do: []
  def primes_to(2), do: [2]

  def primes_to(limit) do
    limit
    |> initial_values()
    |> sieve_to(limit)
    |> Enum.filter(fn {_k, v} -> v end)
    |> Enum.map(fn {k, _v} -> k end)
    |> Enum.sort()
  end

  defp sieve_to(numbers, limit), do: sieve_to(numbers, 2, limit)
  defp sieve_to(numbers, current_number, limit) when current_number == limit, do: numbers

  defp sieve_to(numbers, current_number, limit) do
    if numbers[current_number] do
      n = filter_multiples(numbers, current_number * 2, current_number, limit)
      sieve_to(n, current_number + 1, limit)
    else
      sieve_to(numbers, current_number + 1, limit)
    end
  end

  defp initial_values(limit) do
    list = for i <- 2..limit, do: {i, true}
    list |> Map.new()
  end

  defp filter_multiples(numbers, number, _step, limit) when number > limit, do: numbers

  defp filter_multiples(numbers, number, step, limit) do
    n = numbers |> Map.put(number, false)
    filter_multiples(n, number + step, step, limit)
  end
end
