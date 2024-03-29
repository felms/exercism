defmodule Grep do
  @spec grep(String.t(), [String.t()], [String.t()]) :: String.t()
  def grep(pattern, flags, files) when length(files) == 1 do
    files
    |> hd()
    |> grep_file(pattern, flags)
  end

  def grep(pattern, flags, files) do
    files
    |> Enum.map(fn file_name -> {file_name, grep_file(file_name, pattern, flags)} end)
    |> Enum.reject(fn {_file_name, text} -> text == "" end)
    |> Enum.map(&prepend_filename/1)
    |> Enum.join("\n")
    |> then(&if String.length(&1) > 0, do: &1 <> "\n", else: "")
  end

  defp grep_file(file, pattern, flags) do
    file
    |> search_in_file(pattern, flags)
    |> then(&if String.length(&1) > 0, do: &1 <> "\n", else: "")
  end

  defp search_in_file(file_name, pattern, flags) do
    lines =
      File.read!(file_name)
      |> String.split("\n", trim: true)
      |> Enum.with_index(1)

    cond do
      "-l" in flags ->
        if lines |> match_lines(pattern, flags) |> length() > 0, do: file_name, else: ""

      "-n" in flags ->
        lines
        |> match_lines(pattern, flags)
        |> Enum.map(fn {text, index} -> "#{index}:#{text}" end)
        |> Enum.join("\n")

      true ->
        lines
        |> match_lines(pattern, flags)
        |> Enum.map(fn {text, _index} -> text end)
        |> Enum.join("\n")
    end
  end

  defp match_lines(lines, pattern, flags) do
    cond do
      "-i" in flags and "-x" in flags ->
        lines
        |> Enum.filter(fn {text, _index} -> String.downcase(text) == String.downcase(pattern) end)

      "-v" in flags ->
        lines -- match_lines(lines, pattern, flags -- ["-v"])

      "-i" in flags ->
        lines
        |> Enum.filter(fn {text, _index} ->
          String.downcase(text) |> String.contains?(String.downcase(pattern))
        end)

      "-x" in flags ->
        lines |> Enum.filter(fn {text, _index} -> text == pattern end)

      true ->
        lines |> Enum.filter(fn {text, _index} -> String.contains?(text, pattern) end)
    end
  end

  defp prepend_filename({file_name, lines}) do
    lines
    |> String.split("\n", trim: true)
    |> Enum.map(&if &1 == file_name, do: file_name, else: "#{file_name}:#{&1}")
    |> Enum.join("\n")
  end
end
