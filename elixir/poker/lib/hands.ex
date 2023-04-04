defmodule Hands do
  @categories %{
    straight_flush: 9,
    four_of_a_kind: 8,
    full_house: 7,
    flush: 6,
    straight: 5,
    three_of_a_kind: 4,
    two_pair: 3,
    one_pair: 2,
    high_card: 1
  }

  @ranks %{
    two: 2,
    three: 3,
    four: 4,
    five: 5,
    six: 6,
    seven: 7,
    eight: 8,
    nine: 9,
    ten: 10,
    jack: 11,
    queen: 12,
    king: 13,
    ace: 1
  }

  @number_to_rank %{
    "2" => :two,
    "3" => :three,
    "4" => :four,
    "5" => :five,
    "6" => :six,
    "7" => :seven,
    "8" => :eight,
    "9" => :nine,
    "10" => :ten,
    "J" => :jack,
    "Q" => :queen,
    "K" => :king,
    "A" => :ace
  }

  @suits %{"C" => :clubs, "D" => :diamonds, "H" => :hearts, "S" => :spades}

  def parse_hand(hand), do: hand |> Enum.map(&parse_card/1)

  defp parse_card(card) do
    rank = String.replace(card, ~r/\w{1}$/, "")
    suit = String.replace(card, rank, "")
    {@number_to_rank[rank], @suits[suit]}
  end

  def categorize_hand(hand) do
    cond do
      straight?(hand) and flush?(hand) -> :straight_flush
      four_of_a_kind?(hand) -> :four_of_a_kind
      three_of_a_kind?(hand) and one_pair?(hand) -> :full_house
      flush?(hand) -> :flush
      straight?(hand) -> :straight
      three_of_a_kind?(hand) -> :three_of_a_kind
      two_pair?(hand) -> :two_pair
      one_pair?(hand) -> :one_pair
      true -> :high_card
    end
  end

  defp four_of_a_kind?(hand) do
    hand
    |> Enum.map(fn {rank, _suit} -> rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> Enum.member?(4)
  end

  defp three_of_a_kind?(hand) do
    hand
    |> Enum.map(fn {rank, _suit} -> rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> Enum.member?(3)
  end

  defp two_pair?(hand) do
    hand
    |> Enum.map(fn {rank, _suit} -> rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> Enum.sort(:desc)
    |> then(&(&1 == [2, 2, 1]))
  end

  defp one_pair?(hand) do
    hand
    |> Enum.map(fn {rank, _suit} -> rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> then(&(2 in &1))
  end

  defp straight?(hand) do
    sorted_hand = sort_hand(hand) |> Enum.map(fn {rank, _suit} -> @ranks[rank] end)
    Enum.at(sorted_hand, 0) - Enum.at(sorted_hand, -1) == 4
  end

  defp flush?(hand) do
    hand
    |> Enum.map(fn {_rank, suit} -> suit end)
    |> Enum.uniq()
    |> length() == 1
  end

  defp sort_hand(hand) do
    hand
    |> Enum.sort(fn {rank_0, _suit_0}, {rank_1, _suit_1} ->
      @ranks[rank_0] >= @ranks[rank_1]
    end)
  end
end
