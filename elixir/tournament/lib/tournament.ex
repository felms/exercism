defmodule Tournament do
  @type team :: %{
          matches: integer,
          wins: integer,
          draws: integer,
          losses: integer,
          points: integer
        }

  @default_team %{
    matches: 0,
    wins: 0,
    draws: 0,
    losses: 0,
    points: 0
  }

  @doc """
  Given `input` lines representing two teams and whether the first of them won,
  lost, or reached a draw, separated by semicolons, calculate the statistics
  for each team's number of games played, won, drawn, lost, and total points
  for the season, and return a nicely-formatted string table.

  A win earns a team 3 points, a draw earns 1 point, and a loss earns nothing.

  Order the outcome by most total points for the season, and settle ties by
  listing the teams in alphabetical order.
  """
  @spec tally(input :: list(String.t())) :: String.t()
  def tally(input) do
    input
    |> Enum.reject(fn match -> match == "" end)
    |> Enum.reduce(%{}, fn match, acc ->
      current_match = String.split(match, ";", trim: true)

      if length(current_match) == 3 do
        read_match(current_match, acc)
      else
        acc
      end
    end)
    |> print_leaderboard()
  end

  defp read_match(match, leaderboard) do
    [team_a, team_b, result] = match

    case result do
      "win" ->
        insert_win(leaderboard, team_a)
        |> insert_loss(team_b)

      "loss" ->
        insert_loss(leaderboard, team_a)
        |> insert_win(team_b)

      "draw" ->
        insert_draw(leaderboard, team_a)
        |> insert_draw(team_b)

      _ ->
        leaderboard
    end
  end

  defp print_leaderboard(leaderboard) do
    header = "Team                           | MP |  W |  D |  L |  P"

    Map.to_list(leaderboard)
    |> Enum.sort(fn {_team_name_0, team_0}, {_team_name_1, team_1} ->
      team_0.points >= team_1.points
    end)
    |> Enum.reduce(header, fn {team_name, team}, acc ->
      acc <> "\n" <> print_team(team, team_name)
    end)
  end

  defp print_team(team, team_name) do
    "#{String.pad_trailing(team_name, 31, " ")}|  #{team.matches} |  #{team.wins} |  #{team.draws} |  #{team.losses} |#{String.pad_leading(to_string(team.points), 3, " ")}"
  end

  defp insert_win(leaderboard, team_name) do
    team = Map.get(leaderboard, team_name, @default_team)

    updated_team =
      Map.put(team, :matches, team.matches + 1)
      |> Map.put(:wins, team.wins + 1)
      |> Map.put(:points, team.points + 3)

    Map.put(leaderboard, team_name, updated_team)
  end

  defp insert_loss(leaderboard, team_name) do
    team = Map.get(leaderboard, team_name, @default_team)

    updated_team =
      Map.put(team, :matches, team.matches + 1)
      |> Map.put(:losses, team.losses + 1)

    Map.put(leaderboard, team_name, updated_team)
  end

  defp insert_draw(leaderboard, team_name) do
    team = Map.get(leaderboard, team_name, @default_team)

    updated_team =
      Map.put(team, :matches, team.matches + 1)
      |> Map.put(:draws, team.draws + 1)
      |> Map.put(:points, team.points + 1)

    Map.put(leaderboard, team_name, updated_team)
  end
end
