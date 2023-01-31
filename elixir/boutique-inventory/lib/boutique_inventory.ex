defmodule BoutiqueInventory do
  def sort_by_price(inventory) do
    Enum.sort_by(inventory, fn item -> item.price end)
  end

  def with_missing_price(inventory) do
    Enum.filter(inventory, fn item -> item.price == nil end)
  end

  def update_names(inventory, old_word, new_word) do
    Enum.map(inventory, fn item ->
      if String.contains?(item.name, old_word) do
        new_name = String.replace(item.name, old_word, new_word)
        put_in(item.name, new_name)
      else
        item
      end
    end)
  end

  def increase_quantity(item, count) do
    put_in(
      item.quantity_by_size,
      Enum.into(item.quantity_by_size, %{}, fn {k, v} -> {k, v + count} end)
    )
  end

  def total_quantity(item) do
    Enum.reduce(item.quantity_by_size, 0, fn {_size, qty}, acc -> acc + qty end)
  end
end
