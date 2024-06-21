const std = @import("std");
const mem = std.mem;

pub fn isBalanced(allocator: mem.Allocator, s: []const u8) !bool {

    var stack = try allocator.alloc(u8, s.len);
    defer allocator.free(stack);
    var pos: u32  = 0;

    for (s) |current_char| {
        if ((current_char == '(') or (current_char == '{') or (current_char == '[')) {
            stack[pos] = current_char;
            pos += 1;
        } else if ((current_char == ')') or (current_char == '}') or (current_char == ']')) {

            if (pos == 0) {
                return false;
            }

            pos -= 1;

            if ((current_char == ')' and stack[pos] != '(') 
                or (current_char == '}' and stack[pos] != '{') 
                or (current_char == ']' and stack[pos] != '[')) {
                return false;
            }

        }       
    }

    return pos == 0;
}
