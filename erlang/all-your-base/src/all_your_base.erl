-module(all_your_base).

-export([rebase/3]).


rebase([], _InputBase, _OutputBase) -> {ok, [0]};

rebase(Digits, InputBase, OutputBase) -> 
    base10 = convert_to_base_10(Digits, InputBase),
    res = convert_from_base_10(base10, OutputBase, []),
    {ok, res}.

convert_to_base_10(Digits, InputBase) -> 
    rev = lists:reverse(Digits),
    with_index = lists:enumerate(0, 1, rev),

    res = lists:foldl(fun({index, digit}, acc) -> digit * trunc(math:pow(InputBase, index)) + acc end, 0, with_index),

    res.

convert_from_base_10(0, _OutputBase, []) -> [0];
convert_from_base_10(0, _OutputBase, res) -> res;
convert_from_base_10(Number, OutputBase, res) -> 
    convert_from_base_10((Number div OutputBase), OutputBase, [(Number rem OutputBase) | res]).


        

