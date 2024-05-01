package com.green.boardver3.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.boardver3.common.model.Paging;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;

@Getter
@ToString
public class CommentPaging extends Paging {
    private long boardId;
//    @JsonIgnore
//    private long commentId;

//    @ConstructorProperties({"page","size","boardId"})
    //이름이 다를때 첫번째 , 두번째 , 세번째 매개변수가 무엇이다 란걸 정해주는 거
    public CommentPaging(Integer page, Integer size, long boardId) {
        super(page, size);
        this.boardId = boardId;
//        this.commentId = commentId;
    }
}
