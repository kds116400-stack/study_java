package src.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.HashSet;

/**
 * UserRead 클래스
 * - PATH 경로(폴더)에 존재하는 모든 사용자(User) 객체 정보를 읽어와 저장/조회할 수 있는 클래스
 * - 개별 User 객체의 역직렬화를 통해 사용자 정보 로딩 및 검색 지원
 */
public class UserRead {
    // User 객체를 저장할 Set 컬렉션 (중복 x, HashSet 사용)
    private Set<User> set; 

    /**
     * 생성자
     * - 지정된 사용자 데이터 경로에서 개별 사용자 폴더에 있는 file.txt(직렬화 User 객체 저장 파일)를 모두 읽어
     *   Set<User>에 로딩함
     */
    public UserRead(){
        set = new HashSet<>(); // User 객체를 모을 HashSet 생성
        File dir = new File(PathFile.PATH); // PathFile 인터페이스의 사용자 폴더 경로 객체 생성

        // 해당 경로의 디렉토리/파일 목록을 File[] 배열로 가져옴
        File[] userDirs = dir.listFiles(); 

        // NullPointerException 방지: 파일 목록이 null이 아니면 반복 시작
        if(userDirs != null){
            for (File file : userDirs) {
                // file이 폴더(디렉토리)인지, 실제로 존재하는지 체크 (아닐 경우 continue)
                if(!file.isDirectory() || !file.exists()){
                    continue; // 다음 파일로 넘어감
                }
                // 사용자마다 개별 폴더 내에 "file.txt"가 있다고 가정, 해당 파일의 File 객체 생성
                File userFile = new File(file, "file.txt"); 

                // file.txt 파일을 읽어서 User 객체로 역직렬화 시도
                try (
                    FileInputStream fis = new FileInputStream(userFile);   // file.txt 파일 읽기 위한 스트림
                    ObjectInputStream ois = new ObjectInputStream(fis)     // 객체 단위로 읽기
                ) {
                    // 객체 단위로 읽어, User 타입으로 다운캐스팅 (직렬화된 객체이므로)
                    User user = (User) ois.readObject();
                    set.add(user); // 읽은 User 객체를 Set에 추가

                } catch (Exception e) {
                    // 파일이 없거나, 역직렬화 오류, 타입 오류 등이 발생할 수 있으므로 예외 발생 시 스택트레이스 출력
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 아이디로 사용자(User) 객체를 검색
     * @param id 찾으려는 사용자의 아이디(문자열)
     * @return 해당 아이디의 User 객체가 있으면 반환, 없으면 null 반환
     */
    public User findById(String id){
        for (User u : set) {
            // User 객체의 getId 메서드로 아이디 비교 (equals 사용)
            if(u.getId().equals(id)){
                return u; // 일치하는 객체 발견 시 바로 반환
            }
        }
        return null; // 일치하는 객체가 하나도 없으면 null 반환
    }

    /**
     * 계좌번호로 사용자(User) 객체를 검색
     * @param account 찾으려는 계좌번호(int)
     * @return 해당 계좌번호의 User 객체가 있으면 반환, 없으면 null 반환
     */
    public User findByAccount(int account){
        for (User u : set) {
            if(u.getAccountNumber() == account){
                return u; // 동일 계좌번호 발견 시 반환
            }
        }
        return null; // 없으면 null 반환
    }

    /**
     * 현재 메모리에 로딩되어 있는 모든 User 객체 반환
     * @return Set<User> 전체 사용자 정보 집합(불변 아님)
     */
    public Set<User> findAll() {
        return set;
    }
}
