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
    new_q = 
      item.quantity_by_size
      |> Enum.reduce(%{}, fn {size, qty}, acc -> 
        put_in(acc, [size], qty + count) 
      end)

    put_in(item.quantity_by_size, new_q)
  end

  def total_quantity(item) do
    Enum.sum(
      Enum.map(item.quantity_by_size, fn {_size, qty} -> qty end)
    )
  end
end
