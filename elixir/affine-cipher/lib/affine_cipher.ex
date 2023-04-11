defmodule AffineCipher do
  @typedoc """
  A type for the encryption key
  """
  @type key() :: %{a: integer, b: integer}

  @doc """
  Encode an encrypted message using a key
  """
  @spec encode(key :: key(), message :: String.t()) :: {:ok, String.t()} | {:error, String.t()}
  def encode(%{a: a, b: _b} = key, message) do
    if coprime?(a, 26) do
      result =
        message
        |> String.downcase()
        |> String.replace(~r/\W/, "")
        |> String.to_charlist()
        |> Enum.map(&encode_char(key, &1))
        |> Enum.chunk_every(5)
        |> Enum.map(&to_string/1)
        |> Enum.join(" ")

      {:ok, result}
    else
      {:error, "a and m must be coprime."}
    end
  end

  @doc """
  Decode an encrypted message using a key
  """
  @spec decode(key :: key(), message :: String.t()) :: {:ok, String.t()} | {:error, String.t()}
  def decode(%{a: a, b: _b} = key, encrypted) do
    if coprime?(a, 26) do
      result =
        encrypted
        |> String.replace(~r/\s+/, "")
        |> String.to_charlist()
        |> Enum.map(&decode_char(key, &1))
        |> to_string()

      {:ok, result}
    else
      {:error, "a and m must be coprime."}
    end
  end

  defp encode_char(key, char) do
    if char in ?a..?z do
      (key.a * (char - ?a) + key.b)
      |> rem(26)
      |> then(&(&1 + ?a))
    else
      char
    end
  end

  defp decode_char(key, char) do
    if char in ?a..?z do
      (mmi(key.a) * (char - key.b - ?a))
      |> rem(26)
      |> then(&if &1 < 0, do: &1 + 26, else: &1)
      |> then(&(&1 + ?a))
    else
      char
    end
  end

  defp coprime?(x, y), do: Integer.gcd(x, y) == 1

  defp mmi(a) do
    Enum.reduce(0..25, 0, fn i, b ->
      r = (a * i) |> rem(26)

      if r == 1, do: i, else: b
    end)
  end
end
