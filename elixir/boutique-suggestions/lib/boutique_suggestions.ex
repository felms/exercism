defmodule BoutiqueSuggestions do
  def get_combinations(tops, bottoms, options \\ []) do
    maximum_price = Keyword.get(options, :maximum_price, 100)

    for x <- tops,
        y <- bottoms,
        x.base_color != y.base_color,
        x.price + y.price <= maximum_price,
        do: {x, y}
  end
end
