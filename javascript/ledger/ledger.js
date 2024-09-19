class LedgerEntry {
    constructor() {
        this.day = undefined;
        this.month = undefined;
        this.year = undefined;
        this.description = undefined;
        this.change = undefined;
    }
}

export function createEntry(date, description, change) {
    let entry = new LedgerEntry();
    let [_, year, month, day, ...rest] = /(\d{4})-(\d{2})-(\d{2})/.exec(date);
    entry.year = year;
    entry.month = month;
    entry.day = day;
    entry.description = description;
    entry.change = change;
    return entry;
}

export function formatEntries(currency, locale, entries) {
    let table = '';
    if (locale === 'en-US') {
        // Generate Header Row
        table +=
        'Date'.padEnd(10, ' ') +
            ' | ' +
            'Description'.padEnd(25, ' ') +
            ' | ' +
            'Change'.padEnd(13, ' ') +
            '\n';

        // Sort entries
        entries.sort(
            (a, b) =>
                a.date - b.date ||
                    a.change - b.change ||
                    a.description.localeCompare(b.description),
        );

        entries.forEach((entry) => {
            // Write entry date to table
            const dateStr = `${(entry.month)
                                .toString()
                                .padStart(2, '0')}/${(entry.day)
                                .toString()
                                .padStart(2, '0')}/${entry.year}`;

            console.log(dateStr);
            table += `${dateStr} | `;

            // Write entry description to table
            const truncatedDescription =
                entry.description.length > 25
                    ? `${entry.description.substring(0, 22)}...`
                    : entry.description.padEnd(25, ' ');
            table += `${truncatedDescription} | `;

            // Write entry change to table
            let changeStr = '';
            if (currency === 'USD') {
                let formatingOptions = {
                    style: 'currency',
                    currency: 'USD',
                    //currencySign: 'accounting',
                    minimumFractionDigits: 2,
                    maximumFractionDigits: 2,
                };
                if (entry.change < 0) {
                    changeStr = `(${Math.abs(entry.change / 100)
                                    .toLocaleString('en-US', formatingOptions,)})`;
                } else {
                    changeStr = `${(entry.change / 100).toLocaleString('en-US', formatingOptions,)} `;
                }
            } else if (currency === 'EUR') {
                let formatingOptions = {
                    style: 'currency',
                    currency: 'EUR',
                    minimumFractionDigits: 2,
                    maximumFractionDigits: 2,
                };
                if (entry.change < 0) {
                    changeStr = `(${Math.abs(entry.change / 100).toLocaleString('en-US', formatingOptions,)})`;
                } else {
                    changeStr = `${(entry.change / 100).toLocaleString( 'en-US', formatingOptions,)} `;
                }
            }
            table += changeStr.padStart(13, ' ');
            table += '\n';
        });
    } else if (locale === 'nl-NL') {
        // Generate Header Row
        table +=
        'Datum'.padEnd(10, ' ') +
            ' | ' +
            'Omschrijving'.padEnd(25, ' ') +
            ' | ' +
            'Verandering'.padEnd(13, ' ') +
            '\n';

        // Sort entries
        // entries.sort(
        //     (a, b) =>
        //         a.date - b.date ||
        //             a.change - b.change ||
        //             a.description.localeCompare(b.description),
        // );

        entries.forEach((entry) => {
            // Write entry date to table
            const dateStr = `${(entry.day).padStart(2, '0')}-${(
                                entry.month).padStart(2, '0')}-${entry.year}`;

            table += `${dateStr} | `;

            // Write entry description to table
            const truncatedDescription =
                entry.description.length > 25
                    ? `${entry.description.substring(0, 22)}...`
                    : entry.description.padEnd(25, ' ');
            table += `${truncatedDescription} | `;

            // Write entry change to table
            let changeStr = '';
            if (currency === 'USD') {
                let formatingOptions = {
                    style: 'currency',
                    currency: 'USD',
                    currencyDisplay: 'narrowSymbol',
                    minimumFractionDigits: 2,
                    maximumFractionDigits: 2,
                };
                changeStr = `${(entry.change / 100).toLocaleString( 'nl-NL', formatingOptions,)} `;
            } else if (currency === 'EUR') {
                let formatingOptions = {
                    style: 'currency',
                    currency: 'EUR',
                    currencyDisplay: 'narrowSymbol',
                    minimumFractionDigits: 2,
                    maximumFractionDigits: 2,
                };
                changeStr = `${(entry.change / 100).toLocaleString( 'nl-NL', formatingOptions,)} `;
            }
            table += changeStr.padStart(13, ' ');
            table += '\n';
        });
    }
    return table.replace(/\n$/, '');
}
