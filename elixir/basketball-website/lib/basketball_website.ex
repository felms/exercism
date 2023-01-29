defmodule BasketballWebsite do
  def extract_from_path(data, path) do
    ext_path(data, String.split(path, "."))
  end

  defp ext_path(data, []), do: data

  defp ext_path(data, [h | remaining_path]) do
    ext_path(data[h], remaining_path)
  end

  def get_in_path(data, path) do
    get_in(data, String.split(path, "."))
  end
end
