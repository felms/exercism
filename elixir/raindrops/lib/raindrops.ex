defmodule Raindrops do
  @doc """
  Returns a string based on raindrop factors.

  - If the number contains 3 as a prime factor, output 'Pling'.
  - If the number contains 5 as a prime factor, output 'Plang'.
  - If the number contains 7 as a prime factor, output 'Plong'.
  - If the number does not contain 3, 5, or 7 as a prime factor,
    just pass the number's digits straight through.
  """
  @spec convert(pos_integer) :: String.t()
  def convert(number) do
    ""
    |> test_pling(number)
    |> test_plang(number)
    |> test_plong(number)
    |> test_num(number)
  end

  defp test_pling(curr_str, number) do
    cond do
      rem(number, 3) == 0 -> curr_str <> "Pling"
      true -> curr_str
    end
  end

  defp test_plang(curr_str, number) do
    cond do
      rem(number, 5) == 0 -> curr_str <> "Plang"
      true -> curr_str
    end
  end

  defp test_plong(curr_str, number) do
    cond do
      rem(number, 7) == 0 -> curr_str <> "Plong"
      true -> curr_str
    end
  end

  defp test_num(curr_str, number) do
    cond do
      curr_str == "" -> Integer.to_string(number)
      true -> curr_str
    end
  end

end
