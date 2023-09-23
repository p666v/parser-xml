package parserSAX.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CompactDisc {
    private final String title;
    private final String artist;
    private final String country;
    private final String company;
    private final double price;
    private final int year;

}
