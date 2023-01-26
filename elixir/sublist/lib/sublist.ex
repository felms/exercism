defmodule Sublist do
  @doc """
  Returns whether the first list is a sublist or a superlist of the second list
  and if not whether it is equal or unequal to the second list.
  """
  def compare([], []), do: :equal
  def compare([], _), do: :sublist
  def compare(_, []), do: :superlist
  def compare(a, a), do: :equal
  def compare(a, b) when length(a) == length(b), do: :unequal
  def compare(a, b) when length(a) < length(b) do

    cointained = 
      Enum.all?(b, fn item -> Enum.member?(a, item) end)

    if cointained do
      :sublist
    else
      :unequal
    end
  end
  def compare(a, b) when length(b) > length(a) do

    cointained = 
      Enum.all?(a, fn item -> Enum.member?(b, item) end)

    if cointained do
      :sublist
    else
      :unequal
    end
  end

end
