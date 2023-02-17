defmodule RunLengthEncoder do
  @doc """
  Generates a string where consecutive elements are represented as a data value and count.
  "AABBBCCCC" => "2A3B4C"
  For this example, assume all input are strings, that are all uppercase letters.
  It should also be able to reconstruct the data into its original form.
  "2A3B4C" => "AABBBCCCC"
  """
  @spec encode(String.t()) :: String.t()
  def encode(""), do: ""

  def encode(string) do
    String.graphemes(string)
    |> Enum.chunk_by(fn item -> item end)
    |> Enum.map(&do_encode/1)
    |> Enum.join()
  end

  @spec decode(String.t()) :: String.t()
  def decode(""), do: ""

  def decode(string) do
    String.split(string, ~r{\d+\D|\D}, include_captures: true, trim: true)
    |> Enum.map(&do_decode/1)
    |> Enum.join()
  end

  defp do_encode([letter]), do: letter
  defp do_encode(list), do: "#{length(list)}#{hd(list)}"

  defp do_decode(string) do
    cond do
      string =~ ~r{\d+\D} ->
        [repetitions, letter] = String.split(string, ~r{\d+}, include_captures: true, trim: true)
        String.duplicate(letter, String.to_integer(repetitions))

      true ->
        string
    end
  end
end
