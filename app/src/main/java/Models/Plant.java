package Models;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

/**
 * Created by Razvan on 3/17/2016.
 */
public class Plant {
    String name;
    String scientificName;
    String description;
    String contraindications;
    String disease;
    String preparation;

    public void initWithDictionary(Map<String, String> data) {
        name = data.get("name");
        scientificName = data.get("scientificName");
        description = data.get("description");
        contraindications = data.get("contraindications");
        disease = data.get("disease");
        preparation = data.get("preparation");
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() {
        return description;
    }

    public String getContraindications() {
        return contraindications;
    }

    public String getDisease() {
        return disease;
    }

    public String getPreparation() {
        return preparation;
    }
}


