package uk.co.speedypos.epp_log_service.listeners;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import uk.co.speedypos.epp_log_service.documents.BaseDocument;

import java.util.UUID;

import static uk.co.speedypos.epp_log_service.helpers.DateTimeHelper.getInstantNow;

@Component
public class BaseDocumentListener extends AbstractMongoEventListener<BaseDocument> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseDocument> event) {

        var document = event.getSource();

        // If the document is new.
        if (document.getId() == null) {
            document.setUuid(document.getUuid() == null ? UUID.randomUUID() : document.getUuid());
            document.setIsTrashed(false);
            document.setTotalModifyCount(0L);
            document.setCreatedTimestamp(getInstantNow());
            document.setLastModifiedTimestamp(null);
            document.setTrashedTimestamp(null);
        }

        // If the document is being updated.
        else {
            document.setTotalModifyCount(document.getTotalModifyCount() + 1);
            document.setLastModifiedTimestamp(getInstantNow());

            // If the document is trashed.
            if (document.getIsTrashed()) {
                document.setTrashedTimestamp(getInstantNow());
            }
        }

        super.onBeforeConvert(event);
    }
}
