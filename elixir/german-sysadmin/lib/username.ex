defmodule Username do
  @spec sanitize(username :: charlist()) :: charlist()
  def sanitize(''), do: ''

  def sanitize([head | tail]) do
    char =
      case head do
        head when head in ?a..?z -> [head]
        ?ä -> 'ae'
        ?ö -> 'oe'
        ?ü -> 'ue'
        ?ß -> 'ss'
        ?_ -> '_'
        _ -> ''
      end

    char ++ sanitize(tail)
  end
end
