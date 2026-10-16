package co.com.bancolombia.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ObjectResponse {

    private String state;

}
