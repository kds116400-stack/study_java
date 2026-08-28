package ex1_objstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserWriter {

    FileOutputStream fos = null;
    ObjectOutputStream oos = null;

    public void writeInfo(User user) {

        String path = "C:/myFile/User/" + user.getTel() + "/save.sav";
        File dir1 = new File("C:/myFile/User/");

        if (!dir1.exists()) {
            dir1.mkdirs();
        }

        File dir2 = new File(dir1, user.getTel());

        if (!dir2.exists()) {
            dir2.mkdir();
        }
        try {

            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);

            // user객체를 통째로 저장
            oos.writeObject(user);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("유저정보 저장 실패");

        } finally {

            try {

                if (oos != null)
                    oos.close();
                if (fos != null)
                    fos.close();

            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

}
