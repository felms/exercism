defmodule SpaceAge do
  @type planet ::
  :mercury
  | :venus
  | :earth
  | :mars
  | :jupiter
  | :saturn
  | :uranus
  | :neptune

  @earth_year_in_seconds 31_557_600

  @planet_to_earth_age %{
    mercury: 0.2408467,
    venus: 0.61519726,
    earth: 1.0,
    mars: 1.8808158,
    jupiter: 11.862615,
    saturn: 29.447498,
    uranus: 84.016846,
    neptune: 164.79132
  }


  @doc """
  Return the number of years a person that has lived for 'seconds' seconds is
  aged on 'planet', or an error if 'planet' is not a planet.
  """
  @spec age_on(planet, pos_integer) :: {:ok, float} | {:error, String.t()}
  def age_on(planet, seconds) when is_map_key(@planet_to_earth_age, planet) do
    {
      :ok, 
      (seconds / @earth_year_in_seconds) / @planet_to_earth_age[planet]
    }
  end
  def age_on(_, _), do: {:error, "not a planet"}
end
