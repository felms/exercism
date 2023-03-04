defmodule RobotSimulator do

  defmodule Robot do
    defstruct [direction: :north, position: {0, 0}]
  end

  defguardp is_direction(direction) when direction in [:north, :east, :south, :west]
  defguardp is_position(x, y) when is_integer(x) and is_integer(y)

  @type direction() :: :north | :east | :south | :west
  @type position() :: {integer(), integer()}
  @type robot() :: {direction(), position()}

  @doc """
  Create a Robot Simulator given an initial direction and position.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec create(direction, position) :: robot() | {:error, String.t()}
  def create(), do: %Robot{}
  def create(direction, _) when not is_direction(direction), do: {:error, "invalid direction"}
  def create(direction, position = {x, y}) when is_position(x, y), 
    do: %Robot{direction: direction, position: position}
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

  defp rotate_right(robot) do
    case robot.direction do
      :north -> %{robot | direction: :east}
      :east -> %{robot | direction: :south}
      :south -> %{robot | direction: :west}
      :west -> %{robot | direction: :north}
    end
  end

  defp rotate_left(robot) do
    case robot.direction do
      :north -> %{robot | direction: :west}
      :west -> %{robot | direction: :south}
      :south -> %{robot | direction: :east}
      :east -> %{robot | direction: :north}
    end
  end

  defp advance(robot) do
    {x, y} = robot.position
    case robot.direction do
      :north -> %{robot | position: {x, y + 1}}
      :west -> %{robot | position: {x - 1, y}}
      :south -> %{robot | position: {x, y - 1}}
      :east -> %{robot | position: {x + 1, y}}
    end
  end

  @doc """
  Return the robot's direction.

  Valid directions are: `:north`, `:east`, `:south`, `:west`
  """
  @spec direction(robot) :: direction()
  def direction(robot), do: robot.direction

  @doc """
  Return the robot's position.
  """
  @spec position(robot) :: position()
  def position(robot), do: robot.position

end
