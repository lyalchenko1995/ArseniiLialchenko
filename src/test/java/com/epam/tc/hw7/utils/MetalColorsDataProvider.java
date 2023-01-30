package com.epam.tc.hw7.utils;

import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class MetalColorsDataProvider {

    public static Map<String, MetalsColorsJsonDTO> getDTOfromJson() throws Exception {
        HashMap<String, MetalsColorsJsonDTO> map;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(MetalColorsDataProvider.class.getClassLoader().getResource("JDI_ex8_metalsColorsDataSet.json"),
                    new TypeReference<HashMap<String, MetalsColorsJsonDTO>>() {
            });
        } catch (Exception e) {
            throw new Exception("Incorrect file");
        }
        return map;
    }

    @DataProvider(name = "json")
    public Object[][] dataProvider() throws Exception {
        Map<String, MetalsColorsJsonDTO> mapFromJson = MetalColorsDataProvider.getDTOfromJson();
        mapFromJson.size();
        Object[][] objectMap = new Object[mapFromJson.size()][5];
        int i = 0;
        for (Map.Entry<String, MetalsColorsJsonDTO> entry : mapFromJson.entrySet()) {
            entry.getValue();
            objectMap[i][0] = entry.getValue().getSummary();
            objectMap[i][1] = entry.getValue().getElements();
            objectMap[i][2] = entry.getValue().getColor();
            objectMap[i][3] = entry.getValue().getMetals();
            objectMap[i][4] = entry.getValue().getVegetables();
            i++;
        }
        return objectMap;
    }
}
