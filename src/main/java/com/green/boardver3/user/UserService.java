package com.green.boardver3.user;

import com.green.boardver3.common.model.ResultDto;
import com.green.boardver3.user.model.ChangePasswordPatchReq;
import com.green.boardver3.user.model.SignInPostReq;
import com.green.boardver3.user.model.UserEntity;
import com.green.boardver3.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(UserPostReq p){
        String hashedPassword = BCrypt.hashpw(p.getUpw() , BCrypt.gensalt());
        p.setUpw(hashedPassword);
        return mapper.postUser(p);
    }

    public ResultDto<Long> postSignIn(SignInPostReq p) {
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null) {
            return ResultDto.<Long>builder()
                .statusCode(HttpStatus.NOT_FOUND)
                .resultMsg("아이디를 확인해주세요")
                .resultData(0L)
                .build();
        }else if(!BCrypt.checkpw(p.getUpw(), entity.getUpw())) {
            return ResultDto.<Long>builder()
                    .statusCode(HttpStatus.NOT_FOUND)
                    .resultMsg("비밀번호가 다릅니다")
                    .resultData(0L)
                    .build();
        }
//        //1 > 로그인 성공
//        //2 > 아이디를 확인해 주세요.
//        //3 > 비밀번호를 확인해 주세요.
//        String msg = switch (result) {
//            case 1 -> "로그인 성공";
//            case 2 -> "아이디를 확인해 주세요.";
//            case 3 -> "비밀번호를 확인해 주세요.";
//            default -> "알수 없는 에러 발생";
//        };
        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("로그인 성공")
                .resultData(entity.getUserId())
                .build();
    }

    public int patchPassword(ChangePasswordPatchReq p){
        UserEntity entity = mapper.getUserById(p.getUid());
        if(entity == null ) {return  2; }
        if(!BCrypt.checkpw(p.getCurrentPw() , entity.getUpw())) {
            return  3;
        }
        String hashedPassword =  BCrypt.hashpw(p.getNewPw() , BCrypt.gensalt());
        p.setNewPw(hashedPassword);
        p.setUserId(entity.getUserId());
        return mapper.patchPassword(p);
    }
}
