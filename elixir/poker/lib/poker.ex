defmodule Poker do
  @doc """
  Given a list of poker hands, return a list containing the highest scoring hand.

  If two or more hands tie, return the list of tied hands in the order they were received.

  The basic rules and hand rankings for Poker can be found at:

    https://en.wikipedia.org/wiki/List_of_poker_hands

  For this exercise, we'll consider the game to be using no Jokers,
  so five-of-a-kind hands will not be tested. We will also consider
  the game to be using multiple decks, so it is possible for multiple
  players to have identical cards.

  Aces can be used in low (A 2 3 4 5) or high (10 J Q K A) straights, but do not count as
  a high card in the former case.

  For example, (A 2 3 4 5) will lose to (2 3 4 5 6).

  You can also assume all inputs will be valid, and do not need to perform error checking
  when parsing card values. All hands will be a list of 5 strings, containing a number
  (or letter) for the rank, followed by the suit.

  Ranks (lowest to highest): 2 3 4 5 6 7 8 9 10 J Q K A
  Suits (order doesn't matter): C D H S

  Example hand: ~w(4S 5H 4C 5D 4H) # Full house, 5s over 4s
  """

  @spec best_hand(list(list(String.t()))) :: list(list(String.t()))
  def best_hand(hands) when length(hands) == 1, do: hands

  def best_hand(hands) do
    hands
    |> Enum.map(&Hand.parse_hand/1)
    |> find_best_hand()
  end

  defp find_best_hand(hands) do
    sorted_hands =
      hands
      |> Hand.sort_hands()

    winning_category = sorted_hands |> Enum.at(-1) |> Map.get(:category)

    winning_hands = sorted_hands |> Enum.filter(fn hand -> hand.category == winning_category end)

    case winning_hands |> length() do
      1 -> winning_hands |> Enum.map(&Hand.print_hand/1)
      _ -> find_high_hands(winning_hands, winning_category) |> Enum.map(&Hand.print_hand/1)
    end
  end

  defp find_high_hands(hands, category) do
    case category do
      :high_card -> tie_breaker_hc(hands)
      _ -> raise("Error")
    end
  end

  defp tie_breaker_hc([first_hand | hands]), do: tie_breaker_hc(hands, [first_hand])
  defp tie_breaker_hc([], best_hands), do: best_hands

  defp tie_breaker_hc([hand | hands], [best_hand | _tail] = best_hands) do
    case get_high_card(Card.sort_cards(hand.cards), Card.sort_cards(best_hand.cards)) do
      :tie -> tie_breaker_hc(hands, [hand | best_hands])
      :first -> tie_breaker_hc(hands, [hand])
      :second -> tie_breaker_hc(hands, best_hands)
    end
  end

  defp get_high_card([], []), do: :tie

  defp get_high_card([card_0 | hand_0], [card_1 | hand_1]) when card_0.value == card_1.value,
    do: get_high_card(hand_0, hand_1)

  defp get_high_card([card_0 | _hand_0], [card_1 | _hand_1]) when card_0.value > card_1.value,
    do: :first

  defp get_high_card([card_0 | _hand_0], [card_1 | _hand_1]) when card_0.value < card_1.value,
    do: :second
end
