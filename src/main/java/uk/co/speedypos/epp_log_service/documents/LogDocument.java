package uk.co.speedypos.epp_log_service.documents;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import uk.co.speedypos.epp_log_service.enums.LogType;

@Document("logs")
@Data
@EqualsAndHashCode(callSuper = true)
public class LogDocument extends BaseDocument {

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field(name = "log_type")
    private LogType logType;

    @Field(name = "user_id")
    private String userId;

    @Field(name = "platform_id")
    private String platformId;

    @Field(name = "module_id")
    private String moduleId;

}
