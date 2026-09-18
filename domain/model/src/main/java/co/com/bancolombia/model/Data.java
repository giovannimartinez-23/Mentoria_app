package co.com.bancolombia.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Data {

    private int id;
    public Data() {
    }
    public Data(int id) {
        this.id = id;
    }

}
