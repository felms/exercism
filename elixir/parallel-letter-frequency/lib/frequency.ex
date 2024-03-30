defmodule Frequency do
  @doc """
  Count letter frequency in parallel.

  Returns a map of characters to frequencies.

  The number of worker processes to use can be set with 'workers'.
  """
  @spec frequency([String.t()], pos_integer) :: map
  def frequency([], _workers), do: %{}
  def frequency(texts, workers) do
    chunk_size = div(texts |> length, workers)

    texts
    |> Enum.chunk_every(chunk_size, chunk_size, [])
    |> Enum.map(&Task.async(fn -> count_freq(&1) end))
    |> Enum.map(&Task.await/1)
    |> Enum.reduce(%{}, fn res, acc ->
      Map.merge(res, acc, fn _k, v1, v2 -> v1 + v2 end)
    end)
  end

  defp count_freq(texts) do
    texts
    |> Enum.join()
    |> String.downcase()
    |> String.replace(~r/[^a-z\x7f-\xff]/, "")
    |> String.graphemes()
    |> Enum.frequencies()
  end
end
