package com.getbullish.centralProcessingEngine.StaticData;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class LoadSectors {

  List<String> list = Arrays.asList("CONSUMER GOODS", "INDUSTRIAL MANUFACTURING",
      "CEMENT & CEMENT PRODUCTS", "METALS", "FINANCIAL SERVICES", "PHARMA", "CHEMICALS", "POWER",
      "SERVICES", "OIL & GAS", "CONSUMER SERVICES", "IT", "TEXTILES", "AUTOMOBILE",
      "HEALTHCARE SERVICES", "CONSTRUCTION", "FERTILISERS & PESTICIDES", "TELECOM",
      "PAPER AND JUTE", "MEDIA ENTERTAINMENT & PUBLICATION");
}
