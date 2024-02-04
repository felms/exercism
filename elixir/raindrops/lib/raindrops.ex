defmodule Raindrops do
  @doc """
  Returns a string based on raindrop factors.

  - If the number contains 3 as a prime factor, output 'Pling'.
  - If the number contains 5 as a prime factor, output 'Plang'.
  - If the number contains 7 as a prime factor, output 'Plong'.
  - If the number does not contain 3, 5, or 7 as a prime factor,
    just pass the number's digits straight through.
  """

  @raindrops_lookup [
    {3, "Pling"},
    {5, "Plang"},
    {7, "Plong"}
  ]

  @spec convert(pos_integer) :: String.t()
  def convert(number) do
    do_convert(number, @raindrops_lookup, "")
  end

  defp do_convert(number, [], ""), do: Integer.to_string(number)
  defp do_convert(_number, [], string), do: string

  defp do_convert(number, [{factor, output} | tail], string) when rem(number, factor) == 0,
    do: do_convert(number, tail, string <> output)

  defp do_convert(number, [_ | tail], string), do: do_convert(number, tail, string)
end
