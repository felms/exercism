defmodule PascalsTriangle do
  @doc """
  Calculates the rows of a pascal triangle
  with the given height
  """
  @spec rows(integer) :: [[integer]]
  def rows(num) do
    0..num - 1
    |> Enum.map(&calculate_row/1)
  end

  defp calculate_row(row_number) do
    0..row_number
    |> Enum.map(&(compute_element(row_number, &1))) 
  end

  defp compute_element(_n, 0), do: 1
  defp compute_element(n, k), do: compute_element(n, k - 1) * (n + 1 - k) |> div(k)
end
