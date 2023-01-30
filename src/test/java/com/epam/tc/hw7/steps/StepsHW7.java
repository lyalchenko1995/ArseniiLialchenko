package com.epam.tc.hw7.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.TestData;
import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;
import java.util.List;

public class StepsHW7 {

    public static void loginJDI() {
        SiteJdi.openHomePage();
        SiteJdi.login(TestData.ROMAN);
        SiteJdi.homePageJdi.checkUserLoggedIn(TestData.ROMAN);
    }

    public static void navigateToMetalsColorsPage() {
        SiteJdi.homePageJdi.openMetalsColorsPage();
    }

    public static void checkMetalsColorsForm(MetalsColorsJsonDTO dto) {
        SiteJdi.metalsColorsPage.metalsColorsForm.selectSummary(dto.getSummary());
        SiteJdi.metalsColorsPage.metalsColorsForm.selectElements(dto.getElements());
        SiteJdi.metalsColorsPage.metalsColorsForm.selectColors(dto.getColor());
        SiteJdi.metalsColorsPage.metalsColorsForm.selectMetals(dto.getMetals());
        SiteJdi.metalsColorsPage.metalsColorsForm.selectVegetables(dto.getVegetables());
        SiteJdi.metalsColorsPage.metalsColorsForm.submit();
        checkResultSection(dto, SiteJdi.metalsColorsPage.metalsColorsLogForm.getLogList());
    }

    public static void checkResultSection(MetalsColorsJsonDTO dto, List<String> logLost) {
        String expectedSummary = "Summary: " + String.valueOf(dto.getSummary().get(0) + dto.getSummary().get(1));
        assertThat(logLost.get(0)).isEqualTo(expectedSummary);

        for (String str : dto.getElements()) {
            assertThat(logLost.get(1).contains(str));
        }

        assertThat(logLost.get(2)).isEqualTo("Color: " + dto.getColor());

        assertThat(logLost.get(3)).isEqualTo("Metal: " + dto.getMetals());

        for (String str : dto.getVegetables()) {
            assertThat(logLost.get(4)).contains(str);
        }
    }
}
