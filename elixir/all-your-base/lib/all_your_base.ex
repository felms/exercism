defmodule AllYourBase do
  @doc """
  Given a number in input base, represented as a sequence of digits, converts it to output base,
  or returns an error tuple if either of the bases are less than 2
  """

  @spec convert(list, integer, integer) :: {:ok, list} | {:error, String.t()}
  def convert(_digits, input_base, _output_base) when input_base < 2,
    do: {:error, "input base must be >= 2"}

  def convert(_digits, _input_base, output_base) when output_base < 2,
    do: {:error, "output base must be >= 2"}

  def convert([], _input_base, _output_base), do: {:ok, [0]}

  def convert(digits, input_base, output_base) do
    if not valid_input?(digits, input_base) do
      {:error, "all digits must be >= 0 and < input base"}
    else
      res =
        digits
        |> convert_to_base_10(input_base)
        |> convert_from_base_10(output_base, [])

      {:ok, res}
    end
  end

  defp convert_to_base_10(digits, input_base) do
    digits
    |> Enum.reverse()
    |> Enum.with_index()
    |> Enum.reduce(0, fn {digit, index}, acc ->
      digit * Integer.pow(input_base, index) + acc
    end)
  end

  defp convert_from_base_10(0, _output_base, []), do: [0]
  defp convert_from_base_10(0, _output_base, res), do: res

  defp convert_from_base_10(number, output_base, res) do
    convert_from_base_10(div(number, output_base), output_base, [rem(number, output_base) | res])
  end

  defp valid_input?(digits, input_base) do
    Enum.all?(digits, &(&1 >= 0 && &1 < input_base))
  end
end
