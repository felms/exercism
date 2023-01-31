defmodule PerfectNumbers do
  @doc """
  Determine the aliquot sum of the given `number`, by summing all the factors
  of `number`, aside from `number` itself.

  Based on this sum, classify the number as:

  :perfect if the aliquot sum is equal to `number`
  :abundant if the aliquot sum is greater than `number`
  :deficient if the aliquot sum is less than `number`
  """
  @spec classify(number :: integer) :: {:ok, atom} | {:error, String.t()}
  def classify(number) when number < 1,
    do: {:error, "Classification is only possible for natural numbers."}

  def classify(number) do
    a_sum = aliquot_sum(number)

    cond do
      a_sum == number -> {:ok, :perfect}
      a_sum > number -> {:ok, :abundant}
      true -> {:ok, :deficient}
    end
  end

  defp aliquot_sum(1), do: 0

  defp aliquot_sum(number) do
    Enum.reduce(1..(number - 1), MapSet.new(), fn x, acc ->
      if rem(number, x) == 0 do
        MapSet.put(acc, x)
      else
        acc
      end
    end)
    |> Enum.sum()
  end
end
