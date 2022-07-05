package uk.co.speedypos.epp_log_service.dtos;


import lombok.Getter;
import lombok.Setter;
import uk.co.speedypos.epp_log_service.enums.LogType;

/**
 * Responsible for transfer data between Log controllers and services layer.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
public class LogEntityDto extends BaseEntityDto {

    private String message;
    private LogType type;

}
