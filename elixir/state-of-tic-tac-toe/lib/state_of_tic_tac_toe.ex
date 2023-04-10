defmodule StateOfTicTacToe do
  @doc """
  Determine the state a game of tic-tac-toe where X starts.
  """
  @spec game_state(board :: String.t()) :: {:ok, :win | :ongoing | :draw} | {:error, String.t()}
  def game_state(board) do
    board
    |> String.replace("\n", "")
    |> String.graphemes()
    |> check_board()
  end

  defp player_won?(x, [x, x, x, _, _, _, _, _, _]), do: true
  defp player_won?(x, [_, _, _, x, x, x, _, _, _]), do: true
  defp player_won?(x, [_, _, _, _, _, _, x, x, x]), do: true
  defp player_won?(x, [x, _, _, x, _, _, x, _, _]), do: true
  defp player_won?(x, [_, x, _, _, x, _, _, x, _]), do: true
  defp player_won?(x, [_, _, x, _, _, x, _, _, x]), do: true
  defp player_won?(x, [x, _, _, _, x, _, _, _, x]), do: true
  defp player_won?(x, [_, _, x, _, x, _, x, _, _]), do: true
  defp player_won?(_, _), do: false

  defp check_board(board) do
    cond do
      (count_plays(board, "X") - count_plays(board, "O")) |> abs() > 1 ->
        {:error, "Wrong turn order: X went twice"}

      count_plays(board, "O") > count_plays(board, "X") ->
        {:error, "Wrong turn order: O started"}

      player_won?("X", board) and count_plays(board, "X") == count_plays(board, "O") ->
        {:error, "Impossible board: game should have ended after the game was won"}

      player_won?("X", board) and player_won?("O", board) ->
        {:error, "Impossible board: game should have ended after the game was won"}

      player_won?("X", board) or player_won?("O", board) ->
        {:ok, :win}

      "." not in board ->
        {:ok, :draw}

      true ->
        {:ok, :ongoing}
    end
  end

  defp count_plays(board, player), do: Enum.count(board, &(&1 == player))
end
