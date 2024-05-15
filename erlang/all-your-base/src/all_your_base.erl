-module(all_your_base).
-export([rebase/3]).


rebase(_, InputBase, _) when InputBase < 2 -> {error, "input base must be >= 2"};
rebase(_, _, OutputBase) when OutputBase < 2 -> {error, "output base must be >= 2"};
rebase([], _, _) -> {ok, [0]};
rebase(Digits, InputBase, OutputBase) -> 
    to_base10(lists:reverse(Digits), InputBase, OutputBase, 0, 0).

to_base10([], InputBase, OutputBase, _, Acc) -> from_base10(Acc, OutputBase, []);
to_base10([Digit | _], InputBase, _, _, Acc) when Digit < 0 -> 
    {error, "all digits must satisfy 0 <= d < input base"};
to_base10([Digit | _], InputBase, _, _, Acc) when Digit >= InputBase -> 
    {error, "all digits must satisfy 0 <= d < input base"};
to_base10([Digit | RemDigits], InputBase, OutputBase, Index, Acc) -> 
    to_base10(RemDigits, InputBase, OutputBase, Index + 1, Acc + trunc(Digit * math:pow(InputBase, Index))).

from_base10(0, _, []) -> {ok, [0]};
from_base10(0, _, OutputDigits) -> {ok, OutputDigits};
from_base10(InputValue, OutputBase, OutputDigits) -> 
    from_base10(InputValue div OutputBase, OutputBase, [(InputValue rem OutputBase) | OutputDigits]).
