defmodule FreelancerRates do
  def daily_rate(hourly_rate) do
    8.0 * hourly_rate
  end

  def apply_discount(before_discount, discount) do
    percentage = 1 - (discount / 100)
    before_discount * percentage
  end

  def monthly_rate(hourly_rate, discount) do
    daily_rate(hourly_rate) * 22.0 
    |> apply_discount(discount) 
    |> ceil
  end

  def days_in_budget(budget, hourly_rate, discount) do
    daily =  hourly_rate 
             |> daily_rate 
             |> apply_discount(discount) 

    budget / daily 
    |> Float.floor(1)

  end
end
