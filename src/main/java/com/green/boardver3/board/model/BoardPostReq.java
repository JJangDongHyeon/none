package com.green.boardver3.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardPostReq {
    @JsonIgnore
    private long boardId;
    @Schema(example = "제목 테스트" , description = "글 제목", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;
    @Schema(example = "내용 테스트" , description = "글 내용", requiredMode = Schema.RequiredMode.REQUIRED)
    private String contents;

//    @JsonProperty("writer_id") // 받아오는것과 넘기는것의 이름이 다를 때 변경가능 제이슨만됨 쿼리스트링으로 넘기는건 x
    //쿼리스트링은 @Bindparam , @ConstructorProperty
    //Schema name = writer_name 으로 할시  받는값도 writer_id로 받아와서 에러 터짐
    @Schema(example = "1" , description = "유저 PK", requiredMode = Schema.RequiredMode.REQUIRED)
    private long writerId;
}
