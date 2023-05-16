#include "robot_simulator.h"

#include <string.h>

void execute_command(robot_status_t *robot, char command);
void advance(robot_status_t *robot);

robot_status_t robot_create(robot_direction_t direction, int x, int y) {
    return (robot_status_t) {
        .direction = direction,
        .position.x = x,
        .position.y = y
    };
}


void robot_move(robot_status_t *robot, const char *commands) {

    for (size_t i = 0; i < strlen(commands); i++) {
        execute_command(robot, commands[i]);
    }
}

void execute_command(robot_status_t *robot, char command) {

    switch(command) {
        case 'R': 
            robot -> direction = (robot -> direction + 1) % DIRECTION_MAX;
            break;
        case 'L': 
            robot -> direction = (robot -> direction + 3) % DIRECTION_MAX;
            break;
        case 'A':
            advance(robot);
            break;
    }
}

void advance(robot_status_t *robot) {

    switch(robot -> direction) {
        case DIRECTION_NORTH: 
            robot -> position.y++;
            break;
        case DIRECTION_EAST: 
            robot -> position.x++;
            break;
        case DIRECTION_SOUTH: 
            robot -> position.y--;
            break;
        case DIRECTION_WEST: 
            robot -> position.x--;
            break;
        default: 
            break;
    }
}