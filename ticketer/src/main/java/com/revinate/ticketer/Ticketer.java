package com.revinate.ticketer;

import java.util.Collections;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.HashSet;

public class Ticketer {

    Set<String> tickets;
    //int setStartIndex = 1;

    /**
     * Create a new ticketer by setting the initial amount of available tickets.
     * A ticket should consist of a unique string.
     *
     * @param initialAmountOfTickets Number of tickets this ticketer will contain initially
     */
    public Ticketer(int initialAmountOfTickets) {
            tickets = new HashSet<String>();
        for (int i = 1; i <= initialAmountOfTickets; i++)
            tickets.add(String.valueOf(i));
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
    public synchronized Set<String> buy(int numberOfTickets) {
        if (tickets.size() == 0) return Collections.emptySet();
        Set<String> result = new LinkedHashSet<String>();
        if (numberOfTickets >= tickets.size()) {
            result.addAll(tickets);
            tickets.clear();
        }
        else {
            for (String s : tickets) {
                if (0 == numberOfTickets) break;
                result.add(s);
                --numberOfTickets;
            }
        }
        tickets.removeAll(result);
        return result;
    }
}
