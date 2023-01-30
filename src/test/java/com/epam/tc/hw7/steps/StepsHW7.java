package com.epam.tc.hw7.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.TestData;
import com.epam.tc.hw7.SiteJdi;
import com.epam.tc.hw7.entities.MetalsColorsJsonDTO;

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
        checkResultSection(dto);
    }

    public static void checkResultSection(MetalsColorsJsonDTO dto) {
        String expectedSummary = "Summary: " + String.valueOf(dto.getSummary().get(0) + dto.getSummary().get(1));
        assertThat(SiteJdi.metalsColorsPage.metalsColorsLogForm.result.get(1).getText()).isEqualTo(expectedSummary);

        for (String str : dto.getElements()) {
            assertThat(SiteJdi.metalsColorsPage.metalsColorsLogForm.result.get(2).getText()).contains(str);
        }

        assertThat(SiteJdi.metalsColorsPage.metalsColorsLogForm.result.get(3).getText())
                .isEqualTo("Color: " + dto.getColor());

        assertThat(SiteJdi.metalsColorsPage.metalsColorsLogForm.result.get(4).getText())
                .isEqualTo("Metal: " + dto.getMetals());

        for (String str : dto.getVegetables()) {
            assertThat(SiteJdi.metalsColorsPage.metalsColorsLogForm.result.get(5).getText()).contains(str);
        }
    }
}
