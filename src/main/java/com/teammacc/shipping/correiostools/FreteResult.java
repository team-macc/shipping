package com.teammacc.shipping.correiostools;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FreteResult {
    private Map<Integer, FreteResultItem> servicos = new HashMap<Integer, FreteResultItem>();

    public void addServico(FreteResultItem item) {
        servicos.put(item.getCodigo(), item);
    }

    public FreteResultItem getServico(Integer codigo) {
        return servicos.get(codigo);
    }
}