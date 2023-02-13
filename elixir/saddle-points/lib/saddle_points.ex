defmodule SaddlePoints do
  @doc """
  Parses a string representation of a matrix
  to a list of rows
  """
  @spec rows(String.t()) :: [[integer]]
  def rows(str) do
    str
    |> String.split("\n", trim: true)
    |> Enum.map(fn line ->
      line
      |> String.split(" ", trim: true)
      |> Enum.map(&String.to_integer/1)
    end)
  end

  @doc """
  Parses a string representation of a matrix
  to a list of columns
  """
  @spec columns(String.t()) :: [[integer]]
  def columns(str) do
    str
    |> rows()
    |> Enum.zip()
    |> Enum.map(&Tuple.to_list/1)
  end

  @doc """
  Calculates all the saddle points from a string
  representation of a matrix
  """
  @spec saddle_points(String.t()) :: [{integer, integer}]
  def saddle_points(""), do: []

  def saddle_points(str) do
    rows = String.split(str, "\n", trim: true) |> length()

    columns =
      String.split(str, "\n", trim: true)
      |> List.first()
      |> String.split(" ", trim: true)
      |> length()

    points = for x <- 0..(rows - 1), y <- 0..(columns - 1), do: {x, y}

    Enum.reduce(points, [], fn point = {p_x, p_y}, acc ->
      if saddle_point?(point, str) do
        acc ++ [{p_x + 1, p_y + 1}]
      else
        acc
      end
    end)
  end

  defp saddle_point?({x, y}, str) do
    row = rows(str) |> Enum.at(x)
    column = columns(str) |> Enum.at(y)

    value = Enum.at(row, y)

    value == Enum.sort(row, :desc) |> Enum.at(0) and
      value == Enum.sort(column) |> Enum.at(0)
  end
end
