defmodule TakeANumber do
  def start() do
    state = 0
    spawn(fn -> loop(state) end)
  end

  defp loop(state) do
    receive do
      {:report_state, sender_pid} ->
        send(sender_pid, state)
        loop(state)

      {:take_a_number, sender_pid} ->
        send(sender_pid, state + 1)
        loop(state + 1)

      :stop ->
        :ok

      _ ->
        loop(state)
    end
  end
end
