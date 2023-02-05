defmodule Scrabble do
  @doc """
  Calculate the scrabble score for the word.
  """
  @spec score(String.t()) :: non_neg_integer
  def score(word) do
    word
    |> String.trim()
    |> String.upcase()
    |> String.graphemes()
    |> Enum.reduce(0, fn letter, acc ->
      acc + letter_score(letter)
    end)
  end

  defp letter_score(letter) do
    case letter do
      letter when letter in ["A", "E", "I", "O", "U", "L", "N", "R", "S", "T"] -> 1
      letter when letter in ["D", "G"] -> 2
      letter when letter in ["B", "C", "M", "P"] -> 3
      letter when letter in ["F", "H", "V", "W", "Y"] -> 4
      "K" -> 5
      letter when letter in ["J", "X"] -> 8
      letter when letter in ["Q", "Z"] -> 10
    end
  end
end
