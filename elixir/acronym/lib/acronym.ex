defmodule Acronym do
  @doc """
  Generate an acronym from a string.
  "This is a string" => "TIAS"
  """
  @spec abbreviate(String.t()) :: String.t()
  def abbreviate(string) do
    string
    |> String.upcase()
    |> String.split(~r/[\s_-]/, trim: true)
    |> Enum.map(&String.first/1)
    |> Enum.join()
  end
end
