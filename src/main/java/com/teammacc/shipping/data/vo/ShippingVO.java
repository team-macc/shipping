package com.teammacc.shipping.data.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShippingVO implements Serializable {
    private Double shippingCost;
    private Integer deliveryEstimated;
}
