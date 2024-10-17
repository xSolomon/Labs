package org.example;

import java.util.Comparator;

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(final Human o1, final Human o2) {
        return o1.lastName.compareTo(o2.lastName);
    }
}