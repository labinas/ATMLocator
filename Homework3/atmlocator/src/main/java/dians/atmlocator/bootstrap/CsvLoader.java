package dians.atmlocator.bootstrap;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import dians.atmlocator.model.Atm;
import dians.atmlocator.repository.AtmRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component
public class CsvLoader {

    private final AtmRepository atmRepository;

    public CsvLoader(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    //@PostConstruct
    public void init(){
        try {
            Map<String,String> map = new HashMap<String, String>();
            map.put("open_street_id", "openStreetId");
            map.put("lat", "lat");
            map.put("lon", "lon");
            map.put("amenity", "amenity");
            map.put("int_name", "intName");
            map.put("name", "name");
            map.put("name_en", "nameEn");
            map.put("operator", "operator");
            map.put("addr_city", "addrCity");
            map.put("addr_city_en", "addrCityEn");
            map.put("addr_street", "addrStreet");
            map.put("addr_housenumber", "addrHouseNumber");
            map.put("addr_postcode", "addrPostcode");
            map.put("opening_hours", "openingHours");
            map.put("wheelchair", "wheelchair");

            HeaderColumnNameTranslateMappingStrategy<Atm> strategy =
                    new HeaderColumnNameTranslateMappingStrategy<Atm>();
            strategy.setColumnMapping(map);
            strategy.setType(Atm.class);

            FileReader fileReader = new FileReader("src/main/resources/ATMs_SK.csv");
            CsvToBean<Atm> csvToBean = new CsvToBeanBuilder<Atm>(fileReader)
                    .withType(Atm.class)
                    .withSeparator(',')
                    .withMappingStrategy(strategy)
                    .build();
            List<Atm> list = csvToBean.parse();

            for (Atm e : list) {
                System.out.println(e);
                atmRepository.save(e);
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
