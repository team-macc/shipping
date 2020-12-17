package com.teammacc.shipping.data.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"shippingCost", "deliveryEstimated"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShippingVO extends RepresentationModel<ShippingVO> implements Serializable {

    @JsonProperty("shippingCost")
    private Double shippingCost;

    @JsonProperty("deliveryEstimated")
    private Integer deliveryEstimated;
}
