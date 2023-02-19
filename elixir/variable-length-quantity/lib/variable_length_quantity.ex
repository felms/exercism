defmodule VariableLengthQuantity do
  @mask 0b1111111

  @doc """
  Encode integers into a bitstring of VLQ encoded bytes
  """
  @spec encode(integers :: [integer]) :: binary
  def encode(integers) do
    Enum.reduce(integers, <<>>, fn integer, acc ->
      <<acc::bitstring, do_encode(integer, <<>>)::bitstring>>
    end)
  end

  defp do_encode(integer, encoded_value) do
    value = Bitwise.band(integer, @mask)

    cond do
      integer == 0 and encoded_value == <<>> -> <<0x0>>
      integer == 0 -> <<encoded_value::bitstring>>
      encoded_value == <<>> -> do_encode(Bitwise.bsr(integer, 7), <<0::1, value::7>>)
      true -> do_encode(Bitwise.bsr(integer, 7), <<1::1, value::7, encoded_value::bitstring>>)
    end
  end

  @doc """
  Decode a bitstring of VLQ encoded bytes into a series of integers
  """
  @spec decode(bytes :: binary) :: {:ok, [integer]} | {:error, String.t()}
  def decode(bytes) do
    do_decode(bytes, 0, [])
  end

  defp do_decode(<<>>, _acc, list), do: {:ok, list}

  defp do_decode(bytes, acc, list) do
    <<value::8, remainder::bitstring>> = bytes
    msb = Bitwise.band(value, @mask + 1) |> Bitwise.bsr(7)
    number = Bitwise.band(value, @mask)

    res_number = Bitwise.bsl(acc, 7) + number

    cond do
      msb == 0 ->
        do_decode(remainder, 0, list ++ [res_number])

      msb == 1 and remainder == <<>> ->
        {:error, "incomplete sequence"}

      msb == 1 ->
        do_decode(remainder, res_number, list)
    end
  end
end
