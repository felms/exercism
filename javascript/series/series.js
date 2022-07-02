export class Series {
    constructor(series) {
        if (series.length === 0) {
            throw new Error('series cannot be empty');
        }

        this.series = series;
    }

    slices(sliceLength) {
        let size = this.series.length;

        if (sliceLength > size) {
            throw new Error('slice length cannot be greater than series length');
        }

        if (sliceLength === 0) {
            throw new Error('slice length cannot be zero');
        }

        if (sliceLength < 0) {
            throw new Error('slice length cannot be negative');
        }

        let slicesList = [];
        let seriesArray = this.series.split('').map(letter => parseInt(letter));

        for (let i = 0; i + sliceLength <= size; i++) {
            let currentSlice = [];
            for (let j = i; j < i + sliceLength; j++) {
                currentSlice.push(seriesArray[j]); 
            }
            slicesList.push(currentSlice);
        }

        return slicesList;
    }
}
