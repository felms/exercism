defmodule Transpose do
  @doc """
  Given an input text, output it transposed.

  Rows become columns and columns become rows. See https://en.wikipedia.org/wiki/Transpose.

  If the input has rows of different lengths, this is to be solved as follows:
    * Pad to the left with spaces.
    * Don't pad to the right.

  ## Examples

  iex> Transpose.transpose("ABC\\nDE")
  "AD\\nBE\\nC"

  iex> Transpose.transpose("AB\\nDEF")
  "AD\\nBE\\n F"
  """

  @spec transpose(String.t()) :: String.t()
  def transpose(""), do: ""

  def transpose(input) do
    lists =
      input
      |> String.split("\n")
      |> pad_lists()
      |> Enum.map(&String.graphemes/1)

    lists
    |> Enum.zip()
    |> Enum.map(&Tuple.to_list/1)
    |> Enum.map(&Enum.join/1)
    |> Enum.map(&String.trim_trailing(&1, "@"))
    |> Enum.join("\n")
    |> String.replace("@", " ")
  end

  defp pad_lists(strings) do
    max_length =
      strings
      |> Enum.map(&String.length/1)
      |> Enum.max()

    strings
    |> Enum.map(&String.pad_trailing(&1, max_length, "@"))
  end
end
