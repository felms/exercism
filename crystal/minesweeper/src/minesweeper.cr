class Minesweeper
  @grid : Array(Array(String))

  def initialize(input : Array(String))
    @grid = input.map(&.split(""))
  end

  def annotate()
    return [] of String if @grid.empty?

    r = 0

    while r < @grid.size

        c = 0
        while c < @grid[0].size

            if @grid[r][c] == " "

                n = self.get_neighbors(r, c).count{ |item| @grid[item[0]][item[1]] == "*" }
                @grid[r][c] = n > 0 ? n.to_s : " "
            end

            c += 1
        end
        r += 1
    end

    @grid.map(&.join)
  end

  def get_neighbors(r, c)
    rows = @grid.size
    columns = @grid[0].size

    [[r - 1, c], [r + 1, c], [r, c - 1], [r, c + 1],
     [r - 1, c - 1], [r - 1, c + 1], [r + 1, c - 1], [r + 1, c + 1]]
        .select{ |item| item[0] >= 0 && item[0] < rows && item[1] >= 0 && item[1] < columns }
  end
end
