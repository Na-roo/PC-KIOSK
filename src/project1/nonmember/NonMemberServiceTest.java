package project1.nonmember;

public class NonMemberServiceTest {

	public static void main(String[] args) throws Exception{
		
		NonMemberService nonMemberService = new NonMemberService();
		int a = nonMemberService.nonjoin(new Nonmember());
		int b	= nonMemberService.nonjoin(new Nonmember());
		System.out.println(nonMemberService.findByall());
		System.out.println("-----------------------------------------------------");
		System.out.println(nonMemberService.charge(23, 2400));
		System.out.println("-----------------------------------------------------");
		System.out.println(nonMemberService.findByno(20));
		
		System.out.println(a);
		System.out.println(b);
	}
}
