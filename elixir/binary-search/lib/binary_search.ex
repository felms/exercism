defmodule BinarySearch do
  @doc """
    Searches for a key in the tuple using the binary search algorithm.
    It returns :not_found if the key is not in the tuple.
    Otherwise returns {:ok, index}.

    ## Examples

      iex> BinarySearch.search({}, 2)
      :not_found

      iex> BinarySearch.search({1, 3, 5}, 2)
      :not_found

      iex> BinarySearch.search({1, 3, 5}, 5)
      {:ok, 2}

  """

  @spec search(tuple, integer) :: {:ok, integer} | :not_found
  def search({}, _key), do: :not_found
  def search({key}, key), do: {:ok, 0}
  def search({item}, key) when item != key, do: :not_found
  def search(numbers, key) do
   search(numbers, 0, tuple_size(numbers) - 1, key)
  end

  defp search(numbers, start_index, end_index, key) do
    middle = div(start_index + end_index, 2)
    item = elem(numbers, middle)

    cond do
      start_index > end_index -> :not_found
      item === key -> {:ok, middle}
      key > item -> search(numbers, middle + 1, end_index, key)
      key < item -> search(numbers, start_index, middle - 1, key)
    end
  end
end
