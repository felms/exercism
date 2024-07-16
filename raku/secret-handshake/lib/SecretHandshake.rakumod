unit module SecretHandshake;

sub handshake ( $number ) is export {
    my @list = ();
    
    if $number +& 1 {
        @list.push("wink")
    }

    if $number +& 2 {
        @list.push("double blink")
    }

    if $number +& 4 {
        @list.push("close your eyes")
    }

    if $number +& 8 {
        @list.push("jump")
    }

    $number +& 16 ?? reverse(@list) !! @list
    
}
