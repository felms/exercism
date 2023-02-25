defmodule PrimeFactors do
  @doc """
  Compute the prime factors for 'number'.

  The prime factors are prime numbers that when multiplied give the desired
  number.

  The prime factors of 'number' will be ordered lowest to highest.
  """
  @spec factors_for(pos_integer) :: [pos_integer]
  def factors_for(number) do
    factors(number)
    |> Enum.filter(&prime?/1)
    |> prime_factors(number, [])
  end

  defp prime_factors(primes_list, number, res)
  defp prime_factors([], _number, res), do: res
  defp prime_factors(_primes_list, 0, res), do: res
  defp prime_factors([h | t] = primes_list, number, res) do
    if rem(number, h) == 0 do
      prime_factors(primes_list, div(number, h), res ++ [h])
    else
      prime_factors(t, number, res)
    end
  end

  defp prime?(number)
  defp prime?(number) when number < 2, do: false
  defp prime?(2), do: true
  defp prime?(number), do: factors(number) == [1, number]

  defp factors(number) do 
    [2] ++ Enum.to_list(1..trunc(:math.sqrt(number))//2) 
    |> Enum.reduce([], fn current_number, acc -> 
      if rem(number, current_number) == 0 do
        acc ++ [current_number] ++ [div(number, current_number)]
      else
        acc
      end
    end)
  end
end
