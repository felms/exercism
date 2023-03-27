defmodule Garden do
  @doc """
    Accepts a string representing the arrangement of cups on a windowsill and a
    list with names of students in the class. The student names list does not
    have to be in alphabetical order.

    It decodes that string into the various gardens for each student and returns
    that information in a map.
  """

  @default_list [
    :alice,
    :bob,
    :charlie,
    :david,
    :eve,
    :fred,
    :ginny,
    :harriet,
    :ileana,
    :joseph,
    :kincaid,
    :larry
  ]

  @code_to_plant %{"V" => :violets, "G" => :grass, "R" => :radishes, "C" => :clover}

  @spec info(String.t(), list) :: map
  def info(info_string, student_names \\ @default_list) do
    map =
      info_string
      |> String.split("\n", trim: true)
      |> Enum.map(&codes_to_plants/1)
      |> Enum.zip()
      |> Enum.map(&Tuple.to_list/1)
      |> Enum.map(&List.flatten/1)
      |> Enum.map(&List.to_tuple/1)
      |> Enum.zip(Enum.sort(student_names))
      |> Enum.map(fn {a, b} -> {b, a} end)
      |> Enum.into(%{})

    Enum.reject(student_names, &(&1 in Map.keys(map)))
    |> Enum.reduce(map, fn student, acc -> Map.put(acc, student, {}) end)
  end

  defp codes_to_plants(codes) do
    codes
    |> String.graphemes()
    |> Enum.map(&Map.get(@code_to_plant, &1))
    |> Enum.chunk_every(2)
  end
end
