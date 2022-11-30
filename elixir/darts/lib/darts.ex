defmodule Darts do
  @type position :: {number, number}

  @doc """
  Calculate the score of a single dart hitting a target
  """
  @spec score(position) :: integer
  def score({x, y}) do
    distance = distance_between_points({0, 0}, {x, y})

    cond do
      distance <= 1 -> 10
      distance <= 5 -> 5
      distance <= 10 -> 1
      true -> 0
    end
  end

  defp distance_between_points({x1, y1}, {x2, y2}) do
    d1 = (x2 - x1) / 1.0
    d2 = (y2 - y1) / 1.0
    Float.pow(d1, 2.0) + Float.pow(d2, 2.0)
    |> Float.pow(0.5)
  end

end
