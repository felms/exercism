defmodule Atbash do
  @doc """
  Encode a given plaintext to the corresponding ciphertext

  ## Examples

  iex> Atbash.encode("completely insecure")
  "xlnko vgvob rmhvx fiv"
  """
  @spec encode(String.t()) :: String.t()
  def encode(plaintext) do
    plaintext
    |> String.downcase()
    |> String.to_charlist()
    |> Enum.filter(&(&1 in ?a..?z or &1 in ?0..?9))
    |> Enum.map(&translate_char/1)
    |> Enum.chunk_every(5)
    |> Enum.join(" ")
  end

  @spec decode(String.t()) :: String.t()
  def decode(cipher) do
    cipher
    |> String.to_charlist()
    |> Enum.filter(&(&1 in ?a..?z or &1 in ?0..?9))
    |> Enum.map(&translate_char/1)
    |> List.to_string()
  end

  defp translate_char(char) when char in ?a..?z, do: ?z - (char - ?a)
  defp translate_char(char), do: char
end
