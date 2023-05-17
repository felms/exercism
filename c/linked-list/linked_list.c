#include "linked_list.h"

#include <stdlib.h>
#include <stdbool.h>

struct list_node {
   struct list_node *prev, *next;
   ll_data_t data;
};

struct list {
   struct list_node *first, *last;
   size_t size;
};

// constructs a new (empty) list
struct list *list_create(void) {
   
   struct list *new_list = malloc(sizeof(struct list));

   if (!new_list) {
      return NULL;
   }

   new_list -> size = 0;
   new_list -> first = NULL;
   new_list -> last = NULL;

   return new_list;
}

// counts the items on a list
size_t list_count(const struct list *list) {
   return list -> size;
}

// inserts item at back of a list
void list_push(struct list *list, ll_data_t item_data) {

   // Crio o nó
   struct list_node *node = malloc(sizeof(struct list_node));

   // Atualizo os ponteiros do nó
   node -> data = item_data;
   node -> next = NULL;

   // Atualizo os ponteiros da lista
   if (list -> size == 0) {
      list -> first = node;
      list -> last = node;
   } else {
      node -> prev = list -> last;
      list -> last -> next = node;
      list -> last = node;
   }

   // Incremento o tamanho da lista
   list -> size++;
}

// removes item from back of a list
ll_data_t list_pop(struct list *list) {
   
   // Pego o ultimo nó
   struct list_node *node = list -> last;

   // Atualizo os ponteiros da lista
   if (list -> size > 1) {
      list -> last = list -> last -> prev;
      list -> last -> next = NULL;
   } else {
      list -> first = NULL;
      list -> last = NULL;
   }

   // Atualizo o tamanho da lista
   list -> size--;

   // Pego os dados do nó retirado
   ll_data_t item = node -> data;

   // Libero a memória
   free(node);


   return item;
}

// inserts item at front of a list
void list_unshift(struct list *list, ll_data_t item_data) {

   // Crio o nó
   struct list_node *node = malloc(sizeof(struct list_node));

   // Atualizo os ponteiros do nó
   node -> data = item_data;
   node -> prev = NULL;

   // Atualizo os ponteiros da lista
   if (list -> size == 0) {
      list -> first = node;
      list -> last = node;
   } else {
      node -> next = list -> first;
      list -> first -> prev = node;
      list -> first = node;
   }

   // Incremento o tamanho da lista
   list -> size++;
}

// removes item from front of a list
ll_data_t list_shift(struct list *list) {
   
   // Pego o primeiro nó
   struct list_node *node = list -> first;

   // Atualizo os ponteiros da lista
   if (list -> size > 1) {
      list -> first = list -> first -> next;
      list -> first -> prev = NULL;
   } else {
      list -> first = NULL;
      list -> last = NULL;
   }


   // Atualizo o tamanho da lista
   list -> size--;

   // Pego os dados do nó retirado
   ll_data_t item = node -> data;

   // Libero a memória
   free(node);

   return item;

}

// deletes a node that holds the matching data
void list_delete(struct list *list, ll_data_t data) {

   // Se o elemento for o primeiro item da lista
   if (list -> first -> data == data) {
      list_shift(list);
      return;
   } 

   // Descubro a localização do nó e pego o mesmo
   struct list_node *node = NULL;
   struct list_node *current_node = list -> first;
   bool found = false;
   while (current_node -> next != NULL) {
      if (current_node -> data == data) {
         node = current_node;
         found = true;
         break;
      }
      
      current_node = current_node -> next;
   }

   // Se elemento for o último item da lista
   if (current_node -> next == NULL && current_node -> data == data) {
      list_pop(list);
      return;
   }

   // Caso o item não tenha sido encontrado
   if (!found) {
      return;
   }

   // Pego ponteiros para o anterior e o posterior
   struct list_node *previous_node = node -> prev;
   struct list_node *next_node = node -> next;

   // Atualizo os ponteiros do anterior e do posterior
   previous_node -> next = next_node;
   next_node -> prev = previous_node;

   // Atualizo o tamanho da lista
   list -> size--;

   // Excluo o nó
   free(node);

}

// destroys an entire list
// list will be a dangling pointer after calling this method on it
void list_destroy(struct list *list) {
   free(list);
   list = NULL;
}