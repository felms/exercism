defmodule ResistorColorDuo do
  @doc """
  Calculate a resistance value from two colors
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

  @spec value(colors :: [atom]) :: integer
  def value(colors) do
    [first, second] = Enum.take(colors, 2)

    @codes[first] * 10 + @codes[second]
  end
end
