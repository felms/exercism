(** Minesweeper exercise *)

(** Lists all neighbors of a point *)
val get_neighbors : string list -> int -> int -> (int * int ) list 

(** Counts the mines in the neighborhood of a point*)
val count_mines : string list -> int -> int -> char

(** Annotate empty spots next to mines with the number of mines next to them. *)
val annotate : string list -> string list
