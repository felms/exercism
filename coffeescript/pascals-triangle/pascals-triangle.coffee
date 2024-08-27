class PascalsTriangle
  rows: (num) ->

    return if num == 0 then []

    return if num == 1 then [[1]]

    r = this.rows(num - 1)
    [r..., this.generateRow(r[r.length - 1])...]

  generateRow: (previousRow) ->
    
    row0 = [0, previousRow...]
    row1 = [previousRow..., 0]

    [row0[i] + row1[i] for i in [0...row0.length]]

module.exports = PascalsTriangle
