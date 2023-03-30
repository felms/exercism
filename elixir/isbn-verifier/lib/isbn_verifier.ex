defmodule IsbnVerifier do
  @doc """
    Checks if a string is a valid ISBN-10 identifier

    ## Examples

      iex> IsbnVerifier.isbn?("3-598-21507-X")
      true

      iex> IsbnVerifier.isbn?("3-598-2K507-0")
      false

  """
  @spec isbn?(String.t()) :: boolean
  def isbn?(isbn) do
    isbn = isbn |> String.replace(~r/[\W]/, "")

    check_invalid_chars(isbn) and
      String.length(isbn) == 10 and
      check_sum(isbn)
  end

  defp check_invalid_chars(isbn) do
    isbn =~ ~r/[\d]{9}(\d|X)/
  end

  defp check_sum(isbn) do
    isbn
    |> String.graphemes()
    |> Enum.map(&String.replace(&1, "X", "10"))
    |> Enum.map(&String.to_integer/1)
    |> Enum.reverse()
    |> Enum.with_index(1)
    |> Enum.map(fn {a, b} -> a * b end)
    |> Enum.sum()
    |> rem(11) == 0
  end
end
