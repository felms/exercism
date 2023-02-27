defmodule PigLatin do
  @doc """
  Given a `phrase`, translate it a word at a time to Pig Latin.
  """
  @spec translate(phrase :: String.t()) :: String.t()
  def translate(phrase) do
    phrase
    |> String.split(" ", trim: true)
    |> Enum.map(&to_pig_latin/1)
    |> Enum.join(" ")
  end

  defp to_pig_latin(word) do
    cond do
      word =~ ~r/^([aeiou]+|xr|yt).*/ -> rule_01(word)
      word =~ ~r/^[xy][bcdfghjklmnpqrstvwxz]+.*/ -> rule_01(word)
      word =~ ~r/^[bcdfghjklmnpqrstvwxz]+y.*/ -> rule_04(word)
      word =~ ~r/^[bcdfghjklmnpqrstvwxyz]?qu.*/ -> rule_03(word)
      word =~ ~r/^[bcdfghjklmnpqrstvwxyz]+.*/ -> rule_02(word)
    end
  end

  defp rule_01(word), do: word <> "ay"

  defp rule_02(word) do
    [start, rest] =
      Regex.split(~r/^[bcdfghjklmnpqrstvwxyz]+/, word, trim: true, include_captures: true)

    rest <> start <> "ay"
  end

  defp rule_03(word) do
    [start, rest] =
      Regex.split(~r/^[bcdfghjklmnpqrstvwxyz]?qu/, word, trim: true, include_captures: true)

    rest <> start <> "ay"
  end

  defp rule_04(word) do
    [start, rest] =
      Regex.split(~r/^[bcdfghjklmnpqrstvwxz]+/, word, trim: true, include_captures: true)

    rest <> start <> "ay"
  end
end
