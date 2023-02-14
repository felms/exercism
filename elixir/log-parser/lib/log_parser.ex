defmodule LogParser do
  def valid_line?(line) do
    line =~ ~r/^\[(DEBUG|INFO|WARNING|ERROR)\].*/
  end

  def split_line(line) do
    String.split(line, ~r/\<[~*=-]*\>/, trim: true)
  end

  def remove_artifacts(line) do
    String.replace(line, ~r/end-of-line\d+/i, "", global: true)
  end

  def tag_with_user_name(line) do
    match = Regex.run(~r/User\s+(\S+)/, line)

    case match do
      nil -> line
      [_ | capture] -> "[USER] #{capture} #{line}"
    end
  end
end
