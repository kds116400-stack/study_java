package src.db;

/**
 * PathFile 인터페이스
 * - 사용자 데이터 파일 관련 경로 상수를 정의하는 역할을 한다.
 * - 이 인터페이스를 구현하거나, 상속(implements)받지 않더라도
 *   다른 클래스에서 "PathFile.PATH"로 쉽게 경로를 참조할 수 있다.
 */
public interface PathFile {
    /**
     * 사용자 데이터가 저장되는 디렉터리의 경로
     * - 모든 사용자(User) 정보 파일이 이 경로(폴더)에 저장된다.
     * - 사용자 정보를 등록, 수정, 삭제할 때 반드시 이 경로를 기준으로 파일을 읽고 쓴다.
     * - 경로는 하드코딩되어 있으며, 윈도우 환경의 절대경로로 작성되어 있다.
     *     (예: "C:/java/Bank/BankVer02/User/")
     * - 나중에 상대경로나 환경설정으로 관리할 수도 있으나,
     *   현재는 상수로만 제공한다.
     */
    public static final String PATH = "C:/java/Bank/BankVer02/User/";
}
