defmodule RobotSimulator do
  @type direction() :: :north | :east | :south | :west
  @type position() :: {integer(), integer()}
  @type robot() :: {direction(), position()}

  @doc """
  Create a Robot Simulator given an initial direction and position.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec create(direction, position) :: robot() | {:error, String.t()}
  def create(direction \\ :north, position \\ {0, 0})

  def create(direction, _) when direction not in [:north, :east, :south, :west],
    do: {:error, "invalid direction"}

  def create(direction, {x, y} = position) when is_integer(x) and is_integer(y) do
    {direction, position}
  end

  def create(_, _), do: {:error, "invalid position"}

  @doc """
  Simulate the robot's movement given a string of instructions.

  Valid instructions are: "R" (turn right), "L", (turn left), and "A" (advance)
  """
  @spec simulate(robot, instructions :: String.t()) :: robot() | {:error, String.t()}
  def simulate(robot, instructions) do
    instructions
    |> String.graphemes()
    |> Enum.reduce_while(robot, fn instruction, acc ->
      new_robot = move(instruction, acc)

      case new_robot do
        {:error, _} -> {:halt, {:error, "invalid instruction"}}
        _ -> {:cont, new_robot}
      end
    end)
  end

  defp move(instruction, robot) do
    case instruction do
      "R" -> rotate_right(robot)
      "L" -> rotate_left(robot)
      "A" -> advance(robot)
      _ -> {:error, "invalid instruction"}
    end
  end

  defp rotate_right({direction, position}) do
    case direction do
      :north -> {:east, position}
      :east -> {:south, position}
      :south -> {:west, position}
      :west -> {:north, position}
    end
  end

  defp rotate_left({direction, position}) do
    case direction do
      :north -> {:west, position}
      :west -> {:south, position}
      :south -> {:east, position}
      :east -> {:north, position}
    end
  end

  defp advance({direction, {x, y}}) do
    case direction do
      :north -> {direction, {x, y + 1}}
      :west -> {direction, {x - 1, y}}
      :south -> {direction, {x, y - 1}}
      :east -> {direction, {x + 1, y}}
    end
  end

  @doc """
  Return the robot's direction.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec direction(robot) :: direction()
  def direction({direction, _position}) do
    direction
  end

  @doc """
  Return the robot's position.
  """
  @spec position(robot) :: position()
  def position({_direction, position}) do
    position
  end
end
