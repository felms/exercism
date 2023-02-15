defmodule Bob do
  @spec hey(String.t()) :: String.t()
  def hey(input) do
    cond do
      uppercase?(input) and input =~ ~r/.+\?/ -> "Calm down, I know what I'm doing!"
      uppercase?(input) -> "Whoa, chill out!"
      input =~ ~r/.+\?\s*$/ -> "Sure."
      input =~ ~r/^\s*$/ -> "Fine. Be that way!"
      true -> "Whatever."
    end
  end

  defp uppercase?(string) do
    string == String.upcase(string) and string != String.downcase(string) 
  end
end
