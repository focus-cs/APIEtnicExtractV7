package fr.sciforma.apietnic.business.provider;

import fr.sciforma.apietnic.business.model.FieldType;
import fr.sciforma.apietnic.business.model.SciformaField;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class TimesheetFieldProvider implements FieldProvider {

    private List<SciformaField> fields;

    @PostConstruct
    public void init() {
        fields = new ArrayList<>();
        fields.add(SciformaField.builder().name("Actual Effort").type(FieldType.EFFORT).build());
        fields.add(SciformaField.builder().name("actualEffortRework").displayName("Charge réelle (A réviser)").type(FieldType.EFFORT).build());
        fields.add(SciformaField.builder().name("actualEffortApproved").displayName("Charge réelle (Approuvée)").type(FieldType.EFFORT).build());
        fields.add(SciformaField.builder().name("actualEffortWorking").displayName("Charge réelle (En cours)").type(FieldType.EFFORT).build());
        fields.add(SciformaField.builder().name("actualEffortSubmitted").displayName("Charge réelle (Présentée)").type(FieldType.EFFORT).build());
        fields.add(SciformaField.builder().name("actualEffortReviewed").displayName("Charge réelle (Validée)").type(FieldType.EFFORT).build());
        fields.add(SciformaField.builder().name("ID").type(FieldType.STRING).build());
        fields.add(SciformaField.builder().name("Name").type(FieldType.STRING).build());
        fields.add(SciformaField.builder().name("Project Name").type(FieldType.STRING).build());
        fields.add(SciformaField.builder().name("Project IID").type(FieldType.DECIMAL_NO_PRECISION).build());
        fields.add(SciformaField.builder().name("Project Name").type(FieldType.STRING).build());
        fields.add(SciformaField.builder().name("Remaining Effort").type(FieldType.DECIMAL).build());
        fields.add(SciformaField.builder().name("Remaining Estimate").type(FieldType.DURATION).build());
        fields.add(SciformaField.builder().name("Resource").type(FieldType.STRING).build());
        fields.add(SciformaField.builder().name("Resource IID").type(FieldType.DECIMAL_NO_PRECISION).build());
        fields.add(SciformaField.builder().name("Start").type(FieldType.DATE).build());
        fields.add(SciformaField.builder().name("Status").type(FieldType.STRING).build());
        fields.add(SciformaField.builder().name("Task IID").type(FieldType.DECIMAL_NO_PRECISION).build());
    }

}
