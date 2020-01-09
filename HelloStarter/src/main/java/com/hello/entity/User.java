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
 * @since 2020-01-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String title;

    private String description;

    private String password;

    private Integer permission;

    private Boolean isDeleted;

    private String ip;

    private Long authId;

    private LocalDateTime created;

    private Long createdBy;

    private LocalDateTime updated;

    private Long updatedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
