proc abbreviate {phrase} {

    set res ""

    set phrase [string map {"-" " "} $phrase]
    set phrase [string map {"_" " "} $phrase]

    set array [split $phrase " "]

    foreach word $array {
        set letter [string range $word 0 0]
        set res $res$letter
    }

    set res [string toupper $res]

    return $res
}
