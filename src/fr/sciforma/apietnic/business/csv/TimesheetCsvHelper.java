package fr.sciforma.apietnic.business.csv;

import fr.sciforma.apietnic.business.model.SciformaField;
import fr.sciforma.apietnic.business.provider.TimesheetFieldProvider;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class TimesheetCsvHelper extends AbstractCsvHelper {

    @Value("${filename.timesheets}")
    private String filename;

    @Autowired
    private TimesheetFieldProvider fieldProvider;

    @Override
    protected List<String> getHeader() {

        List<String> header = new ArrayList<>();

        header.add(START_HEADER);
        header.add(FINISH_HEADER);

        for (SciformaField sciformaField : fieldProvider.getFields()) {
            if(sciformaField.getDisplayName() != null) {
                header.add(sciformaField.getDisplayName());
            } else {
                header.add(sciformaField.getName());
            }
        }

        return header;
    }

}
