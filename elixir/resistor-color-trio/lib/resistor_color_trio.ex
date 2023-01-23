defmodule ResistorColorTrio do
  @doc """
  Calculate the resistance value in ohm or kiloohm from resistor colors
  """
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
    [first, second, third] = colors

    resistance = (@codes[first] * 10 + @codes[second]) * Integer.pow(10, @codes[third])

    if resistance >= 1000 do
      {div(resistance, 1000), :kiloohms}
    else
      {resistance, :ohms}
    end

  end
end
