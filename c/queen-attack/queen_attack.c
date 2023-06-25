#include "queen_attack.h"



attack_status_t can_attack(position_t queen_1, position_t queen_2) {

   if ((queen_1.row == queen_2.row && queen_1.column == queen_2.column) 
         || (queen_1.row > 7 || queen_2.row > 7 || queen_1.column > 7 || queen_2.column > 7)) { 

      return INVALID_POSITION;
   }

   // Mesma linha ou mesma coluna 
   if (queen_1.row == queen_2.row
       || queen_1.column == queen_2.column) { 

      return CAN_ATTACK;
   }

   // Diagonais secundarias
   if (queen_1.row + queen_1.column == 
         queen_2.row + queen_2.column) {

      return CAN_ATTACK;
   }

   // Diagonais principais
   if (queen_1.row - queen_1.column == 
         queen_2.row - queen_2.column) {

      return CAN_ATTACK;
   }

   return CAN_NOT_ATTACK;

}
