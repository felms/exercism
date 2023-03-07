defmodule CustomSet do
  @opaque t :: %__MODULE__{items: list}
  defstruct items: []

  @spec new(Enum.t()) :: t
  def new(enumerable) do
    values = Enum.uniq(enumerable)
    %CustomSet{items: values}
  end

  @spec empty?(t) :: boolean
  def empty?(custom_set), do: custom_set.items |> Enum.empty?()

  @spec contains?(t, any) :: boolean
  def contains?(custom_set, element), do: element in custom_set.items

  @spec subset?(t, t) :: boolean
  def subset?(custom_set_1, custom_set_2) do
    sublist?(custom_set_1.items, custom_set_2.items)
  end

  defp sublist?([], _), do: true
  defp sublist?(_, []), do: false
  defp sublist?(list_1, list_2) do
    Enum.all?(list_1, &(&1 in list_2))
  end

  @spec disjoint?(t, t) :: boolean
  def disjoint?(custom_set_1, custom_set_2) do
    empty?(custom_set_1) or empty?(custom_set_2) or
      not Enum.any?(custom_set_1.items, &(&1 in custom_set_2.items))
  end

  @spec equal?(t, t) :: boolean
  def equal?(custom_set_1, custom_set_2) do
    subset?(custom_set_1, custom_set_2) and
      subset?(custom_set_2, custom_set_1)
  end

  @spec add(t, any) :: t
  def add(custom_set, element) do
    if element in custom_set.items do
      custom_set
    else
      %{custom_set | items: [element | custom_set.items]}
    end
  end

  @spec intersection(t, t) :: t
  def intersection(custom_set_1, custom_set_2) do
    cond do
      empty?(custom_set_1) or empty?(custom_set_2) -> new([])
      true ->
        custom_set_1.items
        |> Enum.filter(&(&1 in custom_set_2.items))
        |> new()
    end
  end

  @spec difference(t, t) :: t
  def difference(custom_set_1, custom_set_2) do
    cond do
      empty?(custom_set_1) -> custom_set_1
      empty?(custom_set_2) -> custom_set_1
      true ->
        custom_set_1.items
        |> Enum.reject(&(&1 in custom_set_2.items))
        |> new()
    end
  end

  @spec union(t, t) :: t
  def union(custom_set_1, custom_set_2) do
    custom_set_1.items
    |> Enum.reduce(custom_set_2, fn item, acc -> 
      add(acc, item)
    end)
  end
end
