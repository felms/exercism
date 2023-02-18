defmodule DNA do
  def encode_nucleotide(code_point) do
    case code_point do
      ?\s -> 0b0000
      ?A -> 0b0001
      ?C -> 0b0010
      ?G -> 0b0100
      ?T -> 0b1000
    end
  end

  def decode_nucleotide(encoded_code) do
    case encoded_code do
      0b0000 -> ?\s
      0b0001 -> ?A
      0b0010 -> ?C
      0b0100 -> ?G
      0b1000 -> ?T
    end
  end

  def encode(dna) do
    do_encode(dna, <<>>)
  end

  defp do_encode([], acc), do: <<acc::bitstring>>

  defp do_encode([code_point | rest], acc),
    do: do_encode(rest, <<acc::bitstring, encode_nucleotide(code_point)::4>>)

  def decode(dna) do
    do_decode(dna, [])
  end

  defp do_decode(<<>>, acc), do: acc

  defp do_decode(<<value::4, rest::bitstring>>, acc),
    do: do_decode(rest, acc ++ [decode_nucleotide(value)])
end
