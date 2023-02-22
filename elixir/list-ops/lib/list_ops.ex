defmodule ListOps do
  # Please don't use any external modules (especially List or Enum) in your
  # implementation. The point of this exercise is to create these basic
  # functions yourself. You may use basic Kernel functions (like `Kernel.+/2`
  # for adding numbers), but please do not use Kernel functions for Lists like
  # `++`, `--`, `hd`, `tl`, `in`, and `length`.

  @spec count(list) :: non_neg_integer
  def count(l), do: do_count(l, 0)
  defp do_count([], counter), do: counter
  defp do_count([_h | t], counter), do: do_count(t, counter + 1)


  @spec reverse(list) :: list
  def reverse(l), do: do_reverse(l, [])
  defp do_reverse([], reversed_list), do: reversed_list
  defp do_reverse([h | t], reversed_list), do: do_reverse(t, [h | reversed_list])

  @spec map(list, (any -> any)) :: list
  def map(l, f), do: do_map(l, f, [])
  defp do_map([], _f, resulting_list), do: reverse(resulting_list)
  defp do_map([h | t], f, resulting_list), do: do_map(t, f, [f.(h) | resulting_list])

  @spec filter(list, (any -> as_boolean(term))) :: list
  def filter(l, f), do: do_filter(l, f, [])

  defp do_filter([], _f, filtered_list), do: reverse(filtered_list)
  defp do_filter([h | t], f, filtered_list) do
    if f.(h) do
      do_filter(t, f, [h | filtered_list])
    else
      do_filter(t, f, filtered_list)
    end
  end

  @type acc :: any
  @spec foldl(list, acc, (any, acc -> acc)) :: acc
  def foldl([], acc, _f), do: acc
  def foldl([h | t], acc, f), do: foldl(t, f.(h, acc), f)


  @spec foldr(list, acc, (any, acc -> acc)) :: acc
  def foldr([], acc, _f), do: acc
  def foldr(l, acc, f), do: foldl(reverse(l), acc, f)

  @spec append(list, list) :: list
  def append(a, b), do: do_append(reverse(a), b)
  defp do_append([], b), do: b
  defp do_append([h | t], b), do: do_append(t, [h | b])

  @spec concat([[any]]) :: [any]
  def concat(ll), do: foldr(ll,[], &do_concat/2)
  defp do_concat(a, b) when is_list(a) and is_list(b), do: append(a, b)
  defp do_concat(a, b) when is_list(a), do: append(a, [b])
  defp do_concat(a, b) when is_list(b), do: append([a], b)

end
