package com.green.boardver3.board;

import com.green.boardver3.board.model.*;
import com.green.boardver3.common.model.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("board")
@Tag(name = "Board (게시판)", description = "게시판 CRUD")
public class BoardController {
    private final BoardService service;


    @PostMapping
    @Operation(summary = "게시글 등록" , description = "게시글 등록을 할 수 있습니다.")
    public ResultDto<Long> postBoard(@RequestBody BoardPostReq p) {
        log.info("p의 파라미터: {}" , p); //BoardPostReq에 tostring
        long result = service.postBoard(p);

        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }

    @GetMapping
    public ResultDto<List<BoardGetRes>> getBoardList(@ModelAttribute BoardGetReq p) {
        List<BoardGetRes> list = service.getBoardList(p);

        return ResultDto.<List<BoardGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(String.format("rowCount: %d", list.size()))
                .resultData(list).build();
    }
//@PathVariable을 쓴 이유 위의 getmapping이 있어서 구분 짓기위해

    @GetMapping("{boardId}")//매개변수랑 이름 같으면 자동으로 매칭
    public ResultDto<BoardDetailGetRes> getBoardOne(@PathVariable long boardId) {
        BoardDetailGetRes result = service.getBoardOne(boardId);

        return ResultDto.<BoardDetailGetRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(result == null ? "내용을 찾을 수 없습니다." : HttpStatus.OK.toString())
                .resultData(result).build();
    }

    @PutMapping
    public ResultDto<Integer> putBoard(@RequestBody BoardPutReq p) {
        int result = service.putBoard(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }

    @DeleteMapping
    @Operation(summary = "게시글 삭제" , description = "게시글 삭제를 할 수 있습니다.")
    public ResultDto<Integer> deleteBoard(@RequestParam(name = "board_id") long boardId) {
        int result = service.deleteBoard(boardId);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }
}
//리퀘스트 바디: 바디에 정보를 숨기고 싶을때 사용 (속도가 느림) 제이슨
//모델 아트리뷰트: url에 정보가 다 뜸 (속도가 더 빠름) 쿼리 스트링
//페이지 사이즈  굳이 바디에 받을 필요가 없다 ㅇㅇㅇㅇㅇㅇㅇㅇㅇ