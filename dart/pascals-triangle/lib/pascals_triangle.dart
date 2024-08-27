class PascalsTriangle {

    List<List<int>> rows(int numberOfRows) {
         
        if (numberOfRows == 0) {
            return <List<int>>[];
        }

        if (numberOfRows == 1) {
            return <List<int>>[<int>[1]];
        }

        var res = rows(numberOfRows - 1);
        res.add(generateRow(res.last));

        return res;
    }

    List<int> generateRow(List<int> previousRow) {

        var row0 = <int>[0];
        row0.addAll(previousRow);

        var row1 = <int>[];
        row1.addAll(previousRow);
        row1.add(0);

        var res = <int>[];

        for (var i = 0; i < row0.length; i++) {
            res.add(row0[i] + row1[i]);
        }

        return res;
    }
}
