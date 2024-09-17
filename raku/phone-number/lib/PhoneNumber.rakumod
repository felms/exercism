unit module PhoneNumber;

constant @errors = (
   '11 digits must start with 1',
   'must not be greater than 11 digits',
   'must not be fewer than 10 digits',
   'letters not permitted',
   'punctuations not permitted',
   'area code cannot start with zero',
   'area code cannot start with one',
   'exchange code cannot start with zero',
   'exchange code cannot start with one',
);

sub clean-number ($number) is export {

    if $number ~~ /<alpha>/ {
        die @errors[3]
    }

    if $number ~~ /<[\\@:!]>/ {
        die @errors[4]
    }

    my $num = $number.subst(/\D/, '', :g);

    if $num.chars < 10 {
        die @errors[2]
    }

    if $num.chars > 11 {
        die @errors[1]
    }

    if $num ~~ /^<[\d] - [1]> \d ** 10$/ {
        die @errors[0]
    }

    if $num ~~ /^[1] \d ** 10$/ {
        $num = substr($num, 1)
    }

    if $num ~~ /^[0] \d ** 9$/ {
        die @errors[5]
    }

    if $num ~~ /^[1] \d ** 9$/ {
        die @errors[6]
    }

    if $num ~~ /^\d ** 3 [0] \d ** 6$/ {
        die @errors[7]
    }

    if $num ~~ /^\d ** 3 [1] \d ** 6$/ {
        die @errors[8]
    }

    $num
}
