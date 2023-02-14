defmodule Proverb do
  @doc """
  Generate a proverb from a list of strings.
  """
  @spec recite(strings :: [String.t()]) :: String.t()
  def recite([]), do: ""

  def recite(strings) do
    strings
    |> Enum.chunk_every(2, 1, :discard)
    |> Enum.map(&for_want_string/1)
    |> Enum.join("")
    |> Kernel.<>("And all for the want of a #{Enum.at(strings, 0)}.\n")
  end

  defp for_want_string([item_0, item_1]), do: "For want of a #{item_0} the #{item_1} was lost.\n"
end
