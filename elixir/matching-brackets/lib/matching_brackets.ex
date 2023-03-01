defmodule MatchingBrackets do
  @doc """
  Checks that all the brackets and braces in the string are matched correctly, and nested correctly
  """
  @spec check_brackets(String.t()) :: boolean
  def check_brackets(""), do: true

  def check_brackets(str) do
    str
    |> String.graphemes()
    |> match_brackets([])
  end

  defp match_brackets([], []), do: true

  defp match_brackets([h | t], stack) when h not in ["[", "(", "{", "}", ")", "]"],
    do: match_brackets(t, stack)

  defp match_brackets([h | t], stack) when h in ["[", "(", "{"],
    do: match_brackets(t, [h | stack])

  defp match_brackets(["]" | rest], ["[" | t]), do: match_brackets(rest, t)
  defp match_brackets([")" | rest], ["(" | t]), do: match_brackets(rest, t)
  defp match_brackets(["}" | rest], ["{" | t]), do: match_brackets(rest, t)
  defp match_brackets(_, _), do: false

end
