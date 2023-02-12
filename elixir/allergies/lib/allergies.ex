defmodule Allergies do
  @allergens [
    "cats",
    "pollen",
    "chocolate",
    "tomatoes",
    "strawberries",
    "shellfish",
    "peanuts",
    "eggs"
  ]

  @doc """
  List the allergies for which the corresponding flag bit is true.
  """
  @spec list(non_neg_integer) :: [String.t()]
  def list(0), do: []

  def list(flags) do
    flags
    |> Integer.digits(2)
    |> pad_list()
    |> Enum.zip(@allergens)
    |> Enum.filter(fn {flag, _item} -> flag == 1 end)
    |> Enum.map(fn {_flag, item} -> item end)
  end

  @doc """
  Returns whether the corresponding flag bit in 'flags' is set for the item.
  """
  @spec allergic_to?(non_neg_integer, String.t()) :: boolean
  def allergic_to?(flags, item) do
    item in list(flags)
  end

  defp pad_list(list) when length(list) == 8, do: list
  defp pad_list([_h | tail] = list) when length(list) > 8, do: pad_list(tail)
  defp pad_list(list), do: pad_list([0 | list])
end
