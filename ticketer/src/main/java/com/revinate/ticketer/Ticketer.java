package com.revinate.ticketer;

import java.util.Collections;
import java.util.Set;

public class Ticketer {

    /**
     * Create a new ticketer by setting the initial amount of available tickets.
     * A ticket should consist of a unique string.
     *
     * @param initialAmountOfTickets Number of tickets this ticketer will contain initially
     */
    public Ticketer(int initialAmountOfTickets) {
    }

    /**
     * Buys a certain number of tickets. If the number of available tickets is smaller than the
     * number of tickets to buy, then all the remaining tickets are sold.
     * <p>
     * This method should return empty if there are no tickets available.
     * <p>
     *
     * @param numberOfTickets The number of tickets to buy
     * @return The purchased tickets
     */
    public Set<String> buy(int numberOfTickets) {
    }
}
