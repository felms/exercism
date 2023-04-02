defmodule Grep do
  @spec grep(String.t(), [String.t()], [String.t()]) :: String.t()
  def grep(pattern, flags, files) do
    files
    |> Enum.map(&search_in_file(&1, pattern, flags))
    |> Enum.join("\n")
    |> IO.inspect()
    |> then(&if String.length(&1) > 0, do: &1 <> "\n", else: "")
  end

  defp search_in_file(file_name, pattern, flags) do
    lines =
      File.read!(file_name)
      |> String.split("\n", trim: true)
      |> Enum.with_index(1)

    cond do
      "-l" in flags ->
        if lines |> filter_lines(pattern) |> length() > 0, do: file_name, else: ""

      "-n" in flags ->
        lines
        |> filter_lines(pattern)
        |> Enum.map(fn {text, index} -> "#{index}:#{text}" end)
        |> Enum.join("\n")

      "-i" in flags ->
        lines
        |> filter_lines(pattern, true)
        |> Enum.map(fn {text, _index} -> text end)
        |> Enum.join("\n")

      "-x" in flags ->
        lines |> Enum.map(&match_entire_line(&1, pattern)) |> Enum.join("\n") |> String.trim()

      "-v" in flags ->
        lines
        |> Enum.reject(fn {text, _index} -> String.contains?(text, pattern) end)
        |> Enum.map(fn {text, _index} -> text end)
        |> Enum.join("\n")

      true ->
        lines
        |> filter_lines(pattern)
        |> Enum.map(fn {text, _index} -> text end)
        |> Enum.join("\n")
    end
  end

  defp filter_lines(lines, pattern, case_insensitive \\ false) do
    if case_insensitive do
      lines
      |> Enum.filter(fn {text, _index} ->
        String.downcase(text) |> String.contains?(String.downcase(pattern))
      end)
    else
      lines |> Enum.filter(fn {text, _index} -> String.contains?(text, pattern) end)
    end
  end

  defp match_entire_line({text, _index}, pattern) when text == pattern, do: text
  defp match_entire_line(_line, _pattern), do: ""
end
