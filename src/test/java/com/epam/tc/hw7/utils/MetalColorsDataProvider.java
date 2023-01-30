package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entities.DTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MetalColorsDataProvider {

    private static final String PATH = "src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    public static Map<String, DTO> getDTOfromJson() {
        HashMap<String, DTO> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(new File(PATH), new TypeReference<HashMap<String, DTO>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
