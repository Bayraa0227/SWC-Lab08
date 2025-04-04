package frogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Refactor Task 2.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Records {
    private final List<String[]> records;

    public Records() {
        this.records = new ArrayList<>();
    }

    /**
     * Adds a frogger's record.
     *
     * @param firstName   first name of the frogger
     * @param lastName    last name of the frogger
     * @param phoneNumber phone number of the frogger
     * @param zipCode     zip code of the frogger
     * @param state       state of the frogger
     * @param gender      gender of the frogger
     * @return Return false if the record has existed. Else, return true.
     */
    public boolean addRecord(FroggerID id) {
        for (String[] row : this.records) {
            if (row[0].equals(id.firstName())
                    && row[1].equals(id.lastName())
                    && row[2].equals(id.phoneNumber())
                    && row[3].equals(id.zipCode())
                    && row[4].equals(id.state())
                    && row[5].equals(id.gender())) {
                return false;
            }
        }
        this.records.add(
                new String[] {
                        id.firstName(),
                        id.lastName(),
                        id.phoneNumber(),
                        id.zipCode(),
                        id.state(),
                        id.gender()
                });
        return true;
    }
}