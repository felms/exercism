defmodule RomanNumerals do
  @doc """
  Convert the number to a roman number.
  """
  @spec numeral(pos_integer) :: String.t()
  def numeral(number) do
    thousands(div(number, 1000)) <>
      hundreds(rem(number, 1000) |> div(100)) <>
      tens(rem(number, 100) |> div(10)) <>
      units(rem(number, 10))
  end

  defp units(number) do
    case number do
      1 -> "I"
      2 -> "II"
      3 -> "III"
      4 -> "IV"
      5 -> "V"
      6 -> "VI"
      7 -> "VII"
      8 -> "VIII"
      9 -> "IX"
      0 -> ""
    end
  end

  defp tens(number) do
    case number do
      1 -> "X"
      2 -> "XX"
      3 -> "XXX"
      4 -> "XL"
      5 -> "L"
      6 -> "LX"
      7 -> "LXX"
      8 -> "LXXX"
      9 -> "XC"
      0 -> ""
    end
  end

  defp hundreds(number) do
    case number do
      1 -> "C"
      2 -> "CC"
      3 -> "CCC"
      4 -> "CD"
      5 -> "D"
      6 -> "DC"
      7 -> "DCC"
      8 -> "DCCC"
      9 -> "CM"
      0 -> ""
    end
  end

  defp thousands(number) do
    case number do
      1 -> "M"
      2 -> "MM"
      3 -> "MMM"
      0 -> ""
    end
  end
end
