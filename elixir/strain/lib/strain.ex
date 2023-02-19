defmodule Strain do
  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns true.

  Do not use `Enum.filter`.
  """
  @spec keep(list :: list(any), fun :: (any -> boolean)) :: list(any)
  def keep(list, fun) do
    do_keep(list, fun, [])
  end

  defp do_keep([], _fun, result), do: result

  defp do_keep([h | t], fun, result) do
    if fun.(h) do
      do_keep(t, fun, result ++ [h])
    else
      do_keep(t, fun, result)
    end
  end

  @doc """
  Given a `list` of items and a function `fun`, return the list of items where
  `fun` returns false.

  Do not use `Enum.reject`.
  """
  @spec discard(list :: list(any), fun :: (any -> boolean)) :: list(any)
  def discard(list, fun) do
    do_discard(list, fun, [])
  end

  defp do_discard([], _fun, result), do: result

  defp do_discard([h | t], fun, result) do
    if fun.(h) do
      do_discard(t, fun, result)
    else
      do_discard(t, fun, result ++ [h])
    end
  end
end
