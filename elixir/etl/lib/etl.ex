defmodule ETL do
  @doc """
  Transforms an old Scrabble score system to a new one.

  ## Examples

    iex> ETL.transform(%{1 => ["A", "E"], 2 => ["D", "G"]})
    %{"a" => 1, "d" => 2, "e" => 1, "g" => 2}
  """
  @spec transform(map) :: map
  def transform(input) do
    input
    |> Map.to_list()
    |> Enum.map(&process_entry/1)
    |> List.flatten()
    |> Map.new()
  end

  defp process_entry({value, keys}) do
    keys
    |> Enum.map(&({String.downcase(&1), value}))
  end
end
