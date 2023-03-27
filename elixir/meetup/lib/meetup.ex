defmodule Meetup do
  @moduledoc """
  Calculate meetup dates.
  """
  @dow %{monday: 1, tuesday: 2, wednesday: 3, thursday: 4, friday: 5, saturday: 6, sunday: 7}

  @type weekday ::
          :monday
          | :tuesday
          | :wednesday
          | :thursday
          | :friday
          | :saturday
          | :sunday

  @type schedule :: :first | :second | :third | :fourth | :last | :teenth

  @doc """
  Calculate a meetup date.

  The schedule is in which week (1..4, last or "teenth") the meetup date should
  fall.
  """
  @spec meetup(pos_integer, pos_integer, weekday, schedule) :: Date.t()
  def meetup(year, month, weekday, schedule)
  def meetup(year, month, weekday, :teenth), do: teenth_date(year, month, weekday)
  def meetup(year, month, weekday, :first), do: date_by_descriptor(year, month, weekday, 1)
  def meetup(year, month, weekday, :second), do: date_by_descriptor(year, month, weekday, 2)
  def meetup(year, month, weekday, :third), do: date_by_descriptor(year, month, weekday, 3)
  def meetup(year, month, weekday, :fourth), do: date_by_descriptor(year, month, weekday, 4)

  def meetup(year, month, weekday, :last) do
    first_day_of_month = Date.new!(year, month, 1)

    Date.range(Date.end_of_month(first_day_of_month), first_day_of_month)
    |> Enum.filter(&(Date.day_of_week(&1) == @dow[weekday]))
    |> Enum.at(0)
  end

  defp teenth_date(year, month, weekday) do
    Date.range(Date.new!(year, month, 13), Date.new!(year, month, 19))
    |> Enum.filter(&(Date.day_of_week(&1) == @dow[weekday]))
    |> hd()
  end

  defp date_by_descriptor(year, month, weekday, descriptor) do
    first_day_of_month = Date.new!(year, month, 1)

    Date.range(first_day_of_month, Date.end_of_month(first_day_of_month))
    |> Enum.filter(&(Date.day_of_week(&1) == @dow[weekday]))
    |> Enum.at(descriptor - 1)
  end
end
