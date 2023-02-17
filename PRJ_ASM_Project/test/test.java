
import DAO.SinhVienDAO;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.SinhVien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String phone = sc.nextLine();
            Pattern pe = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
            if(pe.matcher(phone).find()){
                System.out.println("Oke");
            }else{
                System.out.println("Not Oke");
            }
        }
    }
}
