package com.green.boardver3.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordPatchReq {
    @JsonIgnore
    private long userId;
    private String uid;
    private String currentPw;
    private String newPw;

}
