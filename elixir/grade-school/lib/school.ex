defmodule School do
  @moduledoc """
  Simulate students in a school.

  Each student is in a grade.
  """

  @type school :: map()

  @doc """
  Create a new, empty school.
  """
  @spec new() :: school
  def new() do
    Map.new()
  end

  @doc """
  Add a student to a particular grade in school.
  """
  @spec add(school, String.t(), integer) :: {:ok | :error, school}
  def add(school, name, grade) do
    current_roster = roster(school)

    if name in current_roster do
      {:error, school}
    else
      students = Map.get(school, grade, [])
      {:ok, Map.put(school, grade, students ++ [name])}
    end
  end

  @doc """
  Return the names of the students in a particular grade, sorted alphabetically.
  """
  @spec grade(school, integer) :: [String.t()]
  def grade(school, grade) do
    Map.get(school, grade, [])
    |> Enum.sort()
  end

  @doc """
  Return the names of all the students in the school sorted by grade and name.
  """
  @spec roster(school) :: [String.t()]
  def roster(school) do
    Map.keys(school)
    |> Enum.sort()
    |> Enum.reduce([], fn key, students ->
      students ++ grade(school, key)
    end)
  end
end
