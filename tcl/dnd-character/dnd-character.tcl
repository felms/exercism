namespace eval dnd {
    namespace export character ability modifier
    namespace ensemble create

    proc modifier {score} {
        return [expr ($score - 10) / 2]
    }

    proc ability {} {
        set r0 [expr floor(rand() * 6 + 1)]
        set r1 [expr floor(rand() * 6 + 1)]
        set r2 [expr floor(rand() * 6 + 1)]
        set r3 [expr floor(rand() * 6 + 1)]

        set min_value [expr min($r0, $r1, $r2, $r3)]
        set total_value [expr $r0 + $r1 + $r2 + $r3]

        return [expr $total_value - $min_value]
    }

    proc character {} {
        set cst [dnd ability]
        set mod [dnd modifier $cst]
        set hitp [expr 10 + $mod]

        set ch [dnd ability]
        set dx [dnd ability]
        set in [dnd ability]
        set st [dnd ability]
        set wd [dnd ability]

        set res [dict create charisma $ch constitution $cst dexterity $dx intelligence $in strength $st wisdom $wd hitpoints $hitp]

        
        return $res
    }
}

