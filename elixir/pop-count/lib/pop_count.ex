defmodule PopCount do
  @doc """
  Given the number, count the number of eggs.
  """
  @spec egg_count(number :: integer()) :: non_neg_integer()
  def egg_count(number), do: egg_count(number, 0)

  @spec egg_count(number :: integer(), count :: integer()) :: non_neg_integer()
  defp egg_count(0, count), do: count

  defp egg_count(number, count),
    do: egg_count(Bitwise.bsr(number, 1), count + Bitwise.band(number, 1))
end
