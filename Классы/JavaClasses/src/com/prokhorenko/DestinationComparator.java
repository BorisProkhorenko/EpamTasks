package com.prokhorenko;

import java.util.Comparator;

public class DestinationComparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
        int nameIndex=o1.getDestinationName().compareTo(o2.getDestinationName());
        if(nameIndex==0)
            return o1.getDepartureTime().compareTo(o2.getDepartureTime());
        return nameIndex;
    }
}
