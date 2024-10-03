# -*- coding: utf-8 -*-
from datetime import datetime


class LedgerEntry:
    def __init__(self):
        self.date = None
        self.description = None
        self.change = None


def create_entry(date, description, change):
    entry = LedgerEntry()
    entry.date = datetime.strptime(date, '%Y-%m-%d')
    entry.description = description
    entry.change = change
    return entry


def format_entries(currency, locale, entries):

    header = 'Date       | Description               | Change       '\
        if locale == 'en_US' \
        else 'Datum      | Omschrijving              | Verandering  '

    if not entries:
        return header

    entries.sort(key=lambda entry: (entry.date, entry.change))

    return header + '\n' + \
        '\n'.join([format_entry(entry, locale, currency) for entry in entries])


def format_entry(entry, locale, currency):

    return format_date(entry.date, locale) + \
            '|' + format_description(entry.description) + \
            '|' + format_change(entry.change, locale, currency)


def format_date(date, locale):

    if locale == 'en_US':
        return date.strftime('%m/%d/%Y') + ' '
    else:
        return date.strftime('%d-%m-%Y') + ' '


def format_description(description):

    return f' {description[:22]}... ' \
        if len(description) > 25 else f' {description.ljust(25)} '


def format_change(change, locale, currency):

    formatted_currency = '{:0,.2f}'.format(abs(change / 100.0))
    change_str = '$' if currency == 'USD' else '€'

    if locale == 'en_US':

        change_str += formatted_currency
        change_str = f'({change_str})' if change < 0 else f'{change_str} '

    elif locale == 'nl_NL':

        change_str += ' '

        if change < 0:
            change_str += '-'

        change_str += formatted_currency + ' '
        change_str = change_str.replace(',', 'v')
        change_str = change_str.replace('.', ',')
        change_str = change_str.replace('v', '.')

    change_str = f' {change_str.rjust(13)}'

    return change_str
