package cs;

public class StringConstantPool {
    public static void main(String[] args) {
        String string1 = "test";
        String newString1 = "test";
        String test = new String("test");
//        System.out.println(string1.equals(newString1));

        //intern()는 해당 String과 동등한 String객체가 이미 String pool에 존재 시 그 객체를 그대로 리턴한다.
        //아니라면  호출된 String객체를 String pool에 추가하며 객체의 참조를 리턴한다.
        String internString = newString1.intern();

//        String testString = test.intern();
        test = test.intern();

//        System.out.println(testString);
//
//        System.out.println(internString==newString1);
//        System.out.println(internString.equals(string1));

        System.out.println(internString==test);
//        System.out.println(test==testString);
    }
}
