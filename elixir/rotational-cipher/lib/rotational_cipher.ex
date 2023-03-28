defmodule RotationalCipher do
  @doc """
  Given a plaintext and amount to shift by, return a rotated string.

  Example:
  iex> RotationalCipher.rotate("Attack at dawn", 13)
  "Nggnpx ng qnja"
  """

  @spec rotate(text :: String.t(), shift :: integer) :: String.t()
  def rotate(text, shift) do
    text
    |> String.to_charlist()
    |> Enum.map(&translate(&1, shift))
    |> List.to_string()
  end

  defp translate(char, shift) when char in ?a..?z,
    do: ?a + rem((char - ?a) + shift, 26)

  defp translate(char, shift) when char in ?A..?Z,
    do: ?A + rem((char - ?A) + shift, 26)

  defp translate(char, _shift), do: char

end
