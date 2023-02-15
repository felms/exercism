defmodule Isogram do
  @doc """
  Determines if a word or sentence is an isogram
  """
  @spec isogram?(String.t()) :: boolean
  def isogram?(""), do: true

  def isogram?(sentence) do
    sentence
    |> String.replace(~r/\W/, "")
    |> String.upcase()
    |> String.graphemes()
    |> MapSet.new()
    |> Kernel.then(fn set ->
      MapSet.size(set) == String.length(String.replace(sentence, ~r/\W/, ""))
    end)
  end
end
