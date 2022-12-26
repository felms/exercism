defmodule RationalNumbers do
  @type rational :: {integer, integer}

  @doc """
  Add two rational numbers
  """
  @spec add(a :: rational, b :: rational) :: rational
  def add({num_a, den_a}, {num_b, den_b}) do
    num = num_a * den_b + num_b * den_a
    den = den_a * den_b
    reduce({num, den})
  end

  @doc """
  Subtract two rational numbers
  """
  @spec subtract(a :: rational, b :: rational) :: rational
  def subtract({num_a, den_a}, {num_b, den_b}) do
    num = num_a * den_b - num_b * den_a
    den = den_a * den_b
    reduce({num, den})
  end

  @doc """
  Multiply two rational numbers
  """
  @spec multiply(a :: rational, b :: rational) :: rational
  def multiply({num_a, den_a}, {num_b, den_b}) do
    num = num_a * num_b
    den = den_a * den_b
    reduce({num, den})
  end

  @doc """
  Divide two rational numbers
  """
  @spec divide_by(num :: rational, den :: rational) :: rational
  def divide_by({num_a, den_a}, {num_b, den_b}) do
    num = num_a * den_b
    den = den_a * num_b
    reduce({num, den})
  end

  @doc """
  Absolute value of a rational number
  """
  @spec abs(a :: rational) :: rational
  def abs({num, den}) do
    {Kernel.abs(num), Kernel.abs(den)} |> reduce()
  end

  @doc """
  Exponentiation of a rational number by an integer
  """
  @spec pow_rational(a :: rational, n :: integer) :: rational
  def pow_rational({num, den}, n) when n < 0 do
    new_den = num ** Kernel.abs(n)
    new_num = den ** Kernel.abs(n)
    reduce({new_num, new_den})
  end

  def pow_rational({num, den}, n) do
    new_num = num ** n
    new_den = den ** n
    reduce({new_num, new_den})
  end

  @doc """
  Exponentiation of a real number by a rational number
  """
  @spec pow_real(x :: integer, n :: rational) :: float
  def pow_real(x, {num, den}) do
    x ** (num / den)
  end

  @doc """
  Reduce a rational number to its lowest terms
  """
  @spec reduce(a :: rational) :: rational
  def reduce({num, den}) do
    gcd = Integer.gcd(num, den)

    if den < 0 do
      {div(-num, gcd), div(-den, gcd)}
    else
      {div(num, gcd), div(den, gcd)}
    end
  end
end
