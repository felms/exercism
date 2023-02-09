defmodule SecretHandshake do
  @doc """
  Determine the actions of a secret handshake based on the binary
  representation of the given `code`.

  If the following bits are set, include the corresponding action in your list
  of commands, in order from lowest to highest.

  1 = wink
  10 = double blink
  100 = close your eyes
  1000 = jump

  10000 = Reverse the order of the operations in the secret handshake
  """
  @spec commands(code :: integer) :: list(String.t())
  def commands(code) do
    []
    |> exec_command(Bitwise.band(code, 1))
    |> exec_command(Bitwise.band(code, 2))
    |> exec_command(Bitwise.band(code, 4))
    |> exec_command(Bitwise.band(code, 8))
    |> exec_command(Bitwise.band(code, 16))
  end

  defp exec_command(list, command_code) do
    case command_code do
      0 -> list
      1 -> list ++ ["wink"]
      2 -> list ++ ["double blink"]
      4 -> list ++ ["close your eyes"]
      8 -> list ++ ["jump"]
      16 -> Enum.reverse(list)
    end
  end
end
