defmodule GuessingGame do
  def compare(secret_number, guess) when secret_number === guess do
    "Correct"
  end
end
