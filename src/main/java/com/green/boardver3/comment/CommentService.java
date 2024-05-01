package com.green.boardver3.comment;

import com.green.boardver3.comment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper mapper;

    public int postComment(CommentPostReq p){
        return mapper.postComment(p);
    };
    public int deleteComment(CommentDeleteReq p) {
        return mapper.deleteComment(p);
    }
    public int putComment(CommentPutReq p){
        return mapper.putComment(p);
    }
    public List<CommentGetRes> getComments(CommentPaging p){
        return mapper.getComments(p);
    }
    public int getCommentCount(long boardId){
        return mapper.getCommentCount(boardId);
    }

}
