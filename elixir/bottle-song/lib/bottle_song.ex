defmodule BottleSong do
  @moduledoc """
  Handles lyrics of the popular children song: Ten Green Bottles
  """

  @bottle_mappings %{
    10 => {"Ten", "bottles", "nine", "bottles"},
    9 => {"Nine", "bottles", "eight", "bottles"},
    8 => {"Eight", "bottles", "seven", "bottles"},
    7 => {"Seven", "bottles", "six", "bottles"},
    6 => {"Six", "bottles", "five", "bottles"},
    5 => {"Five", "bottles", "four", "bottles"},
    4 => {"Four", "bottles", "three", "bottles"},
    3 => {"Three", "bottles", "two", "bottles"},
    2 => {"Two", "bottles", "one", "bottle"},
    1 => {"One", "bottle", "no", "bottles"},
  }

  @spec recite(pos_integer, pos_integer) :: String.t()
  def recite(start_bottle, take_down) do
    Enum.to_list(start_bottle..(start_bottle - take_down + 1))
    |> Enum.map(&verse/1)
    |> Enum.join("\n\n")
  end


  defp verse(verse_number) do
    {start_bottle, bottle, end_bottle, bootle_remaining} = @bottle_mappings[verse_number]

    """
    #{start_bottle} green #{bottle} hanging on the wall,
    #{start_bottle} green #{bottle} hanging on the wall,
    And if one green bottle should accidentally fall,
    There'll be #{end_bottle} green #{bootle_remaining} hanging on the wall.\
    """

  end

end
