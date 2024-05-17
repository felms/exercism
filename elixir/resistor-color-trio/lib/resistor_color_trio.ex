defmodule ResistorColorTrio do
  @doc """
  Calculate the resistance value in ohm or kiloohm from resistor colors
  """

  @kilo 1_000
  @mega 1_000_000
  @giga 1_000_000_000

  @codes %{
    black: 0,
    brown: 1,
    red: 2,
    orange: 3,
    yellow: 4,
    green: 5,
    blue: 6,
    violet: 7,
    grey: 8,
    white: 9
  }

  @spec label(colors :: [atom]) :: {number, :ohms | :kiloohms}
  def label(colors) do
    [first, second, third | _] = colors

    ((@codes[first] * 10 + @codes[second]) * Integer.pow(10, @codes[third]))
    |> format_resistance()
  end

  defp format_resistance(resistance) when resistance > @giga,
    do: {div(resistance, @giga), :gigaohms}

  defp format_resistance(resistance) when resistance > @mega,
    do: {div(resistance, @mega), :megaohms}

  defp format_resistance(resistance) when resistance > @kilo,
    do: {div(resistance, @kilo), :kiloohms}

  defp format_resistance(resistance), do: {resistance, :ohms}
end
