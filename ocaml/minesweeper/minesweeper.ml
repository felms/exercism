let get_neighbors (board : string list) (r : int) (c : int) = 
    [(r - 1, c); (r + 1, c); (r, c - 1); (r, c + 1);
     (r - 1, c - 1); (r - 1, c + 1); (r + 1, c - 1); (r + 1, c + 1)]
    |> List.filter(fun (row, col) -> row >= 0 && row < (List.length board) 
    && col >= 0 && col < (String.length (List.hd board)))
;;

let count_mines (board : string list) (r : int) (c : int) =
    String.get 
        (List.length 
            (List.filter 
                (fun (row, col) -> (List.nth board row).[col] == '*') 
                (get_neighbors board r c)) 
            |> string_of_int) 
        0
;;

let annotate (grid : string list) =
    List.mapi 
        (fun r row -> 
            String.mapi (fun c ch -> if ch = '*' then ch else (count_mines grid r c)) row
            |> String.map (fun ch -> if ch = '0' then ' ' else ch))
        grid
;;

