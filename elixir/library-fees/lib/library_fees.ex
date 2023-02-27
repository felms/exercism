defmodule LibraryFees do
  def datetime_from_string(string) do
    NaiveDateTime.from_iso8601!(string)
  end

  def before_noon?(datetime), do: datetime.hour < 12

  def return_date(checkout_datetime) do
    date =
      checkout_datetime
      |> NaiveDateTime.to_date()

    if before_noon?(checkout_datetime) do
      Date.add(date, 28)
    else
      Date.add(date, 29)
    end
  end

  def days_late(planned_return_date, actual_return_datetime) do
    actual_return_datetime
    |> NaiveDateTime.to_date()
    |> Date.diff(planned_return_date)
    |> Kernel.max(0)
  end

  def monday?(datetime) do
    datetime
    |> NaiveDateTime.to_date()
    |> Date.day_of_week()
    |> Kernel.==(1)
  end

  def calculate_late_fee(checkout, return, rate) do
    actual_return_datetime = datetime_from_string(return)

    checkout
    |> datetime_from_string()
    |> return_date()
    |> days_late(actual_return_datetime)
    |> Kernel.*(rate)
    |> discount(monday?(actual_return_datetime))
  end

  defp discount(fee, true), do: (fee * 0.5) |> trunc()
  defp discount(fee, false), do: fee
end
