defmodule PigLatin do
  @doc """
  Given a `phrase`, translate it a word at a time to Pig Latin.
  """

  @vowels ["a", "e", "i", "o", "u"]

  @spec translate(phrase :: String.t()) :: String.t()
  def translate(phrase) do
    phrase
    |> String.split(" ", trim: true)
    |> Enum.map(&String.graphemes/1)
    |> Enum.map(&to_pig_latin/1)
    |> Enum.map(&Enum.join/1)
    |> Enum.join(" ")
  end
  
  defp to_pig_latin([first_letter | _rest] = word) when first_letter in @vowels,
    do: word ++ ["a", "y"]

  defp to_pig_latin([first_letter, second_letter | _rest] = word)
       when first_letter in ["x", "y"] and second_letter not in @vowels,
       do: word ++ ["a", "y"]

  defp to_pig_latin(["q", "u" | rest]) do
    rest ++ ["q", "u", "a", "y"]
  end

  defp to_pig_latin([first_letter, "q", "u" | rest]) when first_letter not in @vowels do
    rest ++ [first_letter] ++ ["q", "u", "a", "y"]
  end

  defp to_pig_latin([first_letter | rest])
       when first_letter not in @vowels,
       do: to_pig_latin(rest ++ [first_letter])

  defp to_pig_latin([first_letter, "y" | rest]) when first_letter not in @vowels do
    ["y"] ++ rest ++ [first_letter] ++ ["a", "y"]
  end

end
