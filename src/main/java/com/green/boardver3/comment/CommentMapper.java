package com.green.boardver3.comment;

import com.green.boardver3.comment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int postComment(CommentPostReq p);
    int deleteComment(CommentDeleteReq p);
    int putComment(CommentPutReq p);
    List<CommentGetRes> getComments(CommentPaging p);
    int getCommentCount(long boardId);
    int getTotalCommentPage(CommentPaging p);//셀렉트 할건데 리턴타입이 인트인 이유:스칼라값 넘엉옴
}
