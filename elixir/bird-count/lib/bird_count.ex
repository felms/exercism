defmodule BirdCount do
  def today([]), do: nil
  def today(list) do
    list |> hd()
  end

  def increment_day_count([]), do: [1]
  def increment_day_count([today | rest]) do
    [today + 1 | rest]
  end

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?([head| rest]) do
    head === 0 or has_day_without_birds?(rest)
  end

  def total([]), do: 0
  def total([head|rest]) do
    head + total(rest)
  end

  def busy_days([]), do: 0
  def busy_days([head|rest]) when head >= 5, do: 1 + busy_days(rest)
  def busy_days([_|rest]), do: busy_days(rest)

end
