defmodule Anagram do
  @doc """
  Returns all candidates that are anagrams of, but not equal to, 'base'.
  """
  @spec match(String.t(), [String.t()]) :: [String.t()]
  def match(base, candidates) do
    candidates |> Enum.filter(&anagram?(base, &1))
  end

  defp anagram?(base, candidate) do
    base_string = String.upcase(base)
    string = String.upcase(candidate)

    string != base_string and
      Enum.sort(String.to_charlist(string)) == Enum.sort(String.to_charlist(base_string))
  end
end
