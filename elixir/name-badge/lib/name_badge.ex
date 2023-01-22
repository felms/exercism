defmodule NameBadge do
  @spec print(integer(), String.t(), String.t()) :: String.t()
  def print(id, name, department) do
    id_str = if id, do: "[#{id}] - ", else: ""
    department_str = if department, do: " - #{String.upcase(department)}", else: " - OWNER"

    id_str <> name <> department_str
  end
end
