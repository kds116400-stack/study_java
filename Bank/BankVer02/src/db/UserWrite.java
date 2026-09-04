package src.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * UserWrite 클래스
 * - User 객체를 지정된 파일(사용자별 폴더/file.txt)에 직렬화하여 저장하는 역할을 한다.
 * - 주로 사용자 정보 등록, 수정 시 호출되어 파일로 영구 저장을 담당한다.
 */
public class UserWrite {

    /**
     * 사용자 정보를 파일에 직렬화하여 저장하는 메서드
     * @param user 저장할 User 객체 (사용자 한 명의 계정/계좌 정보 포함)
     */
    public void writeInfo(User user){
        // 1. 저장 대상 경로: 사용자별 폴더 경로 + "file.txt" 파일 경로 문자열 생성
        //    예시: "C:/java/Bank/BankVer02/User/testuser/file.txt"
        String path = PathFile.PATH + user.getId() + "/file.txt";
        
        // 2. 사용자별 하위 폴더(아이디명) File 객체 생성
        //    만약 "testuser"란 사용자가 새롭게 생성되면 해당 폴더도 만들어야 한다.
        File dir = new File(PathFile.PATH + user.getId());
        
        // 3. 폴더가 존재하지 않으면(처음 쓰거나 신규 계정) 디렉토리 생성 (mkdirs: 중간 경로까지 모두 생성)
        if(!dir.exists()){
            dir.mkdirs();
        }
        
        // 4. try-with-resources(자동 close)로 파일 출력 스트림 생성
        try (
            // 4-1. FileOutputStream: "file.txt"에 바이너리로 데이터 기록
            FileOutputStream fos = new FileOutputStream(path);
            // 4-2. ObjectOutputStream: 객체를 직렬화하여 파일에 저장할 수 있도록 래핑
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            // 5. writeObject: User 객체 전체를 파일에 직렬화하여 기록
            oos.writeObject(user);
        } catch (Exception e) {
            // 6. 예외 발생 시(파일 접근권한, 직렬화 불가, 경로 문제 등) 스택 트레이스와 실패 메시지 출력
            e.printStackTrace();
            System.out.println("user 저장 실패");
        }
    }
}
