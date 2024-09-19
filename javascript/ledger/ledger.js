class LedgerEntry {
    constructor() {
        this.day = undefined;
        this.month = undefined;
        this.year = undefined;
        this.description = undefined;
        this.change = undefined;
    }

    toString(locale, currency) {

        const dateString = this.#getDateString(locale);

        const truncatedDescription = this.description.length > 25 
            ? `${this.description.substring(0, 22)}...` 
            : this.description.padEnd(25, ' ');

        const changeStr = this.#getChangeStr(locale, currency);

        return `${dateString} | ${truncatedDescription} |${changeStr.padStart(14, ' ')}`;
    }

    #getDateString(locale) {

        return (locale === 'en-US') 
                ? `${(this.month).padStart(2, '0')}/${(this.day).padStart(2, '0')}/${this.year}`
                : `${(this.day).padStart(2, '0')}-${(this.month).padStart(2, '0')}-${this.year}`;

    }

    #getChangeStr(locale, currency) {

        let formatingOptions = {
            style: 'currency',
            currency: currency,
            currencyDisplay: 'narrowSymbol',
            minimumFractionDigits: 2,
            maximumFractionDigits: 2,
        };

        return locale === 'en-US' && this.change < 0
            ? `(${(Math.abs(this.change / 100)).toLocaleString(locale, formatingOptions)})`
            : `${(this.change / 100).toLocaleString(locale, formatingOptions)} `;

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
    let [dt, desc, ch] = (locale === 'en-US') 
        ? ['Date', 'Description', 'Change'] : ['Datum', 'Omschrijving', 'Verandering'];

    // Generate Header Row
        table += dt.padEnd(10, ' ') + ' | ' 
                + desc.padEnd(25, ' ') + ' | ' + ch.padEnd(13, ' ') + '\n';

    // Sort entries
    entries.sort(
        (a, b) =>
            new Date(a.year, (a.month - 1), a.day) - new Date(b.year, (b.month - 1), b.day) ||
                a.change - b.change ||
                a.description.localeCompare(b.description),
    );

    // Get the string representation of each entry
    table += entries.map((entry) => entry.toString(locale, currency)).join('\n');

    return table.replace(/\n$/, '');
}
