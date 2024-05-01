package com.green.boardver3.board.model;

import com.green.boardver3.comment.model.CommentGetRes;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BoardDetailGetRes {
    private long boardId;
    private String title;
    private String contents;
    private long writerId;
    private String writerNm;
    private int hits;
    private String createdAt;
    private int totalCommentPage;
    private List<CommentGetRes> comments; //내용 없을때 null 안뜨게 new arraylist
}
