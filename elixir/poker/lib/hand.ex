defmodule Hand do
  defstruct [:cards, :category]

  @categories %{
    ace_high_straight_flush: 13,
    straight_flush: 12,
    five_high_straight_flush: 11,
    four_of_a_kind: 10,
    full_house: 9,
    flush: 8,
    ace_high_straight: 7,
    straight: 6,
    five_high_straight: 5,
    three_of_a_kind: 4,
    two_pair: 3,
    one_pair: 2,
    high_card: 1
  }

  def parse_hand(hand) do
    cards = hand |> Enum.map(&Card.parse_card/1)

    %Hand{
      cards: cards,
      category: categorize_hand(cards)
    }
  end

  def sort_hands(hands) do
    hands
    |> Enum.sort(fn hand_0, hand_1 ->
      @categories[hand_0.category] >= @categories[hand_1.category]
    end)
  end

  def print_hand(hand) do
    hand.cards
    |> Enum.map(&Card.print_card/1)
  end

  defp categorize_hand(hand) do
    cond do
      ace_high_straight?(hand) and flush?(hand) -> :ace_high_straight_flush
      straight?(hand) and flush?(hand) -> :straight_flush
      five_high_straight?(hand) and flush?(hand) -> :five_high_straight_flush
      four_of_a_kind?(hand) -> :four_of_a_kind
      three_of_a_kind?(hand) and one_pair?(hand) -> :full_house
      flush?(hand) -> :flush
      ace_high_straight?(hand) -> :ace_high_straight
      straight?(hand) -> :straight
      five_high_straight?(hand) -> :five_high_straight
      three_of_a_kind?(hand) -> :three_of_a_kind
      two_pair?(hand) -> :two_pair
      one_pair?(hand) -> :one_pair
      true -> :high_card
    end
  end

  defp four_of_a_kind?(hand) do
    hand
    |> Enum.map(fn card -> card.rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> Enum.member?(4)
  end

  defp three_of_a_kind?(hand) do
    hand
    |> Enum.map(fn card -> card.rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> Enum.member?(3)
  end

  defp two_pair?(hand) do
    hand
    |> Enum.map(fn card -> card.rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> Enum.sort(:desc)
    |> then(&(&1 == [2, 2, 1]))
  end

  defp one_pair?(hand) do
    hand
    |> Enum.map(fn card -> card.rank end)
    |> Enum.frequencies()
    |> Map.values()
    |> then(&(2 in &1))
  end

  defp ace_high_straight?(hand) do
    values = hand |> Enum.map(fn card -> card.value end)
    10..14 |> Enum.all?(&(&1 in values))
  end

  defp five_high_straight?(hand) do
    values = hand |> Enum.map(fn card -> card.value end)
    [2, 3, 4, 5, 14] |> Enum.all?(&(&1 in values))
  end

  defp straight?(hand) do
    values = hand |> Enum.map(fn card -> card.value end)
    {min, max} = Enum.min_max(values)
    min..max |> Enum.all?(&(&1 in values))
  end

  defp flush?(hand) do
    hand
    |> Enum.map(fn card -> card.suit end)
    |> Enum.uniq()
    |> length() == 1
  end
end
