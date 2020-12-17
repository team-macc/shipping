package com.teammacc.shipping.controller;

import com.teammacc.shipping.data.vo.ShippingVO;
import com.teammacc.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping(value = "/{cep}")
    public ShippingVO findShipping(@PathVariable("cep") String cep) {
        return shippingService.findShipping(cep);
    }
}
