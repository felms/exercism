defmodule KillerSudokuHelper do
  @doc """
  Return the possible combinations of `size` distinct numbers from 1-9 excluding `exclude` that sum up to `sum`.
  """
  @spec combinations(cage :: %{exclude: [integer], size: integer, sum: integer}) :: [[integer]]
  def combinations(cage) do
    %{exclude: exclude, size: size, sum: sum} = cage

    combinations_in_cage([], [], sum, size)
    |> Enum.reject(fn list -> list |> Enum.any?(&(&1 in exclude)) end)
    |> Enum.reverse()
  end

  defp combinations_in_cage(combinations_list, current_list, target_sum, size)
       when target_sum <= 0 do
    if target_sum == 0 and current_list |> length() == size do
      [current_list |> Enum.reverse() | combinations_list]
    else
      combinations_list
    end
  end

  defp combinations_in_cage(combinations_list, current_list, target_sum, size) do
    first = if current_list |> Enum.empty?(), do: 1, else: (current_list |> hd()) + 1

    first..9
    |> Enum.reduce(combinations_list, fn i, acc ->
      combinations_in_cage(acc, [i | current_list], target_sum - i, size)
    end)
  end
end
