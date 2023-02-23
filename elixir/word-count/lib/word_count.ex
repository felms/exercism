defmodule WordCount do
  @doc """
  Count the number of words in the sentence.

  Words are compared case-insensitively.
  """
  @spec count(String.t()) :: map
  def count(sentence) do
    sentence
    |> String.downcase()
    |> String.split(~r/[^-a-z0-9\x7f-\xff']/, trim: true)
    |> Enum.map(&String.replace(&1, ~r/(^'|'$)/, ""))
    |> Enum.frequencies()
  end
end
