defmodule Card do
  defstruct [:rank, :suit, :value]

  @rank_value %{
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
    ace: 14
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

  def parse_card(card) do
    rank = String.replace(card, ~r/\w{1}$/, "")
    suit = String.replace(card, rank, "")

    %Card{
      rank: @number_to_rank[rank],
      suit: @suits[suit],
      value: @rank_value[@number_to_rank[rank]]
    }
  end

  def sort_cards(cards) do
    cards
    |> Enum.sort(fn card_0, card_1 ->
      card_0.value >= card_1.value
    end)
  end
end
