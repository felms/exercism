/// <reference path="./global.d.ts" />
//
// @ts-check

/**
 * Determine the prize of the pizza given the pizza and optional extras
 *
 * @param {Pizza} pizza name of the pizza to be made
 * @param {Extra[]} extras list of extras
 *
 * @returns {number} the price of the pizza
 */
export function pizzaPrice(pizza, ...extras) {
  let totalPrice = pizza === "Margherita" ? 7 
                    : pizza === "Caprese" ? 9 
                    : pizza === "Formaggio" ? 10
                    : 0;

  return extras.map(extra => extra === "ExtraSauce" ? 1 : extra === "ExtraToppings" ? 2 : 0)
    .reduce((sum, current) => sum + current, totalPrice);
}

/**
 * Calculate the prize of the total order, given individual orders
 *
 * @param {PizzaOrder[]} pizzaOrders a list of pizza orders
 * @returns {number} the price of the total order
 */
export function orderPrice(pizzaOrders) {

  return pizzaOrders.map(order => pizzaPrice(order.pizza, ...order.extras))
                  .reduce((sum, current) => sum + current, 0);

}
