defmodule Yacht do
  @type category ::
          :ones
          | :twos
          | :threes
          | :fours
          | :fives
          | :sixes
          | :full_house
          | :four_of_a_kind
          | :little_straight
          | :big_straight
          | :choice
          | :yacht

  @doc """
  Calculate the score of 5 dice using the given category's scoring method.
  """
  @spec score(category :: category(), dice :: [integer]) :: integer
  def score(:ones, dice) do
    dice
    |> Enum.count(fn x -> x == 1 end)
  end

  def score(:twos, dice) do
    dice
    |> Enum.count(fn x -> x == 2 end)
    |> Kernel.*(2)
  end

  def score(:threes, dice) do
    dice
    |> Enum.count(fn x -> x == 3 end)
    |> Kernel.*(3)
  end

  def score(:fours, dice) do
    dice
    |> Enum.count(fn x -> x == 4 end)
    |> Kernel.*(4)
  end

  def score(:fives, dice) do
    dice
    |> Enum.count(fn x -> x == 5 end)
    |> Kernel.*(5)
  end

  def score(:sixes, dice) do
    dice
    |> Enum.count(fn x -> x == 6 end)
    |> Kernel.*(6)
  end

  def score(:full_house, dice) do
    if full_house?(dice) do
      Enum.sum(dice)
    else
      0
    end
  end

  def score(:four_of_a_kind, dice) do
    Enum.filter(dice, fn x -> Enum.count(dice, fn y -> y == x end) >= 4 end)
    |> Enum.take(4)
    |> Enum.sum()
  end

  def score(:little_straight, dice) do
    is_little_straight = Enum.all?(1..5, fn x -> x in dice end)

    if is_little_straight do
      30
    else
      0
    end
  end

  def score(:big_straight, dice) do
    is_big_straight = Enum.all?(2..6, fn x -> x in dice end)

    if is_big_straight do
      30
    else
      0
    end
  end

  def score(:choice, dice), do: Enum.sum(dice)

  def score(:yacht, dice) do
    is_yacht =
      Enum.uniq(dice)
      |> length()
      |> Kernel.==(1)

    if is_yacht do
      50
    else
      0
    end
  end

  defp full_house?(dice) do
    Enum.any?(dice, fn x -> Enum.count(dice, fn y -> x == y end) == 3 end) and
      Enum.any?(dice, fn x -> Enum.count(dice, fn y -> x == y end) == 2 end)
  end
end
