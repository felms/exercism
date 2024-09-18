defmodule PhoneNumber do
  @doc """
  Remove formatting from a phone number if the given number is valid. Return an error otherwise.
  """
  @spec clean(String.t()) :: {:ok, String.t()} | {:error, String.t()}
  def clean(raw) do
    with {:ok, cleaned_number} <- clean_number(raw),
         {:ok, trimmed_number} <- check_length(cleaned_number),
         {:ok, number} <- check_area_and_exchange_code(trimmed_number) do
      {:ok, number}
    else
      err -> err
    end
  end

  defp clean_number(number) do
    cond do
      number =~ ~r/.*[a-z]+.*/ -> {:error, "must contain digits only"}
      number =~ ~r/[^\d\s()-.]/ -> {:error, "must contain digits only"}
      true -> {:ok, String.replace(number, ~r/\D/, "")}
    end
  end

  defp check_length(<<number::binary-size(10)>>), do: {:ok, number}
  defp check_length(<<"1", number::binary-size(10)>>), do: {:ok, number}
  defp check_length(<<_, _::binary-size(10)>>), do: {:error, "11 digits must start with 1"}
  defp check_length(<<_, _::binary-size(10), _>>), do: {:error, "must not be greater than 11 digits"}
  defp check_length(_), do: {:error, "must not be fewer than 10 digits"}

  defp check_area_and_exchange_code(number) do
    cond do
      number =~ ~r/0\d{9}/ -> {:error, "area code cannot start with zero"}
      number =~ ~r/1\d{9}/ -> {:error, "area code cannot start with one"}
      number =~ ~r/\d{3}0\d{6}/ -> {:error, "exchange code cannot start with zero"}
      number =~ ~r/\d{3}1\d{6}/ -> {:error, "exchange code cannot start with one"}
      true -> {:ok, number}
    end
  end
end
