package com.hello.entity;

import java.time.LocalDateTime;
import com.hello.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ding
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Log extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer ops;

    private String tableName;

    private String summary;

    private String ip;

    private Long authId;

    private Long createdBy;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
