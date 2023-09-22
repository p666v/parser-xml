package parserSAX.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CompactDisc {
    private String title;
    private String artist;
    private String country;
    private String company;
    private double price;
    private int year;

}
