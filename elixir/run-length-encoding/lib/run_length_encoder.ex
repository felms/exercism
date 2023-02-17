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
    letters = String.graphemes(string)

    do_encode(Enum.dedup(letters), letters, [], 0)
    |> Enum.map(fn {counter, letter} ->
      cond do
        counter == 1 -> letter
        true -> "#{counter}#{letter}"
      end
    end)
    |> Enum.join()
  end

  @spec decode(String.t()) :: String.t()
  def decode(""), do: ""

  def decode(string) do
    String.split(string, ~r{\d+\D|\D}, include_captures: true, trim: true)
    |> Enum.map(&do_decode/1)
    |> Enum.join()
  end

  defp do_encode([letter | _], [], acc, counter),
    do: List.insert_at(acc, -1, {counter, letter})

  defp do_encode([letter | letters], [letter | other_chars], acc, counter),
    do: do_encode([letter | letters], other_chars, acc, counter + 1)

  defp do_encode([letter | letters], [repeated_char | other_chars], acc, counter) do
    do_encode(
      letters,
      [repeated_char | other_chars],
      List.insert_at(acc, -1, {counter, letter}),
      0
    )
  end

  defp do_decode(string) do
    cond do
      string =~ ~r{\d+\D} ->
        [repetitions, letter] = String.split(string, ~r{\d+}, include_captures: true, trim: true)
        list = for _ <- 1..String.to_integer(repetitions), do: letter
        Enum.join(list)

      true ->
        string
    end
  end
end
