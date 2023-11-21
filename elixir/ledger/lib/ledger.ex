defmodule Ledger do
  @doc """
  Format the given entries given a currency and locale
  """
  @type currency :: :usd | :eur
  @type locale :: :en_US | :nl_NL
  @type entry :: %{amount_in_cents: integer(), date: Date.t(), description: String.t()}

  @headers %{
    en_US: "Date       | Description               | Change       \n",
    nl_NL: "Datum      | Omschrijving              | Verandering  \n"
  }

  @separators %{
    en_US: %{thousand_separator: ",", decimal_separator: ".", date_separator: "/"},
    nl_NL: %{thousand_separator: ".", decimal_separator: ",", date_separator: "-"}
  }

  @currencies %{usd: "$", eur: "€"}

  @spec format_entries(currency(), locale(), list(entry())) :: String.t()
  def format_entries(_currency, locale, []), do: @headers[locale]

  def format_entries(currency, locale, entries) do
    entries =
      Enum.sort(entries, fn a, b ->
        cond do
          a.date.day < b.date.day -> true
          a.date.day > b.date.day -> false
          a.description < b.description -> true
          a.description > b.description -> false
          true -> a.amount_in_cents <= b.amount_in_cents
        end
      end)
      |> Enum.map(fn entry -> format_entry(currency, locale, entry) end)
      |> Enum.join("\n")

    @headers[locale] <> entries <> "\n"
  end

  defp format_entry(currency, locale, entry) do
    date = format_date(locale, entry)

    amount =
      format_number(@separators[locale], entry)
      |> format_amount(currency, locale, entry.amount_in_cents)
      |> String.pad_leading(14, " ")

    description = format_description(entry, entry.description |> String.length())

    date <> "|" <> description <> " |" <> amount
  end

  defp format_date(locale, entry) do
    year = entry.date.year |> to_string()
    month = entry.date.month |> to_string() |> String.pad_leading(2, "0")
    day = entry.date.day |> to_string() |> String.pad_leading(2, "0")

    format_date_to_locale(year, month, day, locale)
  end

  defp format_date_to_locale(year, month, day, :en_US),
    do:
      month <>
        @separators.en_US.date_separator <> day <> @separators.en_US.date_separator <> year <> " "

  defp format_date_to_locale(year, month, day, :nl_NL),
    do:
      day <>
        @separators.nl_NL.date_separator <>
        month <> @separators.nl_NL.date_separator <> year <> " "

  defp format_number(separator, entry) do
    decimal =
      entry.amount_in_cents |> abs |> rem(100) |> to_string() |> String.pad_leading(2, "0")

    whole = entry.amount_in_cents |> div(100) |> abs()

    if whole < 1000 do
      whole |> to_string()
    else
      whole
      |> div(1000)
      |> to_string()
      |> Kernel.<>(separator.thousand_separator)
      |> Kernel.<>(whole |> rem(1000) |> to_string())
    end
    |> Kernel.<>(separator.decimal_separator)
    |> Kernel.<>(decimal)
  end

  defp format_amount(number, currency, :en_US, amount) when amount >= 0,
    do: "  #{@currencies[currency]}#{number} "

  defp format_amount(number, currency, :nl_NL, amount) when amount >= 0,
    do: " #{@currencies[currency]} #{number} "

  defp format_amount(number, currency, :en_US, _amount),
    do: " (#{@currencies[currency]}#{number})"

  defp format_amount(number, currency, :nl_NL, _amount),
    do: " #{@currencies[currency]} -#{number} "

  defp format_description(entry, length) when length > 26,
    do: " " <> String.slice(entry.description, 0, 22) <> "..."

  defp format_description(entry, _), do: " " <> String.pad_trailing(entry.description, 25, " ")
end
