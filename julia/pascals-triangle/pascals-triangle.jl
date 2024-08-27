function triangle(n)

    n < 0 && throw(DomainError(n))

    n == 0 && return []

    n == 1 && return [[1]]

    r = triangle(n - 1)
    push!(r, generate_row(r[end]))

    return r

end

function generate_row(previous_row)

    row0 = append!([0], copy(previous_row))

    row1 = append!(copy(previous_row), [0])

    return [ a + b for (a, b) in zip(row0, row1)]
end
