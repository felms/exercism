defmodule SquareRoot do
  @doc """
  Calculate the integer square root of a positive integer
  """
  @spec calculate(radicand :: pos_integer) :: pos_integer
  def calculate(radicand) do
    sqrt(radicand, 1, 0)
  end

  # Repeated Subtraction Method
  defp sqrt(radicand, current_odd_number, counter) when radicand < current_odd_number, do: counter

  defp sqrt(radicand, current_odd_number, counter) do
    sqrt(radicand - current_odd_number, current_odd_number + 2, counter + 1)
  end
end
