package Luhn;

use v5.38;

use Exporter qw<import>;
our @EXPORT_OK = qw<is_luhn_valid>;

sub is_luhn_valid ($number) {

    # trim both ends of input
    $number =~ s/^\s+|\s+$//g;

    # check if it's a valid string
    if ($number =~ /[^\d\s]/g|| length($number) < 2) {
        return 0;
    }

    # clean whitespaces
    $number =~ s/\s+//g;


    # test if it is a valid Luhn number
    my @numbers = split //, $number;

    my $i = @numbers - 2;

    while ($i >= 0) {
        my $digit = @numbers[$i] * 2;
        if ($digit > 9) {
            @numbers[$i] = $digit - 9;
        } else {
            @numbers[$i] = $digit;
        }
        $i -= 2;
    }

    my $index = 0;
    my $sum = 0;
    while ($index < @numbers) {
        $sum += @numbers[$index];
        $index++;
    }

    return ($sum % 10) == 0;
}
