defmodule Luhn do
  @doc """
  Checks if the given number is valid via the luhn formula
  """
  @spec valid?(String.t()) :: boolean
  def valid?(number) do
    String.length(String.trim(number)) > 1 and number =~ ~r/^[\s\d]+$/ and
      rem(luhn_sum(number), 10) == 0
  end

  defp luhn_sum(number) do
    number
    |> String.replace(" ", "")
    |> Kernel.<>("0")
    |> String.reverse()
    |> String.graphemes()
    |> Enum.map(&String.to_integer/1)
    |> Enum.map_every(2, fn digit ->
      number = digit * 2

      if number > 9 do
        number - 9
      else
        number
      end
    end)
    |> Enum.sum()
  end
end
