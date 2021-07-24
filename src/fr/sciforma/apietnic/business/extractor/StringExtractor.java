package fr.sciforma.apietnic.business.extractor;

import com.sciforma.psnext.api.FieldAccessor;
import com.sciforma.psnext.api.PSException;
import org.pmw.tinylog.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringExtractor implements Extractor<String> {

    @Value("${csv.delimiter}")
    protected String csvDelimiter;
    @Value("${csv.delimiter.replacewith: }")
    protected String csvDelimiterReplaceWith;

    @Override
    public Optional<String> extractAsString(FieldAccessor fieldAccessor, String fieldName) {

        try {

            return Optional.of(fieldAccessor.getStringField(fieldName)
                    .replaceAll("\\r\\n|\\r|\\n|\\t", " ")
                    .replaceAll(String.format("\\%s", csvDelimiter), csvDelimiterReplaceWith)
                    .trim());

        } catch (PSException e) {
            Logger.error(e, "Failed to retrieve string value from field " + fieldName);
        }

        return Optional.empty();
    }

    @Override
    public Optional<String> extract(FieldAccessor fieldAccessor, String fieldName) {
        return extractAsString(fieldAccessor, fieldName);
    }

}
