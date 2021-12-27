package io.github.nstdio.codesignal;

import java.util.regex.Pattern;

class Challenge {
    /**
     * Instacart customers are able to set the solution window during which they want to receive their groceries. There
     * are always plenty of shoppers in the area ready to take a customer's order, but unfortunately they can't always
     * do it right away. Before taking an order a shopper wants to ensure they will make it in time. They also don't
     * want to stay idle, so arriving early isn't an option either.
     * <p>
     * Our task is to implement an algorithm that determines whether shoppers should take the given order or not.
     * <p>
     * For each shopper you know their travel speed, distance to the store and the estimated amount of time they will
     * spend there. Figure out which of them can take the order, assuming it is known when the customer wants to receive
     * the groceries and the distance between their house and the store.
     * <p>
     * Example
     * <p>
     * For order = [200, 20, 15] and shoppers = [[300, 40, 5], [600, 40, 10]], the output should be
     * <p>
     * solution(order, shoppers) = [false, true].
     * <p>
     * The store is located 200 m away from the customer's house.
     * <p>
     * The customer will be ready to receive the groceries in 20 minutes, but they shouldn't be delivered more than 15
     * minutes late.
     * <p>
     * The first shopper is 300 m away from the store, his speed is 40 m/min, and he will spend 5 minutes in the store,
     * which means that he will need (300 + 200) / 40 + 5 = 17.5 minutes to fulfill the order. This will leave him with
     * 20 - 17.5 = 2.5 idle minutes, so he shouldn't take the order.
     * <p>
     * The second shopper is 600 m away from the store, his speed is 40 m/min, and he will spend 10 minutes in the
     * store, which means it will take him (600 + 200) / 40 + 10 = 30 minutes to fulfill the order. The customer can
     * wait for 20 + 15 = 35 minutes, which means that the shopper will make it in time.
     *
     * @param order    The order is given as an array of 3 positive integers. order[0] is the distance from the
     *                 customer's home to the store in meters, order[1] is the time by which the customer will be ready
     *                 to receive the delivery in minutes, and order[2] is the number of minutes they are willing to
     *                 wait.
     * @param shoppers Each element of this array represents a shopper. For each shopper three positive integers are
     *                 stored in the exact given order: their distance from the shop in meters, their speed in meters
     *                 per minute and the estimated time they will spend in the store in minutes.
     *
     * @return For each shopper return if they should take the order or not.
     */
    static boolean[] delivery(int[] order, int[][] shoppers) {
        boolean[] ret = new boolean[shoppers.length];
        for (int i = 0; i < shoppers.length; i++) {
            double fulfill = (shoppers[i][0] + order[0]) / (double) (shoppers[i][1]) + shoppers[i][2];
            ret[i] = order[1] <= fulfill && fulfill <= order[1] + order[2];
        }
        return ret;
    }

    /**
     * As part of an Instacart beta testing group, Sara is trying out a brand new feature that automatically estimates
     * the combined cost of the items in her handwritten shopping list. Her list contains both items and their prices.
     * All Sara has to do is snap a photo of her list with the Instacart app, and she gets a quick estimate of what
     * everything will cost.
     * <p>
     * Sara asked for your help, so it is up to you to devise an algorithm that calculates the cost after the image is
     * converted into plain text. All you need to do is extract all numbers from the given string items and sum them
     * up.
     * <p>
     * Example
     * <p>
     * For items = "Doughnuts, 4; doughnuts holes, 0.08; glue, 3.4", the output should be solution(items) = 7.48;
     * <p>
     * For items = "blue suit for 24$, cape for 12.99$ & glasses for 15.70", the output should be solution(items) =
     * 52.69.
     *
     * @param items A shopping list given as a string. It is guaranteed that the only numbers in it are dollar prices
     *              for different items. Note that although each price is given in dollars, you do not know their exact
     *              form. Each of them can either be an integer, or a decimal number with one or two decimal places and
     *              it may or may not be followed by a dollar sign. However, you may assume that if there is a period
     *              ('.') between two digits, then it's a decimal mark.
     *
     * @return The total cost of all items.
     */
    static double shoppingList(String items) {
        return Pattern.compile("\\d+(\\.\\d+)?")
                .matcher(items)
                .results()
                .mapToDouble(value -> Double.parseDouble(value.group()))
                .sum();
    }
}
