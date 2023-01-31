defmodule Hamming do
  @doc """
  Returns number of differences between two strands of DNA, known as the Hamming Distance.

  ## Examples

  iex> Hamming.hamming_distance('AAGTCATA', 'TAGCGATC')
  {:ok, 4}
  """
  @spec hamming_distance([char], [char]) :: {:ok, non_neg_integer} | {:error, String.t()}
  def hamming_distance(strand1, strand2) when length(strand1) != length(strand2),
    do: {:error, "strands must be of equal length"}

  def hamming_distance(strand1, strand2) do
    dist(strand1, strand2, 0)
  end

  defp dist([], [], dist), do: {:ok, dist}

  defp dist([h_str_01 | t_str_01], [h_str_02 | t_str_02], curr_dist) do
    if h_str_01 == h_str_02 do
      dist(t_str_01, t_str_02, curr_dist)
    else
      dist(t_str_01, t_str_02, curr_dist + 1)
    end
  end
end
